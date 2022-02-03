package com.example.webserver.Controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    Logger logger = LoggerFactory.getLogger(ImageController.class);

    //img - returns a 1x1 gif image, and log the request
        @RequestMapping(value = "/img", method = RequestMethod.GET, produces = "image/jpg")
        public @ResponseBody byte[] getGifImage() throws IOException {
            InputStream in = getClass().getResourceAsStream("/static/gifImage1x1.gif");
            // buffer image.
            BufferedImage img = ImageIO.read(in);
            // Create a byte array output stream.
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            // Write to output stream
            ImageIO.write(img, "gif", bao);
            logger.info("GIF image returned " + bao);
            return bao.toByteArray();
    }
}
