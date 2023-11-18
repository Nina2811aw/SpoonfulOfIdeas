package use_case.add_to_favourites;

public class AddToFavouritesInputData {

    final private String recipetitle;

    final private String recipeid;

    public AddToFavouritesInputData(String recipetitle, String recipeid){
        this.recipetitle = recipetitle;
        this.recipeid = recipeid;
    }
    public String getTitle() {return recipetitle;}

    public String getID(){return recipeid;}
}
