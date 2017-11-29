package danieltilley.ie.trainingpal.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONHelper {

    public static String getJSONString(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getString(key);
    }

    public static int getJSONInt(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getInt(key);
    }

    public static boolean getJSONBool(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getBoolean(key);
    }

    public static JSONObject getJsonObject(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getJSONObject(key);
    }

    public static JSONArray getJsonArray(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getJSONArray(key);
    }

    public static JSONObject getJSONArrayJSONObject(JSONArray jsonArray) throws JSONException {
        return jsonArray.getJSONObject(0);
    }

    public static JSONObject getJSONArrayJSONObject(JSONArray jsonArray, int index) throws JSONException {
        return jsonArray.getJSONObject(index);
    }

    public static String getJSONArrayString(JSONArray jsonArray, String key) throws JSONException {
        return jsonArray.getJSONObject(0).getString(key);
    }

    public static String getJSONArrayString(JSONArray jsonArray, int index, String key) throws JSONException {
        return jsonArray.getJSONObject(index).getString(key);
    }

    public static int getJSONArrayInt(JSONArray jsonArray, String key) throws JSONException {
        return jsonArray.getJSONObject(0).getInt(key);
    }

    public static int getJSONArrayInt(JSONArray jsonArray, int index, String key) throws JSONException {
        return jsonArray.getJSONObject(index).getInt(key);
    }

    public static boolean getJSONArrayBool(JSONArray jsonArray, String key) throws JSONException {
        return jsonArray.getJSONObject(0).getBoolean(key);
    }

    public static boolean getJSONArrayBool(JSONArray jsonArray, int index, String key) throws JSONException {
        return jsonArray.getJSONObject(index).getBoolean(key);
    }

    public static JSONObject createSingleJSONObject(String key, String value) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }
}
