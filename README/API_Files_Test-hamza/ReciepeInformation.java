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

public class ReciepeInformation {
    public static List<List<String>> info_list = new ArrayList<>();
    public ReciepeInformation(List<Integer> recipeId)

    {
        String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        for (int i = 0; i < recipeId.size(); i++) {
            String id = String.valueOf(recipeId.get(i));
            String url = "https://api.spoonacular.com/recipes/" + id + "/information?includeNutrition=false";
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("x-api-key", API_TOKEN)
                    .addHeader("Content-Type", "application/json")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                assert response.body() != null;
                JSONObject responseBody = new JSONObject(response.body().string());
                List<String> inner_lst = new ArrayList<>();

                // Adding title to nested list
                inner_lst.add(responseBody.get("title").toString());

                // Adding Instructions to the list
                inner_lst.add(responseBody.get("instructions").toString());
                info_list.add(inner_lst);
                //System.out.println(responseBody);
                //System.out.println(responseBody.get("title").toString());
                //System.out.println("Cooking Time: " + responseBody.get("title").toString() + " min");
                //System.out.println(responseBody.get("instructions").toString());

            } catch (IOException | JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

