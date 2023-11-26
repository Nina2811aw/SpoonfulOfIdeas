package use_case.show_favourites;

import entity.RecipeInformation;

import java.util.List;

public interface ShowFavouritesDataAccessInterface {
    // The show_favourites use case requires the locally stored data contained in favourites.csv, thus to force
    // a level consistency with how this data looks, we require this data as a list of RecipeInformation entity objects.
    List<RecipeInformation> getFavouritesList();
}
