package 字符流;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符流读取，不会乱码，适合读取文本内容
 */
public class FileReaderDemo01 {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/main/java/字符流/world");

        // 按照字符读取，每次读取一个字符的编号返回（一个编号代表一个字符）
//        int code = reader.read();
//        System.out.println((char) code);

        // ♻️读取
//        while (reader.read() != -1) {
//            int read = reader.read();
//            System.out.println((char) read);
//        }

        // 使用字符数组读取
        char[] buffer = new char[1024];
        int len;
        while ((len = reader.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, len));
        }

        reader.close();
    }
}
