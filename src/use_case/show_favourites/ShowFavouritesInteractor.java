package use_case.show_favourites;

import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.recipe_search.RecipeSearchOutputData;

public class ShowFavouritesInteractor implements ShowFavouritesInputBoundary {
    final private ShowFavouritesDataAccessInterface favouritesDAO;
    final private RecipeSearchOutputBoundary presenter;

    /**
     * Constructor sets up interactor so that it can access the presenter and the favouritesDAO.
     * @param favouritesDAO should contain the FavouritesDataAccessObject object.
     * @param presenter should contain the RecipeSearchPresenter object.
     */
    public ShowFavouritesInteractor(ShowFavouritesDataAccessInterface favouritesDAO, RecipeSearchOutputBoundary presenter){
        this.favouritesDAO = favouritesDAO;
        this.presenter = presenter;
    }

    /**
     * This use case will always work, thus we simply send in the output data to the presenter success view.
     * Note that we're simply reusing the presenter from recipe-search use case, thus we use the same output data object.
     */
    @Override
    public void execute() {
        presenter.prepareChooseRecipeView(new RecipeSearchOutputData(favouritesDAO.getFavouritesList()));
    }
}
