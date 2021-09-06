package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;

/**
 * 范型对象，序列化和反序列化都需要声明类型
 */
public class g4 {

    private static final Gson gson = new Gson();

    class Foo<T> {
        T value;

        @Override
        public String toString() {
            return "" + value;
        }
    }


    @Test
    public void test() {
        Foo<Integer> foo = new Foo<>();
        foo.value = 2;
        Type type = new TypeToken<Foo<Integer>>() {}.getType();

        String json = gson.toJson(foo, type);
        System.out.println("=== 序列化 ：+ " + json + " ===");

        Object o = gson.fromJson(json, type);
        System.out.println("=== 反序列化 ：+ " + o.toString() + " ===");

    }
}
