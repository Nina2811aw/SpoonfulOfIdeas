package use_case.show_favourites;

import entity.RecipeInformation;

import java.util.List;

public interface ShowFavouritesDataAccessInterface {
    List<RecipeInformation> getFavouritesList();
}
