package 字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 输出乱码问题
 *
 * 一个一个字节数组中文输出也无法避免乱码
 *
 * 1. 使用字符流
 * 2. 定义一个与文件大小相同的字节数组，不现实
 */
public class FileInputStreamDemo03 {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("src/main/java/字节流/world");
    }
}
