import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        var start = LocalTime.now();

        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream("src/myfile.txt"))){
            int b = is.read();
            while (b != -1){
                System.out.print((char)b);
                b = is.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var end = LocalTime.now();
        System.out.println("\n\n" + Duration.between(start, end).toMillis() + "\n");
        //--------------
        var start2 = LocalTime.now();

        try(FileInputStream fis = new FileInputStream("src/myfile.txt");) {
            int index;
            byte[] data = new byte[8192];
            while((index = fis.read(data)) > -1)
                for (int i = 0; i < index; i++) {
                    System.out.print((char)data[i]);
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var end2 = LocalTime.now();
        System.out.println("\n\n" + Duration.between(start2, end2).toMillis() + "\n");
    }
}