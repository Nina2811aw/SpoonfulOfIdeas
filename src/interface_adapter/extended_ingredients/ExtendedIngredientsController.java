package interface_adapter.extended_ingredients;
import use_case.extended_ingredients.ExtendedIngredientsInputBoundary;

public class ExtendedIngredientsController {

    private static ExtendedIngredientsInputBoundary extendedIngredientsInteractor;


    public ExtendedIngredientsController(ExtendedIngredientsInputBoundary extendedIngredientsInteractor) {
        this.extendedIngredientsInteractor = extendedIngredientsInteractor;
    }

    public static void displayExtendedIngredientsImage(String id){
        extendedIngredientsInteractor.displayExtendedIngredientsImage(id);
    }
}
