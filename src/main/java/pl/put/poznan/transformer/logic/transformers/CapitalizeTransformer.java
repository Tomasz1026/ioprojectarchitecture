package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

public class CapitalizeTransformer extends BaseTransformer {

    public CapitalizeTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    private String capitalizeText(String text) {



        return text;
    }


    @Override
    public String transform(String text) {
        return capitalizeText(transformer.transform(text));
    }
}
