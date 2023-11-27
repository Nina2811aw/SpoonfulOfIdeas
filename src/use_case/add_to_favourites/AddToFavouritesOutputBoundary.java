package use_case.add_to_favourites;

public interface AddToFavouritesOutputBoundary {
    //An interface that has a prepareSuccessViewMethod that is implemented by the Presenter of this use case.
    void prepareSuccessView(AddToFavouritesOutputData output);
}
