package view;

import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;

import javax.swing.*;
import java.awt.*;


public class RecipeDetailsView {

    private final NutritionDetailController nutritionDetailController;

    private final NutritionDetailViewModel nutritionDetailViewModel;
    //final JButton back;
    public RecipeDetailsView(NutritionDetailController nutritionDetailController, NutritionDetailViewModel nutritionDetailViewModel) {
        this.nutritionDetailController = nutritionDetailController;
        this.nutritionDetailViewModel = nutritionDetailViewModel;

        /**this.nutritionDetailViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Recipe Details View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttons = new JPanel();
        back = new JButton(nutritionDetailViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);**/
}}
