package use_case.add_to_favourites;

public class AddToFavouritesOutputData {
    private String favourites;
    private Boolean favouriteFilled = false;

    public AddToFavouritesOutputData(String favourites){
        this.favourites = favourites;
    }
    public void setFavourites(String favourites){this.favourites = favourites;}

    public String getFavourites(){return favourites;}

    public void setFavouriteFilled(Boolean favouriteFilled){
        this.favouriteFilled = favouriteFilled;
    }

    public Boolean getFavouriteFilled(){
        return favouriteFilled;
    }
}
