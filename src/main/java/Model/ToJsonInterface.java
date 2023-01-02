package Model;

import org.json.JSONObject;

public interface ToJsonInterface {
    /**
     * Turns class object into JSONObject for requests
     *
     * @return JSONObject containing each attribute of the given class
     */
    JSONObject toJson();

}
