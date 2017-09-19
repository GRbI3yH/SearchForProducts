package Utils;

import java.io.*;

/**
 * Created by Home-Sweet-Home on 19.09.2017.
 */
public class FileWorker {

    private String nameFile;

    /**
     * @serial ( nameFile.json )
     */
    public FileWorker(String nameFile){
        this.nameFile = nameFile;
    }

    public void writeFile(String str){
        FileWriter file = null;
        try {
            file = new FileWriter( nameFile );
            BufferedWriter buffer = new BufferedWriter( file ) ;
            buffer.write( str ) ;
            buffer.close();
        } catch (IOException e) {
            System.out.println("Не найден файл = "+ nameFile+" " + e);
            return;
        }
    }

    public String readFile(){
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader( new FileReader( nameFile ) );
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл = "+ nameFile+" " + e);
            return null;
        }
        try {
            String str = buffer.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
