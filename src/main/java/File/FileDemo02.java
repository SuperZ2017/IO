package File;

import java.io.File;
import java.io.IOException;

/**
 * 演示文件的相对路径(用于寻找工程下的路径)，文件夹
 */
public class FileDemo02 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/File/hello");

        // 文件名称
        System.out.println(file.getName());

        // 文件绝对路径
        System.out.println(file.getAbsolutePath());

        // 文件相对路径，只对使用相对路径创建 file 而言
        System.out.println(file.getPath());

        // 获取文件的大小，字节个数
        System.out.println(file.length());

        // 表示 file 是否是目录
        System.out.println(file.isDirectory());

        // 表示 file 是否是文件
        System.out.println(file.isFile());

        //表示 file 是否存在
        System.out.println(file.exists());

        // 创建文件夹对象：代表文件夹
        File file1 = new File("/Users/cpzou/Desktop/100MSDCF");
        System.out.println(file1.exists());
    }
}
