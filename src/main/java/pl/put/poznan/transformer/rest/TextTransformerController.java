package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.rest.dto.TransformationRequest;

import java.util.Arrays;

@RestController
@RequestMapping("/transform")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String transformGET(@ModelAttribute TransformationRequest request) {

        return handleTransformation(request);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String transformPOST(@RequestBody TransformationRequest request) {

        return handleTransformation(request);
    }

    private static String handleTransformation(TransformationRequest request) {
        logger.debug("Text to transform: {}", request.getText());
        logger.debug("Transforms: {}", Arrays.toString(request.getTransforms()));

        try {
            TextTransformer transformer = new TextTransformer(request.getTransforms());
            return transformer.transform(request.getText());
        } catch (BadTextTransformationException e) {
            logger.error("Transformation error: {}", e.getMessage());
            return e.getMessage();
        }
    }
}
