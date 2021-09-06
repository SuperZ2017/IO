package gson;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * 基础类型转换json
 */
public class g1 {

    private static final Gson gson = new Gson();

    @Test
    public void serialization() {
        System.out.println(gson.toJson(1));
        System.out.println(gson.toJson("abcd"));
        System.out.println(gson.toJson(new Long(10)));

        int[] values = {1};
        System.out.println(gson.toJson(values));

    }


    @Test
    public void deserialization() {
        int one = gson.fromJson("1", int.class);
        Integer ones = gson.fromJson("1", Integer.class);
        Long oness = gson.fromJson("1", Long.class);
        Boolean is = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);

        System.out.println(one);
        System.out.println(ones);
        System.out.println(oness);
        System.out.println(is);
        System.out.println(str);
        System.out.println(anotherStr);
    }
}
