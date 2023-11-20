package interface_adapter.food_joke;

import use_case.food_joke.FoodJokeInteractor;

public class FoodJokeController {

    final FoodJokeInteractor foodJokeInteractor;


    public FoodJokeController(FoodJokeInteractor foodJokeInteractor) {
        this.foodJokeInteractor = foodJokeInteractor;

    }

    public void execute(){
        this.foodJokeInteractor.execute();
    }
}
