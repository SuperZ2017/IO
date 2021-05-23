package 缓存流与转换流;

import java.io.*;

public class BufferedInputStreamDemo01 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream("/Users/cpzou/Downloads/Adobe_Premiere_Pro_2021_15.2__macwk.com.dmg"));

        BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream("/Users/cpzou/Desktop/java进阶13天资料/Adobe_Premiere_Pro_2021_15.2__macwk.com.dmg"));

        byte[] bytes = new byte[1024];
        int len;

        // 将读取的内容存入 bytes 数组中，len 是读取的长度
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);  // 写入流中
        }

        System.out.println("take time : " + (System.currentTimeMillis() - startTime) / 1000);

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
