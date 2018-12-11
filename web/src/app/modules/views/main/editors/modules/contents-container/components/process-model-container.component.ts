import { Component, Input } from '@angular/core';
import { ContentContainerBase } from '../base/contents-container-base';
import { IContainer } from '../../../../../../../model/IContainer';
import { ModelFactoryBase } from '../../../../../../../factory/model-factory-base';
import { Type } from '../../../../../../../util/type';
import { Process } from '../../../../../../../model/Process';
import { ProcessFactory } from '../../../../../../../factory/process-factory';
import { SpecmateDataService } from '../../../../../../data/modules/data-service/services/specmate-data.service';
import { NavigatorService } from '../../../../../../navigation/modules/navigator/services/navigator.service';
import { TranslateService } from '@ngx-translate/core';
import { ConfirmationModal } from '../../../../../../notification/modules/modals/services/confirmation-modal.service';
import { Id } from '../../../../../../../util/id';
import { ClipboardService } from '../../tool-pallette/services/clipboard-service';
import { TestSpecificationContentContainerBase } from '../base/testspecification-generatable-content-container-base';
import { AdditionalInformationService } from '../../../../../side/modules/links-actions/services/additional-information.service';

@Component({
    moduleId: module.id.toString(),
    selector: 'process-model-container',
    templateUrl: 'process-model-container.component.html',
    styleUrls: ['process-model-container.component.css']
})

export class ProcessModelContainer extends TestSpecificationContentContainerBase<Process> {

    constructor(dataService: SpecmateDataService,
        navigator: NavigatorService,
        translate: TranslateService,
        modal: ConfirmationModal,
        additionalInformationService: AdditionalInformationService,
        clipboardService: ClipboardService) {
        super(dataService, navigator, translate, modal, clipboardService, additionalInformationService);
    }

    protected condition = (element: IContainer) => Type.is(element, Process);

    public async createElement(name: string): Promise<Process> {
        let factory: ModelFactoryBase = new ProcessFactory(this.dataService);
        const element = await factory.create(this.parent, true, Id.uuid, name);
        return element as Process;
    }
}
