package use_case.food_joke;

import data_access.SpoonacularDataAccessObject;
import interface_adapter.food_joke.FoodJokePresenter;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodJokeInteractorTest {

    @Test
    public void executeTest(){
        FoodJokeDataAccessInterface dataAccessObject = new SpoonacularDataAccessObject();

        FoodJokeOutputBoundary foodJokePresenter = new FoodJokeOutputBoundary() {
            @Override
            public void prepareJokeView(FoodJokeOutputData foodJokeOutputData) {
                assertNotNull(foodJokeOutputData.getJoke());
            }
        };

        FoodJokeInteractor foodJokeInteractor = new FoodJokeInteractor(dataAccessObject, foodJokePresenter);
        foodJokeInteractor.execute();
    }

}