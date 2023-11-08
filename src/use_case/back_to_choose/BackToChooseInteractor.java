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

    public BackToChooseInteractor(BackToChooseDataAccessInterface backtochooseDataAccessObject, BackToChooseOutputBoundary backtochooseOutputBoundary){
        this.backToChoosePresenter = backtochooseOutputBoundary;
        this.backtochooseDataAccessObject = backtochooseDataAccessObject;
    }


    @Override
    public void execute() {
        List<RecipeInformation> recipeInfoList = backtochooseDataAccessObject.getRecipeInformationList();
        //ChooseRecipeInteractor.execute(recipeInfoList);
        BackToChooseOutputData backToChooseOutputData = new BackToChooseOutputData(recipeInfoList);
        backToChoosePresenter.prepareSuccessView(backToChooseOutputData);

    }
}

