package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa służąca do rozwijania lub skracania skrótów w tekście, w zależności od
 * ustawionej flagi,
 * zachowując oryginalną wielkość liter.
 */
public class AbbreviationTransformer extends BaseTransformer {

    private Map<String, String> abbreviationMap; // Mapa skrótów
    private boolean expand; // Flaga kontrolująca kierunek transformacji

    /**
     * Konstruktor tworzący obiekt
     * 
     * @param transformer Transformator stanowiący kolejną część łańcucha
     *                    transformacji
     * @param expand      Flaga wskazująca, czy rozwijać skróty (true) czy je
     *                    skracać (false)
     */
    public AbbreviationTransformer(InterfaceTextTransformer transformer, boolean expand) {
        super(transformer);
        this.expand = expand;

        abbreviationMap = new LinkedHashMap<>();
        abbreviationMap.put("prof.", "profesor");
        abbreviationMap.put("dr", "doktor");
        abbreviationMap.put("np.", "na przykład");
        abbreviationMap.put("itd.", "i tak dalej");
        abbreviationMap.put("itp.", "i tym podobne");
    }

    /**
     * Metoda rozwijająca lub skracająca skróty, zachowując oryginalną wielkość
     * liter.
     *
     * @param text typu String, przechowuje tekst mający zostać poddany
     *             transformacji
     * @return zwracany jest przetransformowany tekst
     */
    private String transformAbbreviations(String text) {
        // Odwrócenie kolejności mapy - najprostszy sposób
        Map<String, String> transformMap = expand ? abbreviationMap : reverseMap(abbreviationMap);

        for (Map.Entry<String, String> entry : transformMap.entrySet()) {
            String search = entry.getKey();
            String replacement = entry.getValue();

            // Tworzymy wzorzec z granicami słów i ignorowaniem wielkości liter
            Pattern pattern = Pattern.compile(Pattern.quote(search), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            StringBuffer result = new StringBuffer();
            while (matcher.find()) {
                String match = matcher.group();

                // Zachowujemy wielkośc 1 litery
                String adjustedReplacement = Character.isUpperCase(match.charAt(0))
                        ? capitalizeFirstLetter(replacement)
                        : replacement;

                matcher.appendReplacement(result, adjustedReplacement);
            }
            matcher.appendTail(result);
            text = result.toString();
        }

        return text;
    }

    /**
     * Metoda pomocnicza do odwrócenia kluczy i wartości w mapie
     * 
     * @param map Oryginalna mapa
     * @return Odwrócona mapa
     */
    private Map<String, String> reverseMap(Map<String, String> map) {
        Map<String, String> reversedMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }
        return reversedMap;
    }

    /**
     * Metoda pomocnicza do zmiany pierwszej litery w tekście na wielką
     * 
     * @param text Tekst, którego pierwsza litera ma zostać zmieniona
     * @return Tekst z wielką pierwszą literą
     */
    private String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
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
        return transformAbbreviations(transformer.transform(text));
    }
}
