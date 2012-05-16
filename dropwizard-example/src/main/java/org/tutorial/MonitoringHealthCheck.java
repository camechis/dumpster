package org.tutorial;

import com.yammer.metrics.core.HealthCheck;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/15/12
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringHealthCheck extends HealthCheck {

    protected MonitoringHealthCheck(String name) {
        super(name);
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
