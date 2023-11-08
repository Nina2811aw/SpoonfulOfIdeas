package use_case.back_to_search;

import data_access.RecipeSpecificationDataAccessObject;
import entity.RecipeSpec;

public class BackToSearchInteractor implements BackToSearchInputBoundary {

    private final BackToSearchDataAccessInterface recipeSpecificationDAO;
    private final BackToSearchOutputBoundary backToSearchPresenter;

    public BackToSearchInteractor(BackToSearchDataAccessInterface backToSearchDataAccessInterface,
                                  BackToSearchOutputBoundary backToSearchOutputBoundary){
        this.recipeSpecificationDAO = backToSearchDataAccessInterface;
        this.backToSearchPresenter = backToSearchOutputBoundary;
    }

    @Override
    public void execute() {
        RecipeSpec recipeSpec = recipeSpecificationDAO.getSpecification();
        BackToSearchOutputData outputData = new BackToSearchOutputData(recipeSpec.getIngredients(), recipeSpec.getDiets(),
                                                                        recipeSpec.getCuisines(), recipeSpec.getIntolerances(),
                                                                        recipeSpec.getMinProtein(), recipeSpec.getMaxProtein(),
                                                                        recipeSpec.getMinFat(), recipeSpec.getMaxFat(),
                                                                        recipeSpec.getMinCarbs(), recipeSpec.getMaxCarbs(),
                                                                        recipeSpec.getMinCalories(), recipeSpec.getMaxCalories());
        backToSearchPresenter.prepareRecipeSearchView(outputData);
    }
}
