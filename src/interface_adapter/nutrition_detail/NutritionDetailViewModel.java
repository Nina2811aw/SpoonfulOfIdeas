package interface_adapter.nutrition_detail;

import interface_adapter.ViewModel;
import interface_adapter.recipe_search.RecipeSearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NutritionDetailViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Recipe Details View";

    public static final String SEARCH_BUTTON = "Search";

    public static final String BACK_BUTTON_LABEL = "Back";

    private NutritionDetailState state = new NutritionDetailState();

    public NutritionDetailViewModel() {
        super("Recipe Details");
    }

    public void setState(NutritionDetailState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static NutritionDetailState getState() {
        return state;
    }
}
