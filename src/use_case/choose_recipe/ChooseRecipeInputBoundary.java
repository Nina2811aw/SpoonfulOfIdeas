package use_case.choose_recipe;

public interface ChooseRecipeInputBoundary {
    /**
     * The choose-recipe use case works immediately after the back button is pressed,
     * and the use case does have specific input data, so the interactor  must
     * implement an execute method utilizing this data.
     * @param chooseRecipeInputData the input data containing recipe details
     */
    void execute(ChooseRecipeInputData chooseRecipeInputData);
}
