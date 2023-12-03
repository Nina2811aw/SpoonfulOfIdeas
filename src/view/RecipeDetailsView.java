package view;

import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.add_to_favourites.AddToFavouritesState;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.extended_ingredients.ExtendedIngredientsController;
import interface_adapter.extended_ingredients.ExtendedIngredientsViewModel;

import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;

import interface_adapter.extended_ingredients.ExtendedIngredientsController;
import interface_adapter.extended_ingredients.ExtendedIngredientsState;
import interface_adapter.extended_ingredients.ExtendedIngredientsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;

import static data_access.SpoonacularDataAccessObject.*;

public class RecipeDetailsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final ExtendedIngredientsViewModel extendedIngredientsViewModel;
    public String viewName = "Recipe Details";
    public final NutritionDetailViewModel nutritionDetailViewModel;

    //initalize buttons back, addToFavourites, nutritionDetail
    final JButton back;
    public final BackToChooseController backToChooseController;

    private final JButton addToFavourites;
    public final AddToFavouritesController addToFavouritesController;
    private final JLabel recip_img;
    private final JButton nutritionDetail;
    private final JButton extendedIng;
    public final ExtendedIngredientsController extendedIngredientsController;
    public final NutritionDetailController nutritionDetailController;

    private final JLabel titleLabel;
    private final JLabel instructions;

    private ImageIcon resizeImageIcon(ImageIcon originalIcon, int width, int height) {
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void adjustFrameSize() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame != null) {
                frame.pack();
            }
        });
    }

    public RecipeDetailsView(NutritionDetailController nutritionDetailController,
                             NutritionDetailViewModel nutritionDetailViewModel,
                             ExtendedIngredientsController extendedIngredientsController,
                             ExtendedIngredientsViewModel extendedIngredientsViewModel,
                             BackToChooseController backToChooseController,
                             AddToFavouritesController addToFavouritesController) {


        this.nutritionDetailViewModel = nutritionDetailViewModel;
        this.nutritionDetailController = nutritionDetailController;
        this.extendedIngredientsController = extendedIngredientsController;
        this.extendedIngredientsViewModel = extendedIngredientsViewModel;
        extendedIngredientsViewModel.addPropertyChangeListener(this);
        nutritionDetailViewModel.addPropertyChangeListener(this);

        this.backToChooseController = backToChooseController;
        this.addToFavouritesController = addToFavouritesController;

        titleLabel = new JLabel();
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        instructions = new JLabel();
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        recip_img = new JLabel();

        // Inner central panel for title and instructions. Essentially a recipe card.
        JPanel innerCentralPanel = new JPanel();
        innerCentralPanel.setLayout(new BoxLayout(innerCentralPanel, BoxLayout.Y_AXIS));
        innerCentralPanel.setBackground(new Color(0xF5F5F5)); // Set the background to this different grey shade
        innerCentralPanel.add(Box.createVerticalStrut(20), BorderLayout.NORTH); // Adds spacing to the top
        innerCentralPanel.add(titleLabel);
        innerCentralPanel.add(instructions);
        innerCentralPanel.add(recip_img);
        innerCentralPanel.add(Box.createHorizontalStrut(750), BorderLayout.WEST); // Adds spacing to the left
        innerCentralPanel.add(Box.createHorizontalStrut(750), BorderLayout.EAST); // Adds spacing to the right
        innerCentralPanel.add(Box.createVerticalStrut(20), BorderLayout.SOUTH); // Adds spacing to the bottom


        // Outer panel to provide padding and centering for inner recipe card.
        JPanel outerCentralPanel = new JPanel(new GridBagLayout()); // Using GridBagLayout for centering
        outerCentralPanel.setBackground(this.getBackground()); // Match the background color of the main panel
        outerCentralPanel.add(innerCentralPanel); // Add the inner panel to the outer panel

        // We  have our main panel, referred to with "this" and then 2 sub-panels.
        // One for the back and addToFavourites button at the header, and another
        // for the recipe details + show nutritional contents button.
        this.setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new BorderLayout());
        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.X_AXIS));

        // Button Setup
        back = new JButton();
        Icon backIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/back_icon.png")));
        back.setIcon(backIcon);
        buttons.add(back, BorderLayout.WEST);

        addToFavourites = new JButton();
        buttons.add(addToFavourites, BorderLayout.EAST);
        details.add(Box.createHorizontalGlue());
        details.add(recip_img);
        details.setAlignmentX(Component.CENTER_ALIGNMENT);

        nutritionDetail = new JButton(NutritionDetailViewModel.NUTRITION_INFO_LABEL);
        nutritionDetail.setAlignmentX(Component.CENTER_ALIGNMENT);

        extendedIng = new JButton(ExtendedIngredientsViewModel.INGREDIENTS_INFO_LABEL);
        extendedIng.setAlignmentX(Component.CENTER_ALIGNMENT);

        details.add(nutritionDetail);
        details.add(extendedIng);


        this.add(Box.createHorizontalGlue());
        this.add(buttons, BorderLayout.NORTH);
        this.add(outerCentralPanel, BorderLayout.CENTER); // Add the central card panel to the main panel
        this.add(details, BorderLayout.SOUTH);


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
                            addToFavouritesController.execute(recipe.get(1), recipe.get(0));
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
                            nutritionDetailController.displayNutritionLabelImage(id);
                        }
                    }
                }
        );

        extendedIng.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(extendedIng)){
                            ExtendedIngredientsState extendedState = ExtendedIngredientsViewModel.getState();
                            List<String> recipe = extendedState.getRecipe();
                            String id = recipe.get(0);
                            extendedIngredientsController.displayExtendedIngredientsImage(id);
                        }
                    }
                }
        );


        //nutritionDetailViewModel.addPropertyChangeListener(evt -> adjustFrameSize());
        //extendedIngredientsViewModel.addPropertyChangeListener(evt -> adjustFrameSize());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        adjustFrameSize();
        ExtendedIngredientsState ingState = (ExtendedIngredientsState) evt.getNewValue();
        NutritionDetailState state = (NutritionDetailState) evt.getNewValue();
        titleLabel.setText(state.getRecipe().get(1));
        Font boldFont  = titleLabel.getFont().deriveFont(Font.BOLD);
        titleLabel.setFont(boldFont);
        Font largerFont = titleLabel.getFont().deriveFont((float) 20);
        titleLabel.setFont(largerFont);


        String text = get_instructions((state.getRecipe().get(0)));
        text = "<html>" + text.replaceAll("\n", "<br>") + "</html>";

        instructions.setText(text);
        Font regularFont = instructions.getFont().deriveFont(Font.PLAIN);
        instructions.setFont(regularFont);

        ImageIcon imageIcon = get_image(state.getRecipe().get(0));
        ImageIcon resizedIcon = resizeImageIcon(imageIcon, 400, 400);

        recip_img.setIcon(resizedIcon);
        recip_img.setAlignmentX(Component.LEFT_ALIGNMENT);

        Boolean toFillFavourites = state.getFavouritesFilled();
        if (toFillFavourites){
            Icon favouritesIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/star_filled.png")));
            addToFavourites.setIcon(favouritesIcon);
        }else {
            Icon favouritesIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/star.png")));
            addToFavourites.setIcon(favouritesIcon);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "done");
    }
}
