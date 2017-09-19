package Utils;

import Models.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class JsonController {

    private Gson gson = new Gson();

    public String modelToJson(List<Product> products){
        return gson.toJson(products);
    }

    public List<Product> jsonToModel(String strJson){
        Type type = new TypeToken<ArrayList<Product>>(){}.getType();
        return gson.fromJson(strJson, type);
    }
}
