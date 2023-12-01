package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Manages the switching of views in the application's user interface.
 * This class responds to property change events to switch between different views
 * using a {@link CardLayout}.
 */
public class ViewManager implements PropertyChangeListener{
    private final CardLayout cardLayout;
    private final JPanel views;

    private ViewManagerModel viewManagerModel; //from the interface adapter

    /**
     * Constructs a ViewManager with specified panel, layout, and view manager model.
     *
     * @param views the panel containing the different views
     * @param cardLayout the card layout to manage the views
     * @param viewManagerModel the model managing view changes
     */
    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    /**
     * Responds to property change events to switch views.
     * @param evt the property change event, typically indicating a view change
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String viewModelName = (String) evt.getNewValue();
        cardLayout.show(views, viewModelName);
    }
}
