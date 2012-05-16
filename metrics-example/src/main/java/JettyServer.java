import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.reporting.AdminServlet;
import com.yammer.metrics.reporting.ConsoleReporter;
import com.yammer.metrics.reporting.MetricsServlet;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ContextHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.mortbay.jetty.handler.ContextHandler.*;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/16/12
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class JettyServer {

    private static final Counter pendingJobs = Metrics.newCounter(MetricsTest.class, "counter");


    public static void main(String[] args) throws Exception {

//        ConsoleReporter.enable(1, SECONDS);

        for (int i=0; i < 10; i++)
            pendingJobs.inc();
        
        Server server = new Server(8080);
        Context root = new Context(server,"/", Context.SESSIONS);
        root.addServlet(new ServletHolder(new AdminServlet()), "/*");
        server.start();
        server.join();
    }
}
