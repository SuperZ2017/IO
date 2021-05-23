package 缓存流与转换流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓存字符流：
 *      输入流：可以按行读取 readLine()
 *      输出流：可以新建一行 newLine()
 */
public class BufferedReaderDemo01 {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/main/java/缓存流与转换流/cc.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // 按行读取
//        System.out.println(bufferedReader.readLine());
//        System.out.println(bufferedReader.readLine());
//        System.out.println(bufferedReader.readLine());
//        System.out.println(bufferedReader.readLine());

        // 定义一个字符串变量存储每行数据
        String line;
        // ♻️读取
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

    }
}
