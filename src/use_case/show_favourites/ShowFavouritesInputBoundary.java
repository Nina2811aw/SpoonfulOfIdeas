package use_case.show_favourites;public interface ShowFavouritesInputBoundary {
    // As the use case will simply execute on user click, no input data required,
    // we only require an execute method from the interactor.
    void execute();
}
