package danieltilley.ie.trainingpal.model;

import org.json.JSONObject;

public class ApiResponse {
    private int code;
    private String message;
    private JSONObject data;

    public int getCode() {
        return code;
    }

    public String getMessage() { return message; }

    public JSONObject getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
