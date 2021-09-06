package gson;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * class 类型转换 json
 */
public class g2 {

    private static final Gson gson = new Gson();

    class BagOfPrimitives {
        private int value1 = 1;
        private String value2 = "abc";
        private transient int value3 = 3;
        private int value4;
        BagOfPrimitives() {
            // no-args constructor
        }
    }

    @Test
    public void test() {
        BagOfPrimitives bag = new BagOfPrimitives();
        String json = gson.toJson(bag);
        System.out.println(json);
    }
}
