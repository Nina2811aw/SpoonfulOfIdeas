package interface_adapter.food_joke;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class FoodJokeViewModel extends ViewModel {

    private FoodJokeState state = new FoodJokeState("");

    public FoodJokeViewModel() {
        super("Food Joke View");
    }

    public FoodJokeState getState() {
        return state;
    }

    public void setState(FoodJokeState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
