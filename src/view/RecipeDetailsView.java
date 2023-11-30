package view;

import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.add_to_favourites.AddToFavouritesState;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;

import static data_access.SpoonacularDataAccessObject.displayNutritionLabelImage;
import static data_access.SpoonacularDataAccessObject.get_instructons;

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

    private final JLabel titleLabel;
    private final JLabel instructions;


    public RecipeDetailsView(NutritionDetailController nutritionDetailController, NutritionDetailViewModel nutritionDetailViewModel, BackToChooseController backToChooseController, AddToFavouritesController addToFavouritesController) {
        this.nutritionDetailViewModel = nutritionDetailViewModel;
        this.nutritionDetailController = nutritionDetailController;
        nutritionDetailViewModel.addPropertyChangeListener(this);

        this.backToChooseController = backToChooseController;
        this.addToFavouritesController = addToFavouritesController;

        JLabel title = new JLabel("---title----"); // Change text
        titleLabel = new JLabel();
        instructions = new JLabel();
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        // We  have our main panel, referred to with "this" and then 2 sub-panels.
        // One for the back and addToFavourites button at the header, and another
        // for the recipe details + show nutritional contents button.
        this.setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new BorderLayout());
        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));

        // Button Setup
        back = new JButton();
        Icon backIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/back_icon.png")));
        back.setIcon(backIcon);
        buttons.add(back, BorderLayout.WEST);

        addToFavourites = new JButton(NutritionDetailViewModel.ADD_TO_FAVOURITES_LABEL);
        buttons.add(addToFavourites, BorderLayout.EAST);

        nutritionDetail = new JButton(NutritionDetailViewModel.NUTRITION_INFO_LABEL);

        details.add(Box.createVerticalGlue()); // glue just adds invisible spacing between panel objects.
        details.add(title);
        details.add(titleLabel);
        details.add(instructions);
        details.add(nutritionDetail);
        details.add(Box.createVerticalGlue());

        this.add(Box.createHorizontalGlue());
        this.add(buttons, BorderLayout.NORTH);
        this.add(details, BorderLayout.CENTER);


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
}


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        NutritionDetailState state = (NutritionDetailState) evt.getNewValue();
        titleLabel.setText(state.getRecipe().get(1));
        String text = get_instructons((state.getRecipe().get(0)));
        text = "<html>" + text.replaceAll("\n", "<br>") + "</html>";

        instructions.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "done");
    }
}
