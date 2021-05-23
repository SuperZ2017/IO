package File;

import java.io.File;
import java.io.IOException;

/**
 * 文件的创建和删除
 */
public class FileDemo03 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/File/world.txt");

        // 创建新文件，不存在则创建，成功返回 true
        System.out.println(file.createNewFile());

        // 删除文件或文件夹，不能删除非空文件夹
        System.out.println(file.delete());

        // 创建一级目录
        File file1 = new File("/Users/cpzou/Desktop/abc");
        System.out.println(file1.mkdir());

        // 创建多级目录
        File file2 = new File("/Users/cpzou/Desktop/abc/def/rty");
        System.out.println(file2.mkdirs());
    }
}
