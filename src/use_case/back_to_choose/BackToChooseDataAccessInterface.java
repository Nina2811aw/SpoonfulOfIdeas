package use_case.back_to_choose;

import entity.RecipeInformation;
import java.util.List;
public interface BackToChooseDataAccessInterface {
    List<RecipeInformation> getRecipeInformationList();
}
