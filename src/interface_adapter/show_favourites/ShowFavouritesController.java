package interface_adapter.show_favourites;

import use_case.show_favourites.ShowFavouritesInputBoundary;

public class ShowFavouritesController {

    final private ShowFavouritesInputBoundary showFavouritesInteractor;
    public ShowFavouritesController(ShowFavouritesInputBoundary showFavouritesInteractor){
        this.showFavouritesInteractor = showFavouritesInteractor;
    }

    public void execute(){
        showFavouritesInteractor.execute();
    }
}
