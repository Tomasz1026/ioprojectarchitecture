package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

/**
 * Klasa sluzaca do eliminacji duplikatów
 *
 * 
 */

public class DuplicatesTransformer extends BaseTransformer {

    /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     * @param transformer typu TextTransformer
     */

    public DuplicatesTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Metoda transformujaca tekst, aby nie zawierał duplikatów
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String removeDuplicate(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder(text.length());

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty() && i+1 < words.length) {
                if(words[i].equals(words[i+1])) {
                    continue;
                }
            }
            result.append(words[i]);
            result.append(" ");
        }

        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    public String transform(String text) {
        return removeDuplicate(transformer.transform(text));
    }
}
