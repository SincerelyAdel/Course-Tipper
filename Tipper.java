import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tipper {
    public static void main(String[] args) {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + "/hotkeys.ahk";

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        
            writer.write("^!n::");
            writer.newLine();

            for (int i = 0; i < args.length; i++) {
                writer.write("SendRaw " + args[i]);
                writer.newLine();
                writer.write("Sleep 50 ; Add a 50-millisecond delay");
                writer.newLine();
                writer.write("SendInput {Tab}");
                writer.newLine();
                writer.write("Sleep 50 ; Add a 50-millisecond delay");
                writer.newLine();
            }

            writer.write("return");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}