package File;

import java.io.File;
import java.io.IOException;

/**
 * 递归搜索文件
 */
public class FileDemo05 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/cpzou/Desktop/示例文件 3");
        String fileName = "tag_1.csv";
        searchFiles(file, fileName);
    }

    /**
     * 去某个目录下搜索某个文件
     * @param dir
     * @param fileName
     */
    public static void searchFiles(File dir, String fileName) throws IOException {
        // 判断是否存在该路径，是否是文件夹
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    if (f.isFile()) {
                        if (f.getName().equals(fileName)) {
                            // 启动
//                            Runtime runtime = Runtime.getRuntime();
//                            runtime.exec(f.getAbsolutePath());
                            System.out.println(f.getAbsolutePath());
                        }
                    } else {
                        // 是文件夹，递归搜索
                        searchFiles(f, fileName);
                    }
                }
            }
        }
    }
}
