package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class Display {

    private BufferedReader buffer;

    public Display(BufferedReader buffer){
        this.buffer = buffer;
    }

    public void show(Object str) {
        System.out.println(str);
    }

    public void show(List<Object> listStr) {
        for (Object str:listStr) System.out.println(str);
    }

    public String read(){
        try {
            return buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
