import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task executed");
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.submit(task);
            System.out.println(i);
        }
        service.shutdown();
    }
}
