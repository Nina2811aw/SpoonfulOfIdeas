package view;

import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class RecipeDetailsView extends JPanel implements ActionListener, PropertyChangeListener {

    private final NutritionDetailController nutritionDetailController;

    private final NutritionDetailViewModel nutritionDetailViewModel;

    private final BackToChooseController backToChooseController;
    final JButton back;
    public RecipeDetailsView(NutritionDetailController nutritionDetailController, NutritionDetailViewModel nutritionDetailViewModel, BackToChooseController backToChooseController) {
        this.nutritionDetailController = nutritionDetailController;
        this.nutritionDetailViewModel = nutritionDetailViewModel;
        this.backToChooseController = backToChooseController;
        nutritionDetailViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel("Recipe Details View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        back = new JButton(nutritionDetailViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);



}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
