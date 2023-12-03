package interface_adapter.back_to_search;

import use_case.back_to_search.BackToSearchInputBoundary;

public class BackToSearchController {

    final BackToSearchInputBoundary backToSearchInputBoundary;

    /**
     * Constructor sets up controller to have access to the use case interactor to call upon it.
     * @param backToSearchInteractor is an instance of back_to_search use case interactor object.
     */
    public BackToSearchController(BackToSearchInputBoundary backToSearchInteractor){
        this.backToSearchInputBoundary = backToSearchInteractor;
    }

    // Executes the core operation required for back_to_search.
    public void execute(){
        backToSearchInputBoundary.execute();
    }
}
