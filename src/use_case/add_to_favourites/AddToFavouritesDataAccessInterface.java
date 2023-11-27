package use_case.add_to_favourites;

public interface AddToFavouritesDataAccessInterface {
    // Will get the list of recipes stored in the favourites file.

    void AddToFavourites(String recipetitle, String recipeid);

    String getFavourites();

}
