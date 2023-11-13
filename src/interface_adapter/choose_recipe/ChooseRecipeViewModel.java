package interface_adapter.choose_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ChooseRecipeViewModel extends ViewModel {

    public static final String TITLE_BUTTON = "Recipe Choose View";
    private ChooseRecipeState state = new ChooseRecipeState();

    public ChooseRecipeViewModel() {
        super("choose recipe");
    }

    public void setState(ChooseRecipeState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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
