package interface_adapter.back_to_choose;

import use_case.back_to_choose.BackToChooseInputBoundary;
import use_case.back_to_choose.BackToChooseInputData;

public class BackToChooseController {

    final BackToChooseInputBoundary backToChooseInteractor;

    public BackToChooseController(BackToChooseInputBoundary backToChooseInteractor){
        this.backToChooseInteractor = backToChooseInteractor;
    }

    public void execute(){
        backToChooseInteractor.execute();
    }

}
