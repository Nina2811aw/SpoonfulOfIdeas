package use_case.choose_recipe;

import java.util.List;

public interface ChooseRecipeDataAccessInterface {

    List<String> getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData);

    Boolean isFavourites(String id);
}
