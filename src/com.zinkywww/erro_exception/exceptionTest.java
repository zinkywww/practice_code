package erro_exception;

import java.io.File;
import java.io.FileNotFoundException;

public class exceptionTest {
    public static void checkFile(String path) throws FileNotFoundException {
        File file = new File(path);
        if(!file.exists()){
            throw new FileNotFoundException(path);
        }
    }
    public static void main(String[] args) {
        String path = "1.txt";
        try{
            checkFile(path);
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }
}
