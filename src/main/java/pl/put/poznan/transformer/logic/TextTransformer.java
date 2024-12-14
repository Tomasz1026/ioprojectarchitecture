package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.exceptions.BadTextTransformationException;

public class TextTransformer {

    private InterfaceTextTransformer transformer;

    public TextTransformer(String[] transforms) throws BadTextTransformationException{
        transformer = new NoTransformer();
        for(String transform : transforms){
            switch(transform){
                case "lower":
                    transformer = new LowerTransformer(transformer);
                    break;
                case "nochange":
                    break;
                default:
                    throw new BadTextTransformationException();
            }
        }
    }

    public String transform(String text){
        return transformer.transform(text);
    }
}

