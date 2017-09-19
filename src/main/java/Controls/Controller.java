package Controls;

import Models.CommandController;
import Models.ICommand;
import Models.Product;
import View.Display;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class Controller {

    public Controller(){
        products = dataProvider.getProducts();
        intCommand();
    }

    private Display display = new Display();
    private CommandController commandController = new CommandController();
    private DataProvider dataProvider = new DataProvider();
    private List<Product> products;

    public void executeCommand(String nameCommand){
        commandController.executeCommand(nameCommand);
    }

    private void intCommand() {
        commandController.addCommand("help", new ICommand() {
            @Override
            public void execute() {
                display.show(commandController.getAllNameCommands());
            }
        });
    }
}
