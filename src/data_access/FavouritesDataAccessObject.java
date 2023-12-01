package data_access;

import app.RecipeDetailsViewUseCaseFactory;
import entity.RecipeInformation;
import use_case.add_to_favourites.AddToFavouritesDataAccessInterface;
import use_case.show_favourites.ShowFavouritesDataAccessInterface;

import java.io.*;
import java.util.*;

/**
 * Data access object for handling user's favourites-related operations.
 * This class manages the favourites feature, including adding to and retrieving the user's favourites,
 * and storing that data in a CSV file.
 */
public class FavouritesDataAccessObject implements AddToFavouritesDataAccessInterface, ShowFavouritesDataAccessInterface {

    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, String> recipes = new HashMap<>();
    private final File csvFile;

    /**
     * Constructs a FavouritesDataAccessObject with a specified local CSV file path.
     * The constructor initializes the favourites data from the provided CSV file.
     *
     * @param csvPath the path to the CSV file containing favourites data
     * @throws IOException if an I/O error occurs
     */
    public FavouritesDataAccessObject(String csvPath) throws IOException{
        csvFile = new File(csvPath);
        headers.put("Recipe ID", 0);
        headers.put("Recipe Title", 1);
        if (csvFile.length() == 0){
            AddToFavourites();
        }else{
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
                String header = reader.readLine();
                assert header.equals("Recipe ID,Recipe Title");

                String row;
                while((row = reader.readLine()) != null){
                    String[] col = row.split(",");
                    String recipeTitle = String.valueOf(col[headers.get("Recipe Title")]);
                    String recipeId = String.valueOf(col[headers.get("Recipe ID")]);
                    recipes.put(recipeId, recipeTitle);
                }
            }
        }
    }

    /**
     * Adds or removes a recipe to/from favourites.
     * If the recipe is already a favourite, it is removed; otherwise, it is added.
     *
     * @param recipeId    the ID of the recipe
     * @param recipeTitle the title of the recipe
     */
    @Override
    public void AddToFavourites(String recipeId, String recipeTitle) {
        if (recipes.containsKey(recipeId)){
            recipes.remove(recipeId);
        }else{
            recipes.put(recipeId, recipeTitle);
        }
        this.AddToFavourites();
    }

    /**
     * Returns a formatted string of all the user's favourite recipes.
     * @return a string listing all favourites
     */
    @Override
    public String getFavourites() {
        StringBuilder recipeTitles = new StringBuilder();
        recipeTitles.append("Favourites List:\n");
        for(Map.Entry<String, String> entry: recipes.entrySet()){
            if(!recipeTitles.isEmpty()){
                recipeTitles.append("* ");
            }
            recipeTitles.append(entry.getValue()).append('\n');
        }
        return recipeTitles.toString();
    }

    /**
     * Writes the current list/state of the user's favourites into the CSV file.
     */
    private void AddToFavourites(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(" , ", headers.keySet()));
            writer.newLine();

            for(Map.Entry<String, String> entry: recipes.entrySet()){
                String line = String.format("%s,%s",
                        entry.getKey(), entry.getValue());
                writer.write(line);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves a list of favourite recipes.
     * During creation of the FavouritesDAO all the values stored in favourites.csv is now in program stored
     * in recipes map. Hence, we construct the list of RecipeInformation object utilizing this object.
     *
     * @return a list of RecipeInformation objects, which contain the user's favourite recipe details.
     */
    @Override
    public List<RecipeInformation> getFavouritesList() {
        List<RecipeInformation> favourites = new ArrayList<>();
        for (Map.Entry<String, String> entry : recipes.entrySet()) {
            favourites.add(new RecipeInformation(Integer.parseInt(entry.getKey()), entry.getValue()));
        }
        return favourites;
    }

    /**
     * Checks if a recipe is marked as a favourite.
     *
     * @param recipeId the ID of the recipe to check
     * @return true if the recipe is a favourite, false otherwise
     */
    public Boolean isFavourite(String recipeId){
        return recipes.containsKey(recipeId);
    }
}