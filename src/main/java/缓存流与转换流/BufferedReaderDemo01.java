package 缓存流与转换流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 缓存字符流：
 *      输入流：可以按行读取 readLine()
 *      输出流：可以新建一行 newLine()
 */
public class BufferedReaderDemo01 {

    /**
     * a ~ z : 97 - 122
     * A ~ Z : 65 - 90
     * 空格 : 32
     */



    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/main/java/缓存流与转换流/cc.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // 定义一个字符串变量存储每行数据
        String line;
        // ♻️读取
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(dealTxt(line).trim());
        }
    }

    // step 1 : 找到所有单词起始位置
    // step 2 : 封装到 List<[]> 中
    private static String dealTxt(String line) {
        if (line == null) {
            return "";
        }

        char[] chars = line.toCharArray();
        List<int[]> pos = new ArrayList<>();

        for (int i = 0, j = 0; i < chars.length;) {
            char c = chars[i];

            // i 作为开始，j 作为结束
            if (isEnglish(c)) {
                if (i + 1 == chars.length) {
                    pos.add(new int[] {i, i});
                } else {
                    for (j = i + 1; j < chars.length; j++) {
                        char v = chars[j];
                        if (v != ' ' && !isEnglish(v) && !isChinesePunctuation(v) && !isNumber(v) && !isNeed(v)) {
                            pos.add(new int[] {i, j});
                            break;
                        }
                    }
                }
            }

            // 处理： 图3-7 --> 图 3 -> 7
            if (isNumber(c)) {
                if (i + 1 == chars.length) {
                    pos.add(new int[] {i, i});
                } else {
                    for (j = i + 1; j < chars.length; j++) {
                        char v = chars[j];
                        if (v != '-' && !isNumber(v) && !isNeed(v)) {
                            pos.add(new int[] {i, j});
                            break;
                        }
                    }
                }
            }

            if (j != 0 && j >= i) {
                i = j + 1;
            } else {
                ++i;
            }
        }
        StringBuilder sb = new StringBuilder(line);

        int p = 0;
        for (int[] cs : pos) {
            sb.insert(cs[0] + (p++), ' ');
            char c = sb.substring(cs[1] + p - 1).charAt(0);
            if (!isChinesePunctuation(c)) {
                sb.insert(cs[1] + (p++), ' ');
            }
        }

        char[] chars1 = sb.toString().toCharArray();

        List<Integer> space = new ArrayList<>();
        for (int i = 0; i < chars1.length - 1; i++) {
            char c = chars1[i];
            char b = chars1[i + 1];
            if ((c == '，' || c == '。' || c == ' ' || c == '；' || c == '：') && b == ' ') {
                space.add(i + 1);
            }
        }

        int k = 0;
        for (int s : space) {
            sb.delete(s - k, s + 1 - k);
            ++k;
        }

        return sb.toString().replace('（', '(').replace('）', ')');
    }

    private static boolean isEnglish(char c) {
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
            return true;
        }
        return false;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isNeed(char c) {
        char[] chars = {'-', '_', '/', '.', '（', '）'};
        for (char c1 : chars) {
            if (c1 == c) {
                return true;
            }
        }
        return false;
    }


    //使用UnicodeScript方法判断 中文
    private static boolean isChineseByScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }

    // 根据UnicodeBlock方法判断中文标点符号
    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION                        // 百分号，千分号，单引号，双引号等
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION         // 顿号，句号，书名号，〸，〹，〺 等；PS: 后面三个字符你知道什么意思吗？
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS       // 大于，小于，等于，括号，感叹号，加，减，冒号，分号等等
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS             // 主要是给竖写方式使用的括号，以及间断线﹉，波浪线﹌
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {                   // 主要是一些竖着写的标点符号
            return true;
        } else {
            return false;
        }
    }


}
