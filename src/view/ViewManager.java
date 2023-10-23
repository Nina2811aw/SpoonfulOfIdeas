package view;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener{
    private final CardLayout cardLayout;
    private final JPanel views;

    private ViewManagerModel viewManagerModel; //from the interface adapter

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // to impliment later
    }
}
