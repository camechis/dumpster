package org.tutorial;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/15/12
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
