package interface_adapter.show_favourites;

import use_case.show_favourites.ShowFavouritesInputBoundary;

public class ShowFavouritesController {

    final private ShowFavouritesInputBoundary showFavouritesInteractor;

    /**
     * This public method sets up a controller to have access to the use case interactor to call upon it.
     * @param showFavouritesInteractor is the instance of ShowFavouritesInteractor the controller takes in.
     */
    public ShowFavouritesController(ShowFavouritesInputBoundary showFavouritesInteractor){
        this.showFavouritesInteractor = showFavouritesInteractor;
    }

    // Runs the show_favourites use case interactor method.
    public void execute(){
        showFavouritesInteractor.execute();
    }
}
