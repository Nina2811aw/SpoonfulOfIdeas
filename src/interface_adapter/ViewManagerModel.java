package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Manages the active view in SpoonfulOfIdeas.
 * This class keeps track of the currently active view and notifies listeners when the active view changes.
 */
public class ViewManagerModel {
    private String activeViewName;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Gets the name of the currently active view.
     * @return the name of the active view
     */
    public String getActiveView() {
        return activeViewName;
    }

    /**
     * Sets the currently active view and notifies listeners of the change.
     * @param activeView the name of the new active view
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    // This is what the Presenter will call to let the ViewModel know
    // to alert the View

    /**
     * Fires a property change event indicating a change in the active view.
     * This method should be called when the active view changes to notify all registered listeners.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
        System.out.println("view manager model fire property change");
    }

    /**
     * Adds a property change listener to this view manager model.
     * Allows for the registration of listeners that want to be notified of changes to the active view.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
