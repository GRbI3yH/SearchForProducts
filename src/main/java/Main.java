import Controls.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class Main {

    public static void main(String[] args){
        Controller commandController = new Controller();
        String input = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!(input = buffer.readLine()).equals("close")) {
                if(input != null){
                    commandController.executeCommand(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
