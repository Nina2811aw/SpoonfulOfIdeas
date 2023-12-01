package use_case.add_to_favourites;

public class AddToFavouritesInteractor implements AddToFavouritesInputBoundary{
    final AddToFavouritesDataAccessInterface addToFavouritesDataAccessObject;

    final AddToFavouritesOutputBoundary addToFavouritesPresenter;
    /*Public method that builds an interactor for the add to favourites use case, taking in a Data Access Interface, and an Output Boundary.*/

    public AddToFavouritesInteractor(AddToFavouritesDataAccessInterface addToFavouritesDataAccessInterface, AddToFavouritesOutputBoundary addToFavouritesOutputBoundary){
        this.addToFavouritesDataAccessObject = addToFavouritesDataAccessInterface;
        this.addToFavouritesPresenter = addToFavouritesOutputBoundary;
    }
    /*A public method that implements the execute method specified in the AddToFavouritesInputBoundary. This method gets
     * a list of RecipeInformation from a DAO. It packages that information into Output Data, and calls the Presenter's prepareSuccessView method
     * with aforementioned Output Data. */
    @Override
    public void execute(AddToFavouritesInputData addToFavouritesInputData) {
        String recipetitle = addToFavouritesInputData.getTitle();
        String recipeid = addToFavouritesInputData.getID();
        addToFavouritesDataAccessObject.AddToFavourites(recipeid, recipetitle);
        String recipes = addToFavouritesDataAccessObject.getFavourites();
        System.out.println(recipes);
        AddToFavouritesOutputData addToFavouritesOutputData = new AddToFavouritesOutputData(recipes);
        addToFavouritesOutputData.setFavouriteFilled(addToFavouritesDataAccessObject.isFavourite(recipeid));
        addToFavouritesPresenter.prepareSuccessView(addToFavouritesOutputData);
    }
}
