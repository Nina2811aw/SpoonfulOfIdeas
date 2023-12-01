package use_case.add_to_favourites;

public interface AddToFavouritesInputBoundary {
    //An Interface that consists of an execute method that the interactor will implement.
    void execute(AddToFavouritesInputData addToFavouritesInputData);
}
