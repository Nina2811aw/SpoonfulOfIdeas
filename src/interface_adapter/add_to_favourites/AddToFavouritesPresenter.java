package interface_adapter.add_to_favourites;

import interface_adapter.ViewManagerModel;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import use_case.add_to_favourites.AddToFavouritesOutputBoundary;
import use_case.add_to_favourites.AddToFavouritesOutputData;
/* The Presenter class for the AddToFavourites use case. This updates the NutritionDetailViewModel
 * and the ViewManagerModel.
 * @author Shreya Dubey
 * */
public class AddToFavouritesPresenter implements AddToFavouritesOutputBoundary {

    private final NutritionDetailViewModel nutritionDetailViewModel;

    private ViewManagerModel viewManagerModel;
    /*Creates a new AddToFavouritesPresenter when given a NutritionDetailViewModel and a ViewManagerModel.
     * @param nutritionDetailViewModel is what will be updated by the presenter.
     * @param viewManagerModel is what will manage the active view. */
    public AddToFavouritesPresenter(ViewManagerModel viewManagerModel, NutritionDetailViewModel nutritionDetailViewModel){
        this.viewManagerModel = viewManagerModel;
        this.nutritionDetailViewModel = nutritionDetailViewModel;
    }
    /*This public method implements the method in the AddToFavouritesOutputBoundary. It updates the NutritionDetailViewModel,
     * and the ViewManagerModel based on the AddToFavouritesOutputData.
     * @param outputData is a AddToFavouritesOutputData object. */
    @Override
    public void prepareSuccessView(AddToFavouritesOutputData output) {
        AddToFavouritesState addToFavouritesState = NutritionDetailViewModel.getAddToFavouritesState();
        addToFavouritesState.setFavourites(output.getFavourites());
        NutritionDetailState nutritionDetailState = nutritionDetailViewModel.getState();
        nutritionDetailState.setFavouritesFilled(output.getFavouriteFilled());
        nutritionDetailViewModel.setState(nutritionDetailState);
        this.nutritionDetailViewModel.setAddToFavouritesState(addToFavouritesState);
        nutritionDetailViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(nutritionDetailViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }


}
