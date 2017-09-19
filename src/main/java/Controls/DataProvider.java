package Controls;

import Models.Product;
import Utils.FileWorker;
import Utils.JsonController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class DataProvider {

    private FileWorker fileWorker = new FileWorker("Products.json");
    private JsonController jsonController = new JsonController();

    public List<Product> getProducts(){
        List<Product> products = jsonController.jsonToModel(fileWorker.readFile());
        if(products == null){
            products = new ArrayList<Product>();
        }
        return products;
    }

    public void setProducts(List<Product> products){
        fileWorker.writeFile(jsonController.modelToJson(products));
    }
}
