package controller;

import model.HTTPGetInterface;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Austin
 */
class GameStatistic implements HTTPGetInterface {
    public String gameTurnNumber;
    @Override
    public String get(JSONObject json) {
        try {
            JSONObject jsonGameTurn = json.getJSONObject("turnNumber");
            
            gameTurnNumber =  Integer.toString(jsonGameTurn.getInt("Turn"));
            return gameTurnNumber;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } 
    }
}
