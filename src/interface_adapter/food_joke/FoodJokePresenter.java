package interface_adapter.food_joke;

import use_case.food_joke.FoodJokeOutputBoundary;
import use_case.food_joke.FoodJokeOutputData;

public class FoodJokePresenter implements FoodJokeOutputBoundary {

    private final FoodJokeViewModel foodJokeViewModel;

    public FoodJokePresenter(FoodJokeViewModel foodJokeViewModel) {
        this.foodJokeViewModel = foodJokeViewModel;
    }

    @Override
    public void prepareJokeView(FoodJokeOutputData foodJokeOutputData) {
        System.out.println("food joke presenter");
        FoodJokeState state = this.foodJokeViewModel.getState();
        state.setFoodJoke(foodJokeOutputData.getJoke());
        this.foodJokeViewModel.setState(state);
        this.foodJokeViewModel.firePropertyChanged();
    }
}
