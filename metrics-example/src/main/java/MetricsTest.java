import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/16/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class MetricsTest {

    private final Counter pendingJobs = Metrics.newCounter(MetricsTest.class, "counter");

    public MetricsTest() {
        ConsoleReporter.enable(1, SECONDS);
    }

    public void addJob() {
        pendingJobs.inc();
    }

    public static void main(String[] args) throws InterruptedException{
        MetricsTest m = new MetricsTest();
        m.addJob();

        while (true) {
            TimeUnit.SECONDS.sleep(5);
            m.addJob();
        }
    }
}
