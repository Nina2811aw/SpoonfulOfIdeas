package use_case.back_to_choose;

import entity.RecipeInformation;

import java.util.List;

public class BackToChooseOutputData {

    private List<RecipeInformation> recipeInfoList;

    public BackToChooseOutputData(List<RecipeInformation> recipeInfoList) {
        this.recipeInfoList = recipeInfoList;
    }

    public List<RecipeInformation> getRecipeInfoList(){return recipeInfoList;}
}
