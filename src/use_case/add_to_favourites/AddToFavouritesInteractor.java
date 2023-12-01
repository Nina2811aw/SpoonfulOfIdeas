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
        addToFavouritesDataAccessObject.AddToFavourites(recipeid, recipetitle);
        String recipes = addToFavouritesDataAccessObject.getFavourites();
        System.out.println(recipes);
        AddToFavouritesOutputData addToFavouritesOutputData = new AddToFavouritesOutputData(recipes);
        addToFavouritesOutputData.setFavouriteFilled(addToFavouritesDataAccessObject.isFavourite(recipetitle));
        addToFavouritesPresenter.prepareSuccessView(addToFavouritesOutputData);
    }
}
