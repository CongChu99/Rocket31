import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IOStreamDemo {
    public static void main(String[] args){
        String path = "abc.txt";
        writeFile(path, "Hi Java", true);
        readFile(path);
    }

    public static void readFile(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] buffer = new byte[1024];
            int length = fis.read(buffer);
            String content = "";
            while (length != -1) {
                content += new String(buffer, 0, length);
                length = fis.read(buffer);
            }
            System.out.println("content = " + content);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void writeFile(String path, String message, boolean append){
        try (FileOutputStream fos = new FileOutputStream(path, append)){
            fos.write(message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
