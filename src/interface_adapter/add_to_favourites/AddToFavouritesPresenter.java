package interface_adapter.add_to_favourites;

import interface_adapter.ViewManagerModel;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import use_case.add_to_favourites.AddToFavouritesOutputBoundary;
import use_case.add_to_favourites.AddToFavouritesOutputData;

public class AddToFavouritesPresenter implements AddToFavouritesOutputBoundary {

    private final NutritionDetailViewModel nutritionDetailViewModel;

    private ViewManagerModel viewManagerModel;

    public AddToFavouritesPresenter(ViewManagerModel viewManagerModel, NutritionDetailViewModel nutritionDetailViewModel){
        this.viewManagerModel = viewManagerModel;
        this.nutritionDetailViewModel = nutritionDetailViewModel;
    }
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
