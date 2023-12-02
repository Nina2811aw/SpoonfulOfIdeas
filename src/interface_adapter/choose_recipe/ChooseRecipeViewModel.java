package interface_adapter.choose_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ChooseRecipeViewModel extends ViewModel {

    public static final String TITLE_BUTTON = "Recipe Choose View";
    private ChooseRecipeState state = new ChooseRecipeState();

    /**
     * Constructs a ChooseRecipeViewModel using parent ViewModel's constructor.
     */
    public ChooseRecipeViewModel() {
        super("choose recipe");
    }

    /**
     * Sets the state of the choose recipe view.
     * @param state the new state to set
     */
    public void setState(ChooseRecipeState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Inherits javadoc from parent
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    // Inherits javadoc from parent
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the choose recipe view.
     * @return the current ChooseRecipeState
     */
    public ChooseRecipeState getState() {
        return state;
    }
}
