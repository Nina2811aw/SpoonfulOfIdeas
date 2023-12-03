package use_case.back_to_search;

public interface BackToSearchOutputBoundary {
    /**
     * Once the back button is pressed, there can never be fail scenario as we
     * simply transition to the Search view from the Choose view.
     */
    void prepareRecipeSearchView();
}
