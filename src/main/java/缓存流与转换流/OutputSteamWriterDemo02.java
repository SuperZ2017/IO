package 缓存流与转换流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符输出转换流
 *      作用：可以指定编码，把字节输出流转换成字符输出流
 *           可以指定写出去的字符编码
 */
public class OutputSteamWriterDemo02 {

    public static void main(String[] args) throws IOException {
        // 写一个字节输出流通向文件
        OutputStream os = new FileOutputStream("src/main/java/缓存流与转换流/cc.txt");

        // 把字节输出流转换成字符输出流，默认为 UTF-8，需要指定
        OutputStreamWriter writer = new OutputStreamWriter(os, "GBK");
        writer.write("你好");
        writer.close();
    }
}
