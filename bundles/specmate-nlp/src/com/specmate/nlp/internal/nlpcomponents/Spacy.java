package com.specmate.nlp.internal.nlpcomponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import com.specmate.common.exception.SpecmateInternalException;
import com.specmate.model.administration.ErrorCode;
import com.specmate.rest.RestClient;
import com.specmate.rest.RestResult;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.POS;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.Dependency;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.DependencyFlavor;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.ROOT;

public class Spacy extends JCasAnnotator_ImplBase {

	// Variables for REST Call (Spacy API)
	public static final String PARAM_SPACY_URL = "spacy_url";
	@ConfigurationParameter(name = PARAM_SPACY_URL, mandatory = false, defaultValue = "http://127.0.0.1:80")
	protected String SPACY_API_BASE_URL = "http://127.0.0.1:80";

	public static final java.lang.String PARAM_MODEL = "model";
	@ConfigurationParameter(name = PARAM_MODEL, mandatory = false, description = "Use this spacy model.")
	protected String spacyModel;

	private static final int TIMEOUT = 5000;

	private LogService logService;

	public Spacy() {
		BundleContext context = FrameworkUtil.getBundle(Spacy.class).getBundleContext();
		ServiceTracker<LogService, LogService> logServiceTracker = new ServiceTracker<>(context, LogService.class,
				new ServiceTrackerCustomizer<>() {

					@Override
					public LogService addingService(ServiceReference<LogService> reference) {
						logService = context.getService(reference);
						return logService;
					}

					@Override
					public void modifiedService(ServiceReference<LogService> reference, LogService service) {
					}

					@Override
					public void removedService(ServiceReference<LogService> reference, LogService service) {
					}
				});
		logServiceTracker.open();
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		String text = jcas.getDocumentText();

		// Call Spacy API
		JSONArray result = null;

		try {
			result = accessSpacyAPI(text);
		} catch (SpecmateInternalException e) {
			throw new AnalysisEngineProcessException(e);
		}

		List<SpacyModel> models = buildSpacyModel(result);

		int startIndex = 0;
		for (SpacyModel model : models) {
			int newStart = annotateSentence(model, jcas, startIndex);
			annotateTokens(model, jcas, startIndex);
			annotateDependencies(model, jcas);
			startIndex = newStart;
		}
	}

	private JSONArray accessSpacyAPI(String requirement) throws SpecmateInternalException {

		RestClient restClient = new RestClient(SPACY_API_BASE_URL, TIMEOUT, logService);
		try (restClient) {
			// Set model parameters
			JSONObject request = new JSONObject();
			request.put("text", requirement);
			request.put("model", spacyModel);
			request.put("collapse_punctuation", 0);
			request.put("collapse_phrases", 0);

			RestResult<JSONArray> result = restClient.postList("/sents_dep", request);
			if (result.getResponse().getStatus() == Status.OK.getStatusCode()) {
				result.getResponse().close();
				return result.getPayload();
			} else {
				result.getResponse().close();
				throw new SpecmateInternalException(ErrorCode.NLP,
						"Could not access Spacy API. Dependencies could not be loaded.");
			}
		}
	}

	private List<SpacyModel> buildSpacyModel(JSONArray input) {

		List<SpacyModel> models = new ArrayList<>();
		int startTokenIndex = 0;
		for (int i = 0; i < input.length(); i++) {
			JSONObject result = input.getJSONObject(i);
			String sentence = result.getString("sentence");
			JSONObject parse = result.getJSONObject("dep_parse");
			JSONArray allWords = parse.getJSONArray("words");

			// Search for all dependencies in which the current token is included.
			// allArcs = all dependencies that have been generated by Spacy.
			JSONArray allArcs = parse.getJSONArray("arcs");

			SpacyModel model = new SpacyModel(sentence, allWords, allArcs, startTokenIndex);
			startTokenIndex += model.getNodes().size();
			models.add(model);
		}
		return models;
	}

	private int annotateSentence(SpacyModel model, JCas jcas, int startIndex) {
		String text = jcas.getDocumentText();
		int begin = text.indexOf(model.sentence, startIndex);
		int end = begin + model.sentence.length();
		Sentence sentence = new Sentence(jcas, begin, end);
		sentence.addToIndexes();
		return end;
	}

//		List<Range<Integer>> ranges = new ArrayList<Range<Integer>>();
//		for (Node root : model.getRoots()) {
//			List<Node> nodes = model.getCovered(root);
//			int begin = -1;
//			int end = -1;
//			for (Node n : nodes) {
//				int nodeIndex = text.indexOf(n.text, searchIndex);
//				if (begin == -1) {
//					begin = nodeIndex;
//				}
//				searchIndex = nodeIndex;
//				end = nodeIndex + n.text.length();
//			}
//			Range<Integer> r = Range.between(begin, end);
//			ranges.add(r);
//		}
//		mergeRanges(ranges);
//		for (Range<Integer> r : ranges) {
//			Sentence sentence = new Sentence(jcas, r.getMinimum(), r.getMaximum());
//			sentence.addToIndexes();
//		}
//	}

//	private void mergeRanges(List<Range<Integer>> ranges) {
//		boolean merged = true;
//		while (merged) {
//			merged = false;
//			outer: for (int i = 0; i < ranges.size(); i++) {
//				for (int j = i + 1; j < ranges.size(); j++) {
//					Range<Integer> r1 = ranges.get(i);
//					Range<Integer> r2 = ranges.get(j);
//					if (r1.isOverlappedBy(r2)) {
//						ranges.remove(i);
//						ranges.remove(j - 1); // i has already been removed and is before j
//						ranges.add(Range.between(Math.min(r1.getMinimum(), r2.getMinimum()),
//								Math.max(r1.getMaximum(), r2.getMaximum())));
//						merged = true;
//						break outer;
//					}
//				}
//			}
//		}
//	}

	private void annotateTokens(SpacyModel model, JCas jcas, int startIndex) {
		String allText = jcas.getDocumentText();
		int currentIndex = startIndex;
		List<Node> allWords = model.getNodes();
		for (Node word : allWords) {
			int foundIndex = allText.indexOf(word.text, currentIndex);
			Token token = new Token(jcas, foundIndex, foundIndex + word.text.length());
			POS posAnno = new POS(jcas, token.getBegin(), token.getEnd());
			// To save memory, we typically intern() tag strings
			posAnno.setPosValue(word.tag != null ? word.tag.intern() : null);
			posAnno.addToIndexes();
			token.setPos(posAnno);
			token.addToIndexes();
			word.token = token;
			currentIndex = token.getEnd();
		}
	}

	private void annotateDependencies(SpacyModel model, JCas jcas) {

		for (Pair<Node, Node> currentArc : model.getAllConnections()) {

			Node parent = currentArc.getLeft();
			Node child = currentArc.getRight();

			// Check whether the token is the "start" of dependency
			// if yes, we create a corresponding Dependency and add it to the JCas
			Dependency dep = new Dependency(jcas);
			dep.setDependencyType(child.label);
			dep.setFlavor(DependencyFlavor.BASIC);
			dep.setDependent(child.token);
			dep.setGovernor(parent.token);
			dep.setBegin(dep.getDependent().getBegin());
			dep.setEnd(dep.getDependent().getEnd());
			dep.addToIndexes();
		}

		for (Node root : model.getRoots()) {
			Dependency dep = new ROOT(jcas);
			dep.setDependencyType("ROOT");
			dep.setFlavor(DependencyFlavor.BASIC);
			dep.setGovernor(root.token);
			dep.setDependent(root.token);
			dep.setBegin(dep.getDependent().getBegin());
			dep.setEnd(dep.getDependent().getEnd());
			dep.addToIndexes();
		}
	}

	private class SpacyModel {
		public Map<Integer, Node> nodeMap = new HashMap<>();
		public String sentence;

		public SpacyModel(String sentence, JSONArray allWords, JSONArray allDeps, int startTokenIndex) {
			this.sentence = sentence;
			for (int i = 0; i < allWords.length(); i++) {
				JSONObject word = allWords.getJSONObject(i);
				createNode(i + startTokenIndex, word.getString("text"), word.getString("tag"));
			}
			for (int i = 0; i < allDeps.length(); i++) {
				JSONObject currentArc = allDeps.getJSONObject(i);

				int start = currentArc.getInt("start");
				int end = currentArc.getInt("end");
				String label = currentArc.getString("label");
				String dir = currentArc.getString("dir");

				// Is the current token a dependent or governor?
				// The token is a dependent if the arrow of the dependency points to the token
				// and vice versa.
				if (dir.equals("left")) {
					connect(end, start, label);
				} else if (dir.equals("right")) {
					connect(start, end, label);
				}
			}
		}

		public List<Node> getNodes() {
			List<Node> nodes = new ArrayList<>(nodeMap.values());
			Collections.sort(nodes);
			return nodes;
		}

		public Node createNode(Integer id, String text, String tag) {
			Node node = new Node(id, text, tag);
			nodeMap.put(id, node);
			return node;
		}

		public void connect(Integer parent, Integer child, String label) {
			Node childNode = nodeMap.get(child);
			nodeMap.get(parent).addChild(childNode);
			childNode.label = label;
		}

		public Set<Node> getRoots() {
			return nodeMap.values().stream().filter(n -> n.parent == null).sorted().collect(Collectors.toSet());
		}

//		public List<Node> getCovered(Node root) {
//			List<Node> coveredNodes = new ArrayList<>();
//			LinkedList<Node> workList = new LinkedList<>();
//			workList.add(root);
//			while (!workList.isEmpty()) {
//				Node current = workList.pop();
//				coveredNodes.add(current);
//				workList.addAll(current.children);
//			}
//			Collections.sort(coveredNodes);
//			return coveredNodes;
//		}

		public List<Pair<Node, Node>> getAllConnections() {
			List<Pair<Node, Node>> connections = new ArrayList<>();
			LinkedList<Node> workList = new LinkedList<>(getRoots());
			while (!workList.isEmpty()) {
				Node current = workList.pop();
				current.children.stream().map(c -> Pair.of(current, c)).forEach(connections::add);
				workList.addAll(current.children);
			}
			Collections.sort(connections);
			return connections;
		}
	}

	private class Node implements Comparable<Node> {

		public Node(Integer id, String text, String tag) {
			super();
			this.id = id;
			this.text = text;
			this.tag = tag;
		}

		public Integer id;
		public String text;
		public String tag;
		public String label;
		public Token token;
		public Node parent;
		public List<Node> children = new ArrayList<>();

		public void addChild(Node child) {
			children.add(child);
			child.parent = this;
		}

		@Override
		public int compareTo(Node other) {
			return id.compareTo(other.id);
		}
	}
}