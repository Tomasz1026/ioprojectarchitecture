package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

/**
 * Klasa sluzaca do transformacji tekstu do postaci malych liter
 *
 * 
 */

public class LowerTransformer extends BaseTransformer {

    /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     * @param transformer typu TextTransformer
     */

    public LowerTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Metoda transformujaca tekst do postaci malych liter
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String lower(String text) {
        return text.toLowerCase();
    }

    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    public String transform(String text) {
        return lower(transformer.transform(text));
    }
}
