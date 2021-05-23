package 字符流;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo02 {

    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("src/main/java/字符流/world");

        // 写一个字符出去
        writer.write(97);   // 字符 a
        writer.write('a');  // 字符 b
        writer.write("\n武功山");

        writer.flush();
    }
}
