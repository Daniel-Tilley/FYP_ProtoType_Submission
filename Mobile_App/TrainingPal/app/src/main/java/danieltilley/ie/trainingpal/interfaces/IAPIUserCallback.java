package danieltilley.ie.trainingpal.interfaces;

import danieltilley.ie.trainingpal.model.User;

public interface IAPIUserCallback {
    void onSuccess(User user);
    void onError(String message);
}
