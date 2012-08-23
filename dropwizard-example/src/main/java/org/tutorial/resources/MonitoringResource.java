package org.tutorial.resources;

import com.yammer.metrics.annotation.Timed;

import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.sun.jersey.multipart.FormDataParam;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.*;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/15/12
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/")
public class MonitoringResource {

    public static final String UPLOAD_DIR = "/tmp";

    @GET
    @Timed
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello";
    }

    @POST
    @Produces(TEXT_PLAIN)
    @Consumes(MULTIPART_FORM_DATA)
    public String uploadFile(@FormDataParam("file") final InputStream stream) throws Exception {


        String tempname = UUID.randomUUID().toString();
        final String outputPath = UPLOAD_DIR + File.separator + tempname;
        Files.copy(new InputSupplier<InputStream>() {
            @Override
            public InputStream getInput() throws IOException {
                return stream;                
            }
        }, new File(outputPath));

        return tempname;
    }
}
