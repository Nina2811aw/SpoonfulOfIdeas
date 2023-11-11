package interface_adapter.back_to_search;

import use_case.back_to_search.BackToSearchInputBoundary;

public class BackToSearchController {

    final BackToSearchInputBoundary backToSearchInputBoundary;

    public BackToSearchController(BackToSearchInputBoundary backToSearchInteractor){
        this.backToSearchInputBoundary = backToSearchInteractor;
    }

    // runs the back_to_search use case interactor method
    public void execute(){
        backToSearchInputBoundary.execute();
    }
}
