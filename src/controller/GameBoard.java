package controller;
import model.HTTPGetInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class GameBoard implements HTTPGetInterface {
    public char[] gameBoardArray = new char[9];
    String gameBoardString;
    
    @Override
    public String get(JSONObject json) {
        try {
            JSONArray gameboardArray = json.getJSONArray("positions");

            for (int i = 0; i < 9; i++) {
                JSONObject gameboardPosition = gameboardArray.getJSONObject(i);
                gameBoardArray[Integer.parseInt(gameboardPosition.getString("Spot"))] = gameboardPosition.getString("Token").charAt(0);

            }
            gameBoardString = new String(gameBoardArray);
            return gameBoardString;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
