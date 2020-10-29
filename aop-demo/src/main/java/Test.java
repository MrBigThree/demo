import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/19
 */
public class Test {

    public void test(String name, String age)
    {
        System.out.println(name);

        AtomicInteger integer = new AtomicInteger(1);
        integer.addAndGet(1);
    }

}
