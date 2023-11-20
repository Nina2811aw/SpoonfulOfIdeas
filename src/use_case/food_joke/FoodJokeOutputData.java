package use_case.food_joke;

public class FoodJokeOutputData {
    private final String joke;


    public FoodJokeOutputData(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }


}
