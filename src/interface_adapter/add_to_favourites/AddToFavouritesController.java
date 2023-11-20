package interface_adapter.add_to_favourites;

import use_case.add_to_favourites.AddToFavouritesInputBoundary;
import use_case.add_to_favourites.AddToFavouritesInputData;

public class AddToFavouritesController {
    final AddToFavouritesInputBoundary addToFavouritesInteractor;

    public AddToFavouritesController(AddToFavouritesInputBoundary addToFavouritesInteractor){
        this.addToFavouritesInteractor = addToFavouritesInteractor;
    }

    public void execute(String recipetitle, String recipeid){
        AddToFavouritesInputData addToFavouritesInputData = new AddToFavouritesInputData(recipetitle, recipeid);
        addToFavouritesInteractor.execute(addToFavouritesInputData);
    }
}
