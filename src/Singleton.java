/**
 * Created by jinglongyang on 11/6/14.
 */
public class Singleton {
    private volatile static Singleton instance;
    private static Object lock = new Object();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
