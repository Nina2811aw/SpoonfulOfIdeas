package data_access;

import app.RecipeDetailsViewUseCaseFactory;
import entity.RecipeInformation;
import use_case.add_to_favourites.AddToFavouritesDataAccessInterface;
import use_case.show_favourites.ShowFavouritesDataAccessInterface;

import java.io.*;
import java.util.*;

public class FavouritesDataAccessObject implements AddToFavouritesDataAccessInterface, ShowFavouritesDataAccessInterface {
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, String> recipes = new HashMap<>();
    private final File csvFile;

    public FavouritesDataAccessObject(String csvPath) throws IOException{
        csvFile = new File(csvPath);
        headers.put("Recipe Title", 0);
        headers.put("Recipe ID", 1);
        if (csvFile.length() == 0){
            AddToFavourites();
        }else{
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
                String header = reader.readLine();
                assert header.equals("Recipe Title,Recipe ID");

                String row;
                while((row = reader.readLine()) != null){
                    String[] col = row.split(",");
                    String recipeTitle = String.valueOf(col[headers.get("Recipe Title")]);
                    String recipeId = String.valueOf(col[headers.get("Recipe ID")]);
                    recipes.put(recipeTitle, recipeId);
                }
            }
        }
    }


    @Override
    public void AddToFavourites(String recipeTitle, String recipeId) {
        recipes.put(recipeTitle, recipeId);
        this.AddToFavourites();
    }

    @Override
    public String getFavourites() {
        StringBuilder recipeTitles = new StringBuilder();
        for(Map.Entry<String, String> entry: recipes.entrySet()){
            if(!recipeTitles.isEmpty()){
                recipeTitles.append(" , ");
            }
            recipeTitles.append(entry.getKey()).append('\n');
        }
        return recipeTitles.toString();
    }

    @Override
    public List<RecipeInformation> getFavouritesList() {
        List<RecipeInformation> favourites = new ArrayList<>();
        for (Map.Entry<String, String> entry : recipes.entrySet()) {
            favourites.add(new RecipeInformation(Integer.parseInt(entry.getValue()), entry.getKey()));
        }    return favourites;
    }

    private void AddToFavourites(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(" , ", headers.keySet()));
            writer.newLine();

            for(Map.Entry<String, String> entry: recipes.entrySet()){
                String line = String.format("%s, %s",
                        entry.getKey(), entry.getValue());
                writer.write(line);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}