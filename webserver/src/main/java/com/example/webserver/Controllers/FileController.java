package com.example.webserver.Controllers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping("ping")
    public Response checkFile(){
        //TODO returns response code 200 and string OK when file /tmp/ok is present, if file is not present returns 503 service unavailable

        File file = null;
        try {
            file = new File(
                    getClass()
                            .getClassLoader()
                            .getResource("tmp/ok")
                            .getFile());
        } catch ( NullPointerException e){
            e.getMessage();
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                    .type(MediaType.APPLICATION_JSON_TYPE).build();
        }
        Boolean fileExist = file.exists();
        return Response.ok("OK").build();
    }
}
