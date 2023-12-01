package use_case.add_to_favourites;

public class AddToFavouritesOutputData {
    private String favourites;
    private Boolean favouriteFilled = false;

    /*This public method creates an AddToFavouritesOutputData object, taking in a string representation of he users favourited recipes.
    @param favourites is a string of the recipes the user has added to favourites.  */
    public AddToFavouritesOutputData(String favourites){
        this.favourites = favourites;
    }



    // Method that returns the user's favourite recipes.
    public String getFavourites(){return favourites;}

    public void setFavouriteFilled(Boolean favouriteFilled){
        this.favouriteFilled = favouriteFilled;
    }

    public Boolean getFavouriteFilled(){
        return favouriteFilled;
    }
}
