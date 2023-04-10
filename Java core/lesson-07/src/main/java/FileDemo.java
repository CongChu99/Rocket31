import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt");
        file.createNewFile();
        System.out.println("file.createNewFile() = " + file.createNewFile());
        System.out.println("file.isfile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.isHidden() = " + file.isHidden());
        System.out.println("file.delete() = " + file.delete());
        System.out.println("file.exists() = " + file.exists());

        File folder = new File("abc");
        System.out.println("folder.mkdir() = " + folder.mkdir());
        System.out.println("folder.delete() = " + folder.delete());

        File vti = new File("VTI.Academy");
        for(String name: vti.list()){
            System.out.println("name = " + name);
        }
    }
}
