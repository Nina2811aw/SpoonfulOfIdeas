package DAO;

import data_access.SpoonacularDataAccessObject;
import entity.RecipeInformation;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.choose_recipe.ChooseRecipeInputData;
import use_case.recipe_search.RecipeSearchInputData;

import javax.swing.ImageIcon;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SpoonacularDataAccessObjectTest {

    private MockWebServer mockWebServer;
    private SpoonacularDataAccessObject dao;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        dao = new SpoonacularDataAccessObject();
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void getRecipeIdeasTest() throws IOException {
        String jsonResponse = "[" +
                "{" +
                "\"id\": 90629," +
                "\"title\": \"Baked Apples in White Wine\"," +
                "\"calories\": 210," +
                "\"carbs\": \"43g\"," +
                "\"fat\": \"3g\"," +
                "\"protein\": \"1g\"," +
                "\"image\": \"https://spoonacular.com/recipeImages/90629-312x231.jpg\"" +
                "}," +
                "{" +
                "\"id\": 284420," +
                "\"title\": \"Chocolate Silk Pie with Marshmallow Meringue\"," +
                "\"calories\": 226," +
                "\"carbs\": \"33g\"," +
                "\"fat\": \"10g\"," +
                "\"protein\": \"2g\"," +
                "\"image\": \"https://spoonacular.com/recipeImages/284420-312x231.jpg\"" +
                "}" +
                "]";
        mockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        String ingredients = "chicken, tomato";
        Map<String, Boolean> diets = new HashMap<>();
        diets.put("vegetarian", false);
        diets.put("vegan", false);
        Map<String, Boolean> intolerances = new HashMap<>();
        intolerances.put("gluten", true);
        intolerances.put("dairy", false);
        String cuisine = "Italian";
        String protein = "high protein"; // Corresponds to minProtein = 20, maxProtein = 100
        String fat = "low fat"; // Corresponds to maxFat = 35
        String carbs = "high carbs"; // Corresponds to minCarbs = 50, maxCarbs = 200
        String calories = "high calorie"; // Corresponds to minCalories = 700, maxCalories = 2000

// Construct RecipeSearchInputData based on the provided logic
        RecipeSearchInputData inputData = new RecipeSearchInputData(
                ingredients,
                "vegan,vegetarian", // Constructed from diets map
                cuisine,
                "gluten,dairy", // Constructed from intolerances map
                20, // minProtein
                100, // maxProtein
                0, // minFat
                35, // maxFat
                50, // minCarbs
                200, // maxCarbs
                700, // minCalories
                2000 // maxCalories
        );

        List<RecipeInformation> recipes = dao.getRecipeIdeas(inputData);
        assertNotNull(recipes);
    }

    @Test
    void getRecipeDetailsTest() throws IOException {
        String jsonResponse = "{" +
                "\"id\": 123456," +
                "\"title\": \"Chicken Parmesan\"," +
                "\"instructions\": \"1. Preheat oven to 350F. 2. Bread the chicken...\"," +
                "\"extendedIngredients\": [" +
                "{" +
                "\"name\": \"chicken breast\"," +
                "\"amount\": 2" +
                "}," +
                "{" +
                "\"name\": \"breadcrumbs\"," +
                "\"amount\": 1.5" +
                "}" +
                "]," +
                "\"readyInMinutes\": 45" +
                "}";
        mockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        ChooseRecipeInputData inputData = new ChooseRecipeInputData(new RecipeInformation(123456, "Chicken Parmesan"));

        List<String> details = dao.getRecipeDetails(inputData);

        assertNotNull(details);
        assertFalse(details.isEmpty());
    }
//
//    @Test
//    void displayNutritionLabelImageTest() throws InterruptedException {
//        // Set the system property for headless mode
//        System.setProperty("java.awt.headless", "true");
//
//        // Enqueue a mock response with a timeout
//        mockWebServer.enqueue(new MockResponse()
//                .setResponseCode(200)
//                .setBody("image data")
//                .setBodyDelay(1, TimeUnit.SECONDS)); // Adjust the delay as needed
//
//        // Call the method
//        SpoonacularDataAccessObject.displayNutritionLabelImage("123");
//
//        // Take the recorded request and verify its components
//        RecordedRequest request = mockWebServer.takeRequest();
//        assertEquals("/recipes/123/nutritionLabel.png", request.getPath());
//    }

    @Test
    void getFoodJokeTest() throws IOException {
        String jsonResponse = "{" +
                "\"text\": \"Why did the tomato turn red? Because it saw the salad dressing!\"" +
                "}";
        mockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        String joke = dao.getFoodJoke();

        assertNotNull(joke);
        assertFalse(joke.isEmpty());
    }

    @Test
    void get_instructionsTest() throws IOException {
        String jsonResponse = "{" +
                "\"id\": 123456," +
                "\"title\": \"Chicken Parmesan\"," +
                "\"instructions\": \"1. Preheat oven to 350F. 2. Bread the chicken, then bake...\"," +
                "\"readyInMinutes\": 45," +
                "\"extendedIngredients\": [" +
                "{" +
                "\"name\": \"chicken breast\"," +
                "\"amount\": 2," +
                "\"unit\": \"pieces\"" +
                "}," +
                "{" +
                "\"name\": \"breadcrumbs\"," +
                "\"amount\": 1.5," +
                "\"unit\": \"cups\"" +
                "}" +
                "]" +
                "}";
        mockWebServer.enqueue(new MockResponse().setBody(jsonResponse));

        String instructions = SpoonacularDataAccessObject.get_instructions("123");

        assertNotNull(instructions);
        assertFalse(instructions.isEmpty());
        // Further assertions
    }
//
//    @Test
//    void get_imageTest() throws InterruptedException {
//        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("image data"));
//
//        ImageIcon image = SpoonacularDataAccessObject.get_image("123");
//
//        RecordedRequest request = mockWebServer.takeRequest();
//        assertEquals("/recipes/123/ingredientWidget", request.getPath());
//        assertNotNull(image);
//    }

}
