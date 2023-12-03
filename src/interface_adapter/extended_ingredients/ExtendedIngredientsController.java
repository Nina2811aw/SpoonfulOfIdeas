package interface_adapter.extended_ingredients;
import use_case.extended_ingredients.ExtendedIngredientsInputBoundary;

public class ExtendedIngredientsController {

    private final ExtendedIngredientsInputBoundary extendedIngredientsInteractor;


    public ExtendedIngredientsController(ExtendedIngredientsInputBoundary extendedIngredientsInteractor) {
        this.extendedIngredientsInteractor = extendedIngredientsInteractor;
    }

    public void displayExtendedIngredientsImage(String id){
        extendedIngredientsInteractor.displayExtendedIngredientsImage(id);
    }
}
