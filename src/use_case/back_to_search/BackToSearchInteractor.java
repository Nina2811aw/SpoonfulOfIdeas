package use_case.back_to_search;

public class BackToSearchInteractor implements BackToSearchInputBoundary {

    private final BackToSearchOutputBoundary backToSearchPresenter;

    public BackToSearchInteractor(BackToSearchOutputBoundary backToSearchOutputBoundary){
        this.backToSearchPresenter = backToSearchOutputBoundary;
    }

    @Override
    public void execute() {
        backToSearchPresenter.prepareRecipeSearchView();
    }
}
