package 字节流;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流，默认为 覆盖
 */
public class FileOutputStreamDemo01 {

    public static void main(String[] args) throws IOException {
        // 写数据到文件，文件会自动创建
        File file = new File("src/main/java/字节流/cc.txt");

        // 创建一个字节输出流管道与目标文件对象接通, 参数 true 表示追加文件
        FileOutputStream os = new FileOutputStream(file, true);

        // 写一个字节出去
        os.write(97);    // 字节 a
        os.write('a');   // 字节 b
        os.write('你');  // 只会写出中文的第一个字节，会乱码

        // 写一个字节数组
        byte[] bytes = {48, 49, 50};
        os.write(bytes);

        byte[] bytes1 = "\r\n你好，武功山".getBytes();
        os.write(bytes1);

        os.flush(); // 立即刷新数据到文件中去，刷新后管道可以继续使用
        os.close(); // 关闭管道，包含了刷新

    }
}
