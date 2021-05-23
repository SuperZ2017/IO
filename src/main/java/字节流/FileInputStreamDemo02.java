package 字节流;


import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo02 {

    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("src/main/java/字节流/world");

        // 定义一个字节数组读取数据
        byte[] bytes = new byte[3];

//        // 从is管道中读取字节装入到字节数组中，返回读取字节的数量
//        int len = is.read(bytes, 0, 3);
//
//        System.out.println(len);
//        System.out.println(new String(bytes));


        // 循环读取
        int len;    // 存储每次读取的字节数
        while ((len = is.read(bytes)) != -1) {
            // 读取了多少就倒出来多少
            String string = new String(bytes, 0, len);
            System.out.println(string);
        }
    }
}
