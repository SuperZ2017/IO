package 字节流;

import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 字节流做文件复制
 *
 * 字节是计算机中一切文件的组成，所以字节流适合做一切文件的复制，需要前后格式一致
 */
public class CopyDemo01 {

    /**
     * 创建一个字节输入流管道与源文件接通
     * 创建一个字节输出流与目标文件接通
     * 创建一个字节数组作为桶
     * 从字节输入流管道中读取数据，写出到字节输出流管道即可
     * 关闭资源
     */

    public static void main(String[] args) {

        try(FileInputStream is = new FileInputStream("/Users/cpzou/Desktop/20210516-未标题-1.jpg");
            FileOutputStream os = new FileOutputStream("/Users/cpzou/Desktop/参考/45.jpg");)
        {

            byte[] bytes = new byte[1024];  // 1 KB
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            System.out.println("复制完成！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
