package controller;
import model.HTTPGetInterface;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Austin
 */
class GameStatus implements HTTPGetInterface {
    public String isDeathMatchMode;
    @Override
    public String get(JSONObject json) {
        try {
            JSONObject jsonIsDeathMatchMode = json.getJSONObject("gameStatus");
            isDeathMatchMode = Boolean.toString(jsonIsDeathMatchMode.getBoolean("IsDeathMatch")) + "@";
            isDeathMatchMode += jsonIsDeathMatchMode.getString("Winner");
            return isDeathMatchMode;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } 
    }

}
