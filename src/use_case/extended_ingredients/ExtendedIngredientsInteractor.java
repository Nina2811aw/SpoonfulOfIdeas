package use_case.extended_ingredients;

public class ExtendedIngredientsInteractor implements ExtendedIngredientsInputBoundary {
    private final ExtendedIngredientsDataAccessInterface dataAccess;

    public ExtendedIngredientsInteractor(ExtendedIngredientsDataAccessInterface dataAccess, ExtendedIngredientsOutputBoundary extendedIngredientsOutputBoundary) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void displayExtendedIngredientsImage(String id) {
        dataAccess.displayExtendedIngredientsImage(id);
    }
}