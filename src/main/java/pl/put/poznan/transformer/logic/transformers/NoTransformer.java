package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

public class NoTransformer implements InterfaceTextTransformer {

    // public NoTransformer(){}
    @Override
    public String transform(String text) {
        return text;
    }
}
