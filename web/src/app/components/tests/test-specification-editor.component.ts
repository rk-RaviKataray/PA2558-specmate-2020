import {Id} from '../../util/Id';
import {Config} from '../../config/config';
import {GenericForm} from '../core/forms/generic-form.component';
import { CEGModel } from '../../model/CEGModel';
import { Type } from '../../util/Type';
import { TestParameter } from '../../model/TestParameter';
import { TestCase } from '../../model/TestCase';
import { IContentElement } from '../../model/IContentElement';
import { TestSpecification } from '../../model/TestSpecification';
import { Url } from '../../util/Url';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { SpecmateDataService } from '../../services/specmate-data.service';
import { IContainer } from '../../model/IContainer';
import { Requirement } from '../../model/Requirement';
import {ViewChild, OnInit,  Component} from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'test-specification-editor',
    templateUrl: 'test-specification-editor.component.html'
})
export class TestSpecificationEditor implements OnInit {

    /** The test specification to be shown */
    private testSpecification: TestSpecification;

    /** All contents of the test specification */
    private contents:IContentElement[];

    /** Input parameters */
    private _inputParameters: IContentElement[];

    /** Output parameters */
    private _outputParameters: IContentElement[];

    /** All parameters */
    private _allParameters: IContentElement[];

    /** Test cases */
    private _testCases: IContentElement[];

    /** The CEG model this test specification is linked to */
    private cegModel: CEGModel;

    /** The requirement this test specification is linked to */
    private requirement: Requirement;

    /** The type of a test case (used for filtering) */
    private testCaseType = TestCase;

    /** The type of a test parameter (used for filtering) */
    private parameterType = TestParameter;

    /** The generic form used in this component */
    @ViewChild(GenericForm)
    private genericForm : GenericForm;

    /** constructor  */
    constructor(private dataService: SpecmateDataService, private router: Router, private route: ActivatedRoute) { }

    get inputParameters():IContentElement[]{
        return this.contents.filter(c => {
            return Type.is(c, TestParameter) && (<TestParameter>c).type==="INPUT";
        });
    }

    get outputParameters():IContentElement[]{
        return this.contents.filter(c => {
             return Type.is(c, TestParameter) && (<TestParameter>c).type==="OUTPUT";
         });           
    }

    get allParameters():IContentElement[]{
        return this.inputParameters.concat(this.outputParameters);
    }

    get testCases():IContentElement[] {
        return this.contents.filter(c => {
            return Type.is(c, TestCase);
        });
    }

    /** Read contents and CEG and requirements parents */
    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.dataService.readElement(Url.fromParams(params)))
            .subscribe((testSpec: IContainer) => {
                this.testSpecification = testSpec as TestSpecification;
                this.readContents();
                this.readParents();
            });
    }

    /** Rads to the contents of the test specification  */
    private readContents(): void {
        if (this.testSpecification) {
            this.dataService.readContents(this.testSpecification.url).then((
                contents: IContainer[]) => {
                this.contents=contents;
            });
        }
    }

    /** Reads the CEG and requirements parents of the test specficiation */
    private readParents(): void {
        if (this.testSpecification) {
            this.dataService.readElement(Url.parent(this.testSpecification.url)).then((
                element: IContainer) => {
                if (Type.is(element, CEGModel)) {
                    this.cegModel = <CEGModel>element;
                    this.readCEGParent();
                } else if (Type.is(element, Requirement)) {
                    this.requirement = <Requirement>element;
                }
            });
        }
    }

    /** Reads the requirement parent of the CEG model */
    private readCEGParent(): void {
        if (this.cegModel) {
            this.dataService.readElement(Url.parent(this.cegModel.url)).then((
                element: IContainer) => {
                if (Type.is(element, Requirement)) {
                    this.requirement = <Requirement>element;
                }
            });
        }
    }

    private createNewTestParameter(id:string): TestParameter{
            let url: string = Url.build([this.testSpecification.url, id]);
            let parameter: TestParameter = new TestParameter();
            parameter.name = Config.TESTPARAMETER_NAME;
            parameter.id = id;
            parameter.url = url;
            return parameter;
    }

    public addInputColumn(): void {
        this.getNewTestParameterId().then(id=>{
            let parameter: TestParameter = this.createNewTestParameter(id);
            parameter.type="INPUT";
            this.dataService.createElement(parameter, true);
        });
    }

    public addOutputColumn(): void {
        this.getNewTestParameterId().then(id=>{
            let parameter: TestParameter = this.createNewTestParameter(id);
            parameter.type="OUTPUT";
            this.dataService.createElement(parameter, true);
        });
    }

    public getNewTestParameterId(){
        return this.dataService.readContents(this.testSpecification.url, true).then(
            (contents: IContainer[]) => Id.generate(contents, Config.TESTPARAMETER_BASE_ID));
    }

    /** Return true if all user inputs are valid  */
    private get isValid(): boolean {
        if(!this.genericForm) {
            return true;
        }
        return  this.genericForm.isValid;
    }

    private save(): void {
        this.dataService.commit("Save");
    }
}