package use_case.add_to_favourites;

public interface AddToFavouritesDataAccessInterface {

    void AddToFavourites(String recipetitle, String recipeid);

    String getFavourites();

}
