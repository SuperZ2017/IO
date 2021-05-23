package File;

import java.io.File;

/**
 * 演示文件的绝对路径
 */
public class FileDemo01 {

    public static void main(String[] args) {
        // 创建文件对象，使用绝对路径
        // 文件路径分隔符：
        //      a.使用 /
        //      b.使用 \ （需要转义）  "\\Users\\cpzou\\Desktop\\20210516-未标题-1.jpg"
        //      c.使用文件分隔符API    "Users" + File.separator + "cpzou" + File.separator + "Desktop" + File.separator + "20210516-未标题-1.jpg"
        File file = new File("/Users/cpzou/Desktop/20210516-未标题-1.jpg");
//        File file = new File("Users\\cpzou\\Desktop\\20210516-未标题-1.jpg");
//        File file = new File("Users" + File.separator + "cpzou" + File.separator + "Desktop" + File.separator + "20210516-未标题-1.jpg");
        System.out.println(file.getName());
        System.out.println(file.length());  // 获取文件大小，字节数
    }
}
