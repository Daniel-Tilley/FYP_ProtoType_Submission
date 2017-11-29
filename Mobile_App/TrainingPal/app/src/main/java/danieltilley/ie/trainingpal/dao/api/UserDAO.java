package danieltilley.ie.trainingpal.dao.api;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import danieltilley.ie.trainingpal.interfaces.IAPICallBack;
import danieltilley.ie.trainingpal.interfaces.IAPIUserCallback;
import danieltilley.ie.trainingpal.model.ApiResponse;
import danieltilley.ie.trainingpal.model.User;
import danieltilley.ie.trainingpal.utilities.JSONHelper;
import danieltilley.ie.trainingpal.utilities.RESTResponseHelper;

public class UserDAO extends DAO {

    public UserDAO(Context ctx) {
        super(ctx);
    }

    public void getUser(String userID, final IAPIUserCallback apiUserCallback) {

        try {
            AndroidNetworking.post("http://trainingpal.me/t2zbsEefUB/User/GetUser.php")
                    .addJSONObjectBody(JSONHelper.createSingleJSONObject("id", userID))
                    .setTag("getUser")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                ApiResponse apiResponse = new ApiResponse();
                                apiResponse.setCode(JSONHelper.getJSONInt(response, "code"));
                                apiResponse.setMessage(JSONHelper.getJSONString(response, "message"));

                                if (apiResponse.getCode() == 200) {
                                    apiResponse.setData(JSONHelper.getJsonObject(response, "data"));
                                    User user = RESTResponseHelper.mapResponseToSingleUser(apiResponse);
                                    apiUserCallback.onSuccess(user);
                                } else {
                                    apiUserCallback.onError(apiResponse.getMessage());
                                }
                            } catch (JSONException e) {
                                Log.e("JSON_Error", "Error parsing response: " + e);
                            }
                        }

                        @Override
                        public void onError(ANError error) {
                        }
                    });
        } catch (JSONException e) {
            Log.e("JSON_Error", "Error creating request object: " + e);
        }
    }

    public void createUser(User user, final IAPICallBack iapiCallBack){
            AndroidNetworking.post("http://trainingpal.me/t2zbsEefUB/User/CreateUser.php")
                    .addJSONObjectBody(RESTResponseHelper.mapUserToJSONObject(user))
                    .setTag("getUser")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                ApiResponse apiResponse = new ApiResponse();
                                apiResponse.setCode(JSONHelper.getJSONInt(response, "code"));
                                apiResponse.setMessage(JSONHelper.getJSONString(response, "message"));

                                if (apiResponse.getCode() == 200) {
                                    iapiCallBack.onSuccess(apiResponse);
                                } else {
                                    iapiCallBack.onError(apiResponse.getMessage());
                                }
                            } catch (JSONException e) {
                                Log.e("JSON_Error", "Error parsing response: " + e);
                            }
                        }

                        @Override
                        public void onError(ANError error) {
                        }
                    });
    }

    public void updateUser(JSONObject user, final IAPICallBack iapiCallBack){
        AndroidNetworking.post("http://trainingpal.me/t2zbsEefUB/User/UpdateUser.php")
                .addJSONObjectBody(user)
                .setTag("getUser")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ApiResponse apiResponse = new ApiResponse();
                            apiResponse.setCode(JSONHelper.getJSONInt(response, "code"));
                            apiResponse.setMessage(JSONHelper.getJSONString(response, "message"));

                            if (apiResponse.getCode() == 200) {
                                iapiCallBack.onSuccess(apiResponse);
                            } else {
                                iapiCallBack.onError(apiResponse.getMessage());
                            }
                        } catch (JSONException e) {
                            Log.e("JSON_Error", "Error parsing response: " + e);
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                    }
                });
    }
}

