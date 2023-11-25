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
        String[] words = joke.split("\\s+");

        /**StringBuilder builder = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            builder.append(words[i]);
            builder.append(" ");
            if(i % 8 == 0){
                builder.append("\n");
            }
        }
         joke = builder.toString();
         **/

        FoodJokeOutputData outputData = new FoodJokeOutputData(joke);
        foodJokePresenter.prepareJokeView(outputData);
    }
}
