package Models;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class Category {

    private String nameCategory;

    public Category(String nameCategory){
        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return nameCategory;
    }
}
