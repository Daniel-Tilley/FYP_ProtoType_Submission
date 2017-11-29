package danieltilley.ie.trainingpal.utilities;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import danieltilley.ie.trainingpal.model.ApiResponse;
import danieltilley.ie.trainingpal.model.User;

public final class RESTResponseHelper {

    public static User mapResponseToSingleUser(ApiResponse apiResponse){
        User user = new User();

        try {
            JSONArray userArray = JSONHelper.getJsonArray(apiResponse.getData(),"users");
            JSONObject jsonObject = JSONHelper.getJSONArrayJSONObject(userArray);
            Gson gson = new Gson();
            user = gson.fromJson(jsonObject.toString(),User.class);

        } catch (JSONException e) {
            Log.e("JSON_Error", "Error mapping api response to user: " + e);
        }

        return user;
    }

    public static JSONObject mapUserToJSONObject(User user){

        Gson gson = new Gson();
        String jsonString = gson.toJson(user);
        JSONObject request = null;

        try {
            request = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.e("JSON_Error", "Error mapping user to JSON: " + e);
        }

        return request;
    }
}
