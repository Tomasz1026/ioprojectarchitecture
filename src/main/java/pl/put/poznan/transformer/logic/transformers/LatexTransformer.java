package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

/**
 * Klasa służąca do zamiany tekstu na format Latex'a
 */
public class LatexTransformer extends BaseTransformer {


    /**
     * Konstruktor tworzący obiekt
     *
     * @param transformer Transformator stanowiący kolejną część łańcucha
     *                    transformacji
     */
    public LatexTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Metoda służąca do zamiany tekstu na format Latex'a
     *
     * @param text typu String, przechowuje tekst mający zostać poddany
     *             transformacji
     * @return zwracany jest przetransformowany tekst
     */
    private String formatLatex(String text) {

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder(text.length());
        String temp;
        char[] specialChars = {'&', '$'};

        for (String word : words) {
            if (!word.isEmpty()) {
                temp = "";
                for (char c : word.toCharArray()) {

                    for (char specialChar : specialChars) {
                        if (c == specialChar) {
                            temp += '\\';
                        }
                    }
                    temp += c;
                }
                result.append(temp);
            }
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
    /**
     * Metoda przekazująca aktualną modyfikację tekstu do transformera
     *
     * @param text typu String, przechowuje tekst mający zostać poddany
     *             transformacji
     * @return zwracany jest przetransformowany tekst
     */
    @Override
    public String transform(String text) {
        return formatLatex(transformer.transform(text));
    }
}
