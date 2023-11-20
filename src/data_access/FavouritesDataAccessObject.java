package data_access;

import entity.RecipeInformation;
import use_case.show_favourites.ShowFavouritesDataAccessInterface;

import java.util.*;
import java.io.*;

public class FavouritesDataAccessObject {
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, String> recipes = new HashMap<>();
    private final File csvFile;

    public FavouritesDataAccessObject(String csvPath) throws IOException{
        csvFile = new File(csvPath);
        headers.put("Recipe Title", 0);
        headers.put("Recipe ID", 1);
        if (csvFile.length() == 0){
            // AddToFavourites(); <- retaining similar structure to AddToFavourites
            //                       Use Case, but removing aspects irrelevant to current use case.
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


}
