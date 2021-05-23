package 字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流
 */
public class FIleInputStreamDemo01 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/字节流/world");
        
        // 创建一个字节输入流管道与源文件接通
        FileInputStream is = new FileInputStream(file);

        // while 读取，读取完毕返回 -1
        // 一个字节一个字节读，不能读取中文，会乱码，性能差
        int ch = 0;
        while ((ch = is.read()) != -1) {
            System.out.println((char) ch);
        }

        is.close();
    }
}
