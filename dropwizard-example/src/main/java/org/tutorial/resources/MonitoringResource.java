package org.tutorial.resources;

import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/15/12
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/")
public class MonitoringResource {

    @GET
    @Timed
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello";
    }
}
