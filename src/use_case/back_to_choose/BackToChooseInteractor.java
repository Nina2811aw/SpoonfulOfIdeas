package use_case.back_to_choose;

import entity.RecipeInformation;
import interface_adapter.back_to_choose.BackToChoosePresenter;
import interface_adapter.choose_recipe.ChooseRecipeController;
import use_case.choose_recipe.ChooseRecipeInputBoundary;
import use_case.choose_recipe.ChooseRecipeInputData;
import use_case.choose_recipe.ChooseRecipeInteractor;


import java.util.List;

public class BackToChooseInteractor implements BackToChooseInputBoundary{

    final BackToChooseOutputBoundary backToChoosePresenter;

    final BackToChooseDataAccessInterface backtochooseDataAccessObject;

    /*Public method that builds an interactor for the back to choose use case, taking in a Data Access Interface, and an Output Boundary.*/

    public BackToChooseInteractor(BackToChooseDataAccessInterface backtochooseDataAccessObject, BackToChooseOutputBoundary backtochooseOutputBoundary /*,ChooseRecipeController chooseRecipeController*/){
        this.backToChoosePresenter = backtochooseOutputBoundary;
        this.backtochooseDataAccessObject = backtochooseDataAccessObject;
    }


    /*A public method that implements the execute method specified in the BacktoChooseInputBoundary. This method gets
    * a list of RecipeInformation from a DAO. It packages that information into Output Data, and calls the Presenter's prepareSuccessView method
    * with aforementioned Output Data. */
    @Override
    public void execute() {
        List<RecipeInformation> recipeInfoList = backtochooseDataAccessObject.getRecipeInformationList();

        BackToChooseOutputData backToChooseOutputData = new BackToChooseOutputData(recipeInfoList);
        backToChoosePresenter.prepareSuccessView(backToChooseOutputData);

    }
}

