package interface_adapter;

import java.beans.PropertyChangeListener;

/**
 * Abstract base class for view models in the application.
 * This class provides a structure for view models, handling view names and property change notifications.
 */
public abstract class ViewModel {
    private String viewName;

    /**
     * Constructs a ViewModel with a specified view name.
     * @param viewName the name of the view associated with this view model
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    /**
     * Gets the name of the view associated with this view model.
     * @return the name of the view
     */
    public String getViewName() {
        return this.viewName;
    }

    /**
     * Fires a property change event.
     * Implementations of this method should notify all registered listeners about a property change.
     */
    public abstract void firePropertyChanged();

    /**
     * Adds a property change listener to this view model.
     * Implementations of this method should allow for the registration of listeners that want to be notified of property changes.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
