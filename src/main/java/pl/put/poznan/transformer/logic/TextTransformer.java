package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.transformers.LowerTransformer;
import pl.put.poznan.transformer.logic.transformers.NoTransformer;
import pl.put.poznan.transformer.logic.transformers.InverseTransformer;
import pl.put.poznan.transformer.logic.transformers.UpperTransformer;

public class TextTransformer {

    private InterfaceTextTransformer transformer;

    public TextTransformer(String[] transforms) throws BadTextTransformationException {
        transformer = new NoTransformer();
        for (String transform : transforms) {
            switch (transform) {
                case "lower":
                    transformer = new LowerTransformer(transformer);
                    break;
                case "upper":
                    transformer = new UpperTransformer(transformer);
                    break;
                case "inverse":
                    transformer = new InverseTransformer(transformer);
                    break;
                case "nochange":
                    break;
                default:
                    throw new BadTextTransformationException();
            }
        }
    }

    public String transform(String text) {
        return transformer.transform(text);
    }
}
