package view;

import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.back_to_choose.BackToChooseState;
import interface_adapter.back_to_choose.BackToChooseViewModel;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class RecipeDetailsView extends JPanel implements ActionListener, PropertyChangeListener {

    public String viewName = "Recipe Details";

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
        back = new JButton(NutritionDetailViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)){
                            NutritionDetailState currentState = NutritionDetailViewModel.getState();

                            backToChooseController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
        // add the recipe info later



}


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        NutritionDetailState state = (NutritionDetailState) evt.getNewValue();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "done");
    }
}
