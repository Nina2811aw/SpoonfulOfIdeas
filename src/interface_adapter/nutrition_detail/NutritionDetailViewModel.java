package interface_adapter.nutrition_detail;

import interface_adapter.ViewModel;
import interface_adapter.recipe_search.RecipeSearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NutritionDetailViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Recipe Search View";

    public static final String SEARCH_BUTTON = "Search";

    private RecipeSearchState state = new RecipeSearchState();

    public NutritionDetailViewModel() {
        super("search");
    }

    public void setState(RecipeSearchState state) {
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

    public RecipeSearchState getState() {
        return state;
    }
}