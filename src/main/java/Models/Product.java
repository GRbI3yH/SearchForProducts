package Models;

import java.util.List;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class Product {

    private String name;
    private List<Category> categories;
    private float price;

    public Product(){}

    public Product( String name, List<Category> categories, float price){

        this.name = name;
        this.categories = categories;
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Имя = "+name+"\tЦена = "+price+"\tКатегории = "+categories;
    }

    public static String getFieldNames(){
        return "name |"+" categories | "+" price";
    }
}
