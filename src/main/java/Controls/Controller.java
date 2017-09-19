package Controls;

import Models.Category;
import Models.CommandController;
import Models.ICommand;
import Models.Product;
import View.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class Controller {

    private Display display;
    private CommandController commandController = new CommandController();
    private DataProvider dataProvider = new DataProvider();
    private List<Product> products;

    public Controller(BufferedReader buffer){
        display = new Display(buffer);
        products = dataProvider.getProducts();
        intCommand();
    }

    public void executeCommand(String nameCommand){

        if(commandController.executeCommand(nameCommand)){
            display.show("Команда завершена");
        }else {
            display.show("Нет такой команды");
            display.show("Для вывода списка команд напишите = help");
        }
    }

    private void intCommand() {
        commandController.addCommand("help", new ICommand() {
            @Override
            public void execute() {
                display.show(commandController.getAllNameCommands());
            }
        });
        commandController.addCommand("save", new ICommand() {
            @Override
            public void execute() {
                dataProvider.setProducts(products);
            }
        });
        commandController.addCommand("load", new ICommand() {
            @Override
            public void execute() {
                products = dataProvider.getProducts();
            }
        });
        commandController.addCommand("show", new ICommand() {
            @Override
            public void execute() {
                for (Product product:products){
                    display.show(product.toString());
                }
            }
        });
        commandController.addCommand("del", new ICommand() {
            @Override
            public void execute() {
                display.show("Удалить по какому полю?");
                display.show(Product.getFieldNames());
                switch (display.read()){
                    case "name":
                        break;
                    case "categories":
                        break;
                    case "price":
                        break;
                }
                display.show("типо удалил");
                dataProvider.setProducts(products);
            }
        });

        commandController.addCommand("add", new ICommand() {
            @Override
            public void execute() {
                String name = "",price = "";
                List<Category> categories = new ArrayList<>();

                display.show("(str)name");
                name = display.read();

                display.show("(float)price");
                price = display.read();

                display.show("categories (str)(Вводить через запятую)");

                for (String categoryStr : Arrays.asList(display.read().split(","))){
                    categories.add(new Category(categoryStr));
                }

                try {
                    products.add(new Product(name,categories,Float.parseFloat(price)));
                    display.show("Запись добавленна");
                    dataProvider.setProducts(products);
                }catch (NumberFormatException e){
                    display.show("не правильно введены данные = "+price);
                }



            }
        });

        commandController.addCommand("search", new ICommand() {
            @Override
            public void execute() {
                boolean flagName = false,flagPrice = false,flagCategories = false;
                String max = null, min = null, nameProduct = null;
                List<String> categoryStrList = null;
                do{
                    display.show("По какому критерию ( n(name) | p(price) | c(categories) )?");
                    switch (display.read()){
                        case "n":
                            flagName = !flagName;
                            break;
                        case "p":
                            flagPrice = !flagPrice;
                            break;
                        case "c":
                            flagCategories = !flagCategories;
                            break;
                    }
                    display.show("активный поиск по критериям (Имя = "+flagName+"| Цена = "+flagPrice+"| Категории = "+flagCategories);
                    display.show("Продолжить включать критерии y(Да)/n(Нет)");
                }while (display.read().equals("y"));

                if(flagPrice){
                    display.show(" Максимум (float)");
                    max = display.read();

                    display.show(" Минимум (float)");
                    min = display.read();
                }
                if(flagName){
                    display.show("Имя товара (str)");
                    nameProduct = display.read();
                }
                if(flagCategories){
                    display.show("Категории (str)(Вводить через запятую)");
                    categoryStrList = Arrays.asList(display.read().split(","));//getReadCategories();
                }

                List<Product> products = new ArrayList<Product>(Controller.this.products);
                Iterator<Product> productIterator = products.iterator();
                while (productIterator.hasNext()){
                    Product product = productIterator.next();
                    if(flagPrice){
                        try {
                            if(!(Float.parseFloat(max) > product.getPrice() & product.getPrice() > Float.parseFloat(min))){
                                productIterator.remove();
                            }
                        }catch (NumberFormatException e){
                            display.show("не правильно введены данные = "+max+ " | "+min);
                        }
                    }
                    if(flagName){
                        product.getName().toLowerCase();
                        nameProduct.toLowerCase();
                        if(!(product.getName().contains(nameProduct))){
                            productIterator.remove();
                        }
                    }
                    if(flagCategories){
                        //.toLowerCase();
                        boolean checCategory = true;
                        for(Category category:product.getCategories()){
                            for (String categoryStr: categoryStrList){
                                if(categoryStr != null){
                                    if((category.getNameCategory().toLowerCase().contains(categoryStr.toLowerCase()))){
                                        checCategory = false;
                                    }
                                }
                            }
                        }
                        if(checCategory){
                            productIterator.remove();
                        }


                    }
                }
                display.show("Найденые продукты:");
                display.show(products);
                display.show("Поиск закончен");
            }
        });
    }

//    private List<String> getReadCategories(){
//
////        String category = null;
////        while ((category = display.read()).equals("end")){
////            stringList.add(new String(category));
////            display.show("ещё?");
////        }
//        List<String> stringList = Arrays.asList(display.read().split(","));
//
//        return stringList;
//    }
}
