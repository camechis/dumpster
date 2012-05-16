package org.tutorial;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/15/12
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMetrics {
    public static void main(String[] args) {

        final Counter evictions = Metrics.newCounter(PeerMonitoring.class, "main-counter");
        evictions.inc();
        evictions.inc(3);
        evictions.dec();
        evictions.dec(2);

        ConsoleReporter.enable(1, TimeUnit.SECONDS);
    }

    private static class PeerMonitoring {

    }
}
