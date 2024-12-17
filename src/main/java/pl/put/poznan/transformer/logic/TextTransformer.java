package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.transformers.*;

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
                case "numbersToText":
                    transformer = new NumbersToTextTransformer(transformer);
                    break;
                case "capitalize":
                    transformer = new CapitalizeTransformer(transformer);
                    break;
                case "duplicate":
                    transformer = new DuplicatesTransformer(transformer);
                    break;
                case "abbreviate":
                    transformer = new AbbreviationTransformer(transformer, false);
                    break;
                case "expand":
                    transformer = new AbbreviationTransformer(transformer, true);
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
