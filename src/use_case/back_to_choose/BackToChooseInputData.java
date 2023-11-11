package use_case.back_to_choose;

import entity.RecipeInformation;

import java.util.List;

public class BackToChooseInputData {
    List<RecipeInformation> recipeIDList;

    public BackToChooseInputData(List<RecipeInformation> recipeIDList){
        this.recipeIDList = recipeIDList;
    }

    List<RecipeInformation> getRecipeIDList(){return recipeIDList;}


}
