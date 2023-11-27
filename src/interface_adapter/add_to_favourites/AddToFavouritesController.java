package interface_adapter.add_to_favourites;

import use_case.add_to_favourites.AddToFavouritesInputBoundary;
import use_case.add_to_favourites.AddToFavouritesInputData;
// The Controller class for the AddToFavourites use case.
// @author Shreya Dubey

public class AddToFavouritesController {
    final AddToFavouritesInputBoundary addToFavouritesInteractor;
    /* This public method constructs a new AddToFavouritesController when given a AddTofavouritesInputBoundary.
     * @param addToFavouritesInteractor is the instance of the AddToFavouritesInputBoundary the controller takes in.*/
    public AddToFavouritesController(AddToFavouritesInputBoundary addToFavouritesInteractor){
        this.addToFavouritesInteractor = addToFavouritesInteractor;
    }

    // This public method invokes the execute method in the AddToFavouritesInputBoundary.
    public void execute(String recipetitle, String recipeid){
        AddToFavouritesInputData addToFavouritesInputData = new AddToFavouritesInputData(recipetitle, recipeid);
        addToFavouritesInteractor.execute(addToFavouritesInputData);
    }
}
