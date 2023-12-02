package use_case.back_to_search;

public class BackToSearchInteractor implements BackToSearchInputBoundary {

    private final BackToSearchOutputBoundary backToSearchPresenter;

    /**
     * Constructor sets up interactor so that it can tell the presenter to update to SearchView.
     * @param backToSearchOutputBoundary should contain the BackToSearchPresenter object.
     */
    public BackToSearchInteractor(BackToSearchOutputBoundary backToSearchOutputBoundary){
        this.backToSearchPresenter = backToSearchOutputBoundary;
    }

    /**
     * The execute method just needs to call the presenter because the presenter
     * should always in context switch to the Search view.
     */
    @Override
    public void execute() {
        backToSearchPresenter.prepareRecipeSearchView();
    }
}
