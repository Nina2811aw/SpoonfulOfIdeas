package use_case.add_to_favourites;

public class AddToFavouritesOutputData {
    private String favourites;

    public AddToFavouritesOutputData(String favourites){
        this.favourites = favourites;
    }
    public void setFavourites(String favourites){this.favourites = favourites;}

    public String getFavourites(){return favourites;}
}
