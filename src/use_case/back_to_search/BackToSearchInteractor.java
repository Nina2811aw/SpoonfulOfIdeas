package use_case.back_to_search;

import data_access.RecipeSpecificationDataAccessObject;
import entity.RecipeSpec;

public class BackToSearchInteractor implements BackToSearchInputBoundary {

    private BackToSearchDataAccessInterface recipeSpecificationDAO;
    private BackToSearchOutputBoundary backToSearchOutputBoundary;

    //    private BackToSearchOutputData backToSearchOutputData;
    //    private RecipeSpec recipeSpecification;

    public BackToSearchInteractor(BackToSearchDataAccessInterface backToSearchDataAccessInterface,
                                  BackToSearchOutputBoundary backToSearchOutputBoundary){
        this.recipeSpecificationDAO = backToSearchDataAccessInterface;
        this.backToSearchOutputBoundary = backToSearchOutputBoundary;
    }

    @Override
    public void execute() {

    }
}
