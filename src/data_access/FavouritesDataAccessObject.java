package data_access;

import app.RecipeDetailsViewUseCaseFactory;
import entity.RecipeInformation;
import use_case.add_to_favourites.AddToFavouritesDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FavouritesDataAccessObject implements AddToFavouritesDataAccessInterface {
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
                    String recipetitle = String.valueOf(col[headers.get("Recipe Title")]);
                    String recipeid = String.valueOf(col[headers.get("Recipe ID")]);
                    recipes.put(recipetitle, recipeid);
                }
            }
        }
    }


    @Override
    public void AddToFavourites(String recipetitle, String recipeid) {
        recipes.put(recipetitle, recipeid);
        this.AddToFavourites();
    }

    @Override
    public String getFavourites() {
        StringBuilder recipetitles = new StringBuilder();
        for(Map.Entry<String, String> entry: recipes.entrySet()){
            if(!recipetitles.isEmpty()){
                recipetitles.append(",");
            }
            recipetitles.append(entry.getValue()).append('\n');
        }
        return recipetitles.toString();
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
