package use_case.food_joke;

public class FoodJokeInteractor implements FoodJokeInputBoundary{

    final FoodJokeDataAccessInterface foodJokeDataAccessObject;

    final FoodJokeOutputBoundary foodJokePresenter;

    public FoodJokeInteractor(FoodJokeDataAccessInterface foodJokeDataAccessObject, FoodJokeOutputBoundary foodJokePresenter) {
        this.foodJokeDataAccessObject = foodJokeDataAccessObject;
        this.foodJokePresenter = foodJokePresenter;
    }

    @Override
    public void execute() {

    }
}
