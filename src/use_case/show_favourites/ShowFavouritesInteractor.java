package use_case.show_favourites;

import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.recipe_search.RecipeSearchOutputData;

public class ShowFavouritesInteractor implements ShowFavouritesInputBoundary {
    final private ShowFavouritesDataAccessInterface favouritesDAO;
    final private RecipeSearchOutputBoundary presenter;

    public ShowFavouritesInteractor(ShowFavouritesDataAccessInterface favouritesDAO, RecipeSearchOutputBoundary presenter){
        this.favouritesDAO = favouritesDAO;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.prepareChooseRecipeView(new RecipeSearchOutputData(favouritesDAO.getFavourites()));
    }
}
