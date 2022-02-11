package dev.projectlion.demo.week3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleRestController.class);

    @GetMapping("/samplePayload")
    public SamplePayload samplePayloadGet(){
        return new SamplePayload("kimdyoung", 33, "Develoeop");
    }

    @PostMapping("/samplePayload")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload){
        logger.info(samplePayload.toString());
    }

    @PostMapping(value = "/sampleMultipart" ,produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sampleMultipartPost(
            @RequestParam("occupation") MultipartFile multipartFile,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation
    ){
        logger.info("name" + name);
        logger.info("age" + age);
        logger.info("occupation" + occupation);
        logger.info("occupation" + multipartFile.getOriginalFilename());
    }

    @GetMapping(value = "/sampleImage" ,produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] sampleImage() throws IOException{
        InputStream inputStream = getClass().getResourceAsStream("/static/spring.png");

        return inputStream.readAllBytes();
    }
}
