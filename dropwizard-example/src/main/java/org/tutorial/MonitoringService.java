package org.tutorial;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import org.tutorial.resources.MonitoringResource;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/15/12
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringService extends Service<MonitoringConfiguration> {

    public static void main(String[] args) throws Exception {
        new MonitoringService("monitoring").run(args);
    }

    protected MonitoringService(String name) {
        super(name);
    }

    @Override
    protected void initialize(MonitoringConfiguration monitoringConfiguration, Environment environment) throws Exception {
        final String id = monitoringConfiguration.getId();
        environment.addResource(new MonitoringResource());
        environment.addHealthCheck(new MonitoringHealthCheck(id));
    }
}
