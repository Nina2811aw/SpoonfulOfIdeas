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

import static data_access.SpoonacularDataAccessObject.displayNutritionLabelImage;

public class RecipeDetailsView extends JPanel implements ActionListener, PropertyChangeListener {

    public String viewName = "Recipe Details";
    public final NutritionDetailViewModel nutritionDetailViewModel;

    //initalize buttons back, addToFavourites, nutritionDetail
    final JButton back;
    public final BackToChooseController backToChooseController;

    private final JButton addToFavourites;
    public final AddToFavouritesController addToFavouritesController;

    private final JButton nutritionDetail;
    public final NutritionDetailController nutritionDetailController;

    public RecipeDetailsView(NutritionDetailController nutritionDetailController, NutritionDetailViewModel nutritionDetailViewModel, BackToChooseController backToChooseController, AddToFavouritesController addToFavouritesController) {
        this.nutritionDetailViewModel = nutritionDetailViewModel;
        this.nutritionDetailController = nutritionDetailController;
        nutritionDetailViewModel.addPropertyChangeListener(this);

        this.backToChooseController = backToChooseController;
        this.addToFavouritesController = addToFavouritesController;

        // Change
        JLabel title = new JLabel("---title----");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        //^^


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        // Button Setup
        JPanel buttons = new JPanel();
        JPanel details = new JPanel();
        back = new JButton(NutritionDetailViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
        addToFavourites = new JButton(NutritionDetailViewModel.ADD_TO_FAVOURITES_LABEL);
        buttons.add(addToFavourites);

        nutritionDetail = new JButton(NutritionDetailViewModel.NUTRITION_INFO_LABEL);
        details.add(nutritionDetail);

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


        // Show nutritional information check

        nutritionDetail.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(nutritionDetail)){
                            NutritionDetailState nutritionState = NutritionDetailViewModel.getState();
                            List<String> recipe = nutritionState.getRecipe();
                            String id = recipe.get(0);

                            displayNutritionLabelImage(id);
                        }
                    }
                }
        );

        // add the recipe info later

        this.add(title);
        this.add(buttons);
        this.add(details);


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
