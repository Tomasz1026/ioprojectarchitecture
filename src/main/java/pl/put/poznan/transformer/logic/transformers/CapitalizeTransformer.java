package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

/**
 * Klasa służąca do zamiany pierwszej litery w każdym wyrazie na wielką
 */
public class CapitalizeTransformer extends BaseTransformer {

    /**
     * Konstruktor tworzący obiekt
     *
     * @param transformer Transformator stanowiący kolejną część łańcucha
     *                    transformacji
     */
    public CapitalizeTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Metoda zamieniająca pierwszą literę w każdym wyrazie na wielką
     *
     * @param text typu String, przechowuje tekst mający zostać poddany
     *             transformacji
     * @return zwracany jest przetransformowany tekst
     */
    private String capitalizeText(String text) {

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder(text.length());

        for (String word : words) {
            if (!word.isEmpty()) {
                if(!Character.isLetter(word.charAt(0))) {
                    System.out.println("problem: "+word);
                    result.append(word);
                } else {
                    result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
                }
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
        return capitalizeText(transformer.transform(text));
    }
}
