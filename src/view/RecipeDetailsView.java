package view;

import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.add_to_favourites.AddToFavouritesState;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;


public class RecipeDetailsView extends JPanel implements ActionListener, PropertyChangeListener {

    public String viewName = "Recipe Details";

    private final NutritionDetailController nutritionDetailController;

    private final NutritionDetailViewModel nutritionDetailViewModel;

    private final BackToChooseController backToChooseController;
    final JButton back;

    private final AddToFavouritesController addToFavouritesController;

    private final JButton addToFavourites;
    public RecipeDetailsView(NutritionDetailController nutritionDetailController, NutritionDetailViewModel nutritionDetailViewModel, BackToChooseController backToChooseController, AddToFavouritesController addToFavouritesController) {
        this.nutritionDetailController = nutritionDetailController;
        this.nutritionDetailViewModel = nutritionDetailViewModel;
        this.backToChooseController = backToChooseController;
        this.addToFavouritesController = addToFavouritesController;
        nutritionDetailViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Recipe Details View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        back = new JButton(NutritionDetailViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
        addToFavourites = new JButton(NutritionDetailViewModel.ADD_TO_FAVOURITES_LABEL);
        buttons.add(addToFavourites);

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

        addToFavourites.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(addToFavourites)){
                            AddToFavouritesState currentState = NutritionDetailViewModel.getAddToFavouritesState();
                            NutritionDetailState nutritionState = NutritionDetailViewModel.getState();
                            List<String> recipe = nutritionState.getRecipe();
                            addToFavouritesController.execute(recipe.get(0), recipe.get(1));
                            String favourites = currentState.getFavourites();
                            JOptionPane.showMessageDialog(RecipeDetailsView.this, favourites);
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
