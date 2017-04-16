import java.sql.DriverManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2016/3/6.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        return 0;
    }

    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 1;
        }
    };
}
