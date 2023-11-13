package interface_adapter.back_to_choose;

import use_case.back_to_choose.BackToChooseInputBoundary;

//@author Shreya Dubey

public class BackToChooseController {

    final BackToChooseInputBoundary backToChooseInteractor;

    /* This public method creates a new BacktoChooseController when given a BackToChooseInputBoundary.
    * @param backToChooseInteractor is the instance of BackToChooseInputBoundary the controller takes in.*/

    public BackToChooseController(BackToChooseInputBoundary backToChooseInteractor){
        this.backToChooseInteractor = backToChooseInteractor;
    }

    // This public method invokes the execute method in the BackToChooseInputBoundary.

    public void execute(){
        backToChooseInteractor.execute();
    }

}
