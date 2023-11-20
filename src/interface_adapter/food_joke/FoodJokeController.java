package interface_adapter.food_joke;

import use_case.food_joke.FoodJokeInputBoundary;
import use_case.food_joke.FoodJokeInteractor;

public class FoodJokeController {

    final FoodJokeInputBoundary foodJokeInteractor;


    public FoodJokeController(FoodJokeInputBoundary foodJokeInteractor) {
        this.foodJokeInteractor = foodJokeInteractor;

    }

    public void execute(){
        this.foodJokeInteractor.execute();
        System.out.println("food joke controller");
    }
}
