package interface_adapter.show_favourites;

import use_case.show_favourites.ShowFavouritesInputBoundary;

public class ShowFavouritesController {

    final private ShowFavouritesInputBoundary showFavouritesInteractor;

    // constructor sets up controller to have access to the use case interactor to call upon it.
    public ShowFavouritesController(ShowFavouritesInputBoundary showFavouritesInteractor){
        this.showFavouritesInteractor = showFavouritesInteractor;
    }

    // runs the show_favourites use case interactor method.
    public void execute(){
        showFavouritesInteractor.execute();
    }
}
