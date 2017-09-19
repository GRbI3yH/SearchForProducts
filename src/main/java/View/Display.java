package View;

import java.util.List;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class Display {

    public void show(String str) {
        System.out.println(str);
    }

    public void show(List<String> listStr) {
        for (String str:listStr) System.out.println(str);
    }

}
