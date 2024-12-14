package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.TextTransformer;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Arrays;


@RestController
@RequestMapping("/transform")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String transform(
                      @RequestParam(value="transforms", defaultValue="nochange") String[] transforms,
                      @RequestParam(value="text", defaultValue="test text") String text ) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));


        // perform the transformation, you should run your logic here, below is just a silly example
        try {
            TextTransformer transformer = new TextTransformer(transforms);
            return transformer.transform(text);
        } catch(BadTextTransformationException e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(
                      @RequestBody String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        try {
            TextTransformer transformer = new TextTransformer(transforms);
            return transformer.transform(text);
        } catch(BadTextTransformationException e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }



}


