package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

/**
 * Klasa służąca do odwracania tekstu, zachowując oryginalną wielkość liter.
 */
public class InverseTransformer extends BaseTransformer {

    /**
     * Konstruktor tworzący obiekt
     * 
     * @param transformer Transformator stanowiący kolejną część łańcucha
     *                    transformacji
     */
    public InverseTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Metoda odwracająca tekst, zachowując oryginalną wielkość liter
     *
     * @param text typu String, przechowuje tekst mający zostać poddany
     *             transformacji
     * @return zwracany jest przetransformowany tekst
     */
    private String inverseText(String text) {
        StringBuilder inversedText = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            char reversedChar = text.charAt(text.length() - 1 - i);

            // Zmieniamy wielkość litery na identyczną co na tej samej pozycji w oryginale
            inversedText.append(reversedChar);
        }

        return inversedText.toString();
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
        return inverseText(transformer.transform(text));
    }
}
