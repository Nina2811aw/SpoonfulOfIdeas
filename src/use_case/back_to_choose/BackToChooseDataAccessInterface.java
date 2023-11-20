package use_case.back_to_choose;

import entity.RecipeInformation;
import java.util.List;
public interface BackToChooseDataAccessInterface {

    // Will get the list of recipes that RecipeSearch had created.
    List<RecipeInformation> getRecipeInformationList();
}
