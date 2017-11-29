package danieltilley.ie.trainingpal.interfaces;

import danieltilley.ie.trainingpal.model.ApiResponse;

public interface IAPICallBack {
    void onSuccess(ApiResponse apiResponse);
    void onError(String message);
}
