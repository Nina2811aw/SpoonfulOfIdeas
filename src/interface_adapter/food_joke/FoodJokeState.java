package interface_adapter.food_joke;

public class FoodJokeState {

    private String foodJoke;

    public FoodJokeState(String foodJoke) {
        this.foodJoke = foodJoke;
    }

    public String getFoodJoke() {
        return foodJoke;
    }

    public void setFoodJoke(String foodJoke) {
        this.foodJoke = foodJoke;
    }
}
