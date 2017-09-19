package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class CommandController {

    private Map<String,ICommand> commandMap;

    public CommandController(){
        commandMap = new HashMap<String,ICommand>();
    }

    public CommandController(Map<String,ICommand> commandMap){
        this.commandMap = commandMap;
    }

    public boolean executeCommand(String nameCommand){
        try {
            commandMap.get(nameCommand).execute();
            return true;
        }catch (NullPointerException e){
            return false;
        }

    }

    public void addCommand(String str, ICommand command) {
        commandMap.put(str,command);
    }

    public List<String> getAllNameCommands(){
        List<String> nameCommands = new ArrayList<String>();
        for (Map.Entry<String, ICommand> commandEntry : commandMap.entrySet()) {
            nameCommands.add(commandEntry.getKey());
        }
        return nameCommands;
    }
}
