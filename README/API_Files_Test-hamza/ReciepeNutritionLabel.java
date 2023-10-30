import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ReciepeNutritionLabel {
    public static List<String> label_list = new ArrayList<>();

    public ReciepeNutritionLabel(List<Integer> recipeId) {

        String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        for (int i = 0; i < recipeId.size(); i++) {
            String id = String.valueOf(recipeId.get(i));
            String url = "https://api.spoonacular.com/recipes/" + id + "/nutritionLabel.png";
            label_list.add(url);
        }
    }
}