package use_case.add_to_favourites;

public interface AddToFavouritesOutputBoundary {
    void prepareSuccessView(AddToFavouritesOutputData output);
    void prepareFailView(String error);
}
