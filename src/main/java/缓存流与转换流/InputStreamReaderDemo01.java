package 缓存流与转换流;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader
 *      作用：可以解决字符流读取不同编码乱码的问题。
 *           可以把原始的字节流按照当前默认的代码编码转换成字符输入流
 *           也可以把原始的字节流按照指定编码转换成字符输入流
 */
public class InputStreamReaderDemo01 {

    public static void main(String[] args) throws IOException {
        // 提交 GBK 文件的原始字节流
        FileInputStream inputStream = new FileInputStream("src/main/java/缓存流与转换流/cc.txt");

        // 把原始字节输入流通过转换流，转换为 字符输入流 InputStreamReader，默认为 UTF-8，需要指定编码
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");

        // 包装为缓存流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
