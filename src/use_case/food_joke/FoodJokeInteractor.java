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
        System.out.println("food joke interactor");
        String joke = foodJokeDataAccessObject.getFoodJoke();
        FoodJokeOutputData outputData = new FoodJokeOutputData(joke);
        foodJokePresenter.prepareJokeView(outputData);
    }
}
