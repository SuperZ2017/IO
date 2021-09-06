package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * 数组、集合序列化
 */
public class g3 {

    private final static Gson gson = new Gson();


    @Test
    public void test1() {
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi"};

        System.out.println(gson.toJson(ints));
        System.out.println(gson.toJson(strings));

        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        Arrays.stream(ints2).forEach(System.out::println);
    }


    @Test
    public void test2() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // 序列化
        String json = gson.toJson(list);
        System.out.println(json);

        // 反序列化，必须指明对象类型
        Type type = new TypeToken<List<Integer>>() {
        }.getType();

        List<Integer> ints2 = gson.fromJson(json, type);

        ints2.stream().forEach(System.out::println);
    }
}
