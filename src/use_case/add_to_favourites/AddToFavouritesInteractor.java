package use_case.add_to_favourites;

public class AddToFavouritesInteractor implements AddToFavouritesInputBoundary{
    final AddToFavouritesDataAccessInterface addToFavouritesDataAccessObject;

    final AddToFavouritesOutputBoundary addToFavouritesPresenter;

    public AddToFavouritesInteractor(AddToFavouritesDataAccessInterface addToFavouritesDataAccessInterface, AddToFavouritesOutputBoundary addToFavouritesOutputBoundary){
        this.addToFavouritesDataAccessObject = addToFavouritesDataAccessInterface;
        this.addToFavouritesPresenter = addToFavouritesOutputBoundary;
    }

    @Override
    public void execute(AddToFavouritesInputData addToFavouritesInputData) {
        String recipetitle = addToFavouritesInputData.getTitle();
        String recipeid = addToFavouritesInputData.getID();
        addToFavouritesDataAccessObject.AddToFavourites(recipetitle, recipeid);
        String recipes = addToFavouritesDataAccessObject.getFavourites();
        AddToFavouritesOutputData addToFavouritesOutputData = new AddToFavouritesOutputData(recipes);
        addToFavouritesOutputData.setFavouriteFilled(addToFavouritesDataAccessObject.isFavourite(recipetitle));
        addToFavouritesPresenter.prepareSuccessView(addToFavouritesOutputData);
    }
}
