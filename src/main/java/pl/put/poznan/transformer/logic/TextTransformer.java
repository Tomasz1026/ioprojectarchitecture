package pl.put.poznan.transformer.logic;

/**
 * Klasa sluzaca do transformacji tekstu
 *
 *
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        /**
         *
         * of course, normally it would do something based on the transforms
         * @return cos
          */
        return text.toUpperCase();
    }
}
