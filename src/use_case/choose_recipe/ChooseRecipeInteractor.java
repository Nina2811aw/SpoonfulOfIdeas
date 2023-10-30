package use_case.choose_recipe;

public class ChooseRecipeInteractor implements ChooseRecipeInputBoundary{

    final ChooseRecipeDataAccessInterface chooseRecipeDataAccessObject;

    final ChooseRecipeOutputBoundary chooseRecipePresenter;

    public ChooseRecipeInteractor(ChooseRecipeDataAccessInterface chooseRecipeDataAccessObject, ChooseRecipeOutputBoundary chooseRecipePresenter) {
        this.chooseRecipeDataAccessObject = chooseRecipeDataAccessObject;
        this.chooseRecipePresenter = chooseRecipePresenter;
    }

    @Override
    public void execute(ChooseRecipeInputData chooseRecipeInputData) {

    }
}
