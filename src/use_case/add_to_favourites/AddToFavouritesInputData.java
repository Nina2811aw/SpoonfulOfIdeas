package use_case.add_to_favourites;

public class AddToFavouritesInputData {
//The input data for this use case consists of the recipe's title and ID.
    final private String recipetitle;

    final private String recipeid;
// Constructor
    public AddToFavouritesInputData(String recipetitle, String recipeid){
        this.recipetitle = recipetitle;
        this.recipeid = recipeid;
    }
    //Method that gives access to the recipe title.
    public String getTitle() {return recipetitle;}
    //Method that gives access to the recipe ID
    public String getID(){return recipeid;}
}
