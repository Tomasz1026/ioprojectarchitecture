package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

/**
 * Klasa służąca do transformacji tekstu do postaci wielkich liter
 */
public class UpperTransformer extends BaseTransformer {

    /**
     * Konstruktor tworzacy obiekt
     * 
     * @param transformer Transformator stanowiący kolejną część łańcucha
     *                    transformacji
     */
    public UpperTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Metoda transformujaca tekst do postaci wielkich liter
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */
    private String upper(String text) {
        return text.toUpperCase();
    }

    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */
    public String transform(String text) {
        return upper(transformer.transform(text));
    }
}
