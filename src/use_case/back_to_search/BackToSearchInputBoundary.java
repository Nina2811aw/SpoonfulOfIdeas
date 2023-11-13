package use_case.back_to_search;

public interface BackToSearchInputBoundary {
    // The back_to_search use case works immediately after the back button is pressed, and the
    // use case does not require input data, so the interactor only must implment an execute method.
    void execute();
}
