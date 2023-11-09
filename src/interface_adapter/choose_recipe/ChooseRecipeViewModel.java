package interface_adapter.choose_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChooseRecipeViewModel extends ViewModel {
    public static final String SELECT_BUTTON = "Select";

    public static final String TITLE_BUTTON = "Recipe Choose View";
    private ChooseRecipeState state = new ChooseRecipeState();

    public ChooseRecipeViewModel() {
        super("choose recipe");
    }

    public void setState(ChooseRecipeState state) {
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

    public ChooseRecipeState getState() {
        return state;
    }
}
