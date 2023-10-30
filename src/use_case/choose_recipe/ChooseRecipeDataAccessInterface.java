package use_case.choose_recipe;

import java.util.List;

public interface ChooseRecipeDataAccessInterface {

    List<List<String>> getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData);


}
