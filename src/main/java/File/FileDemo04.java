package File;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 目录的遍历
 */
public class FileDemo04 {

    public static void main(String[] args) {
        File dir = new File("/Users/cpzou/Desktop");

        // 获取当前目录下全部一级文件名称
        String[] names = dir.list();
        Arrays.stream(names).forEach(System.out::println);

        // 获取当前目录下全部一级文件对象
        File[] files = dir.listFiles();

        // 获取文件最终修改时间
        File file = new File("/Users/cpzou/Desktop/20210516-未标题-1.jpg");
        long timeStamp = file.lastModified();
        System.out.println(timeStamp);
    }
}
