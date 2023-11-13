package interface_adapter.recipe_search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecipeSearchViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Recipe Search View";

    public static final String INGREDIENTS_LABEL = "Type in your ingredients";

    public static final String SEARCH_BUTTON = "Search";

    private RecipeSearchState state = new RecipeSearchState();

    public RecipeSearchViewModel() {
        super("search");
    }

    public void setState(RecipeSearchState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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
