package pl.put.poznan.transformer.logic.transformers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.InterfaceTextTransformer;

/**
 * Klasa służąca do transformacji liczb na tekst
 */
public class NumbersToTextTransformer extends BaseTransformer {

    /**
     * Konstruktor tworzący obiekt dekorujący podany TextTransformer
     *
     * @param transformer typu InterfaceTextTransformer
     */
    public NumbersToTextTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Metoda zamieniająca liczby w tekście na ich odpowiedniki tekstowe
     *
     * @param text typu String przechowuje tekst mający zostać poddany transformacji
     * @return zwracany jest tekst z zamienionymi liczbami
     */
    private String replaceNumbersWithText(String text) {
        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d{1,2})?\\b");
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String numberStr = matcher.group();
            String replacement = numberStr.contains(".") ? convertDecimalToWords(numberStr)
                    : convertIntegerToWords(Integer.parseInt(numberStr));

            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * Metoda zamieniająca liczbę całkowitą na jej tekstowy odpowiednik
     *
     * @param number liczba całkowita do przekształcenia
     * @return tekstowy odpowiednik liczby
     */
    private String convertIntegerToWords(int number) {
        if (number == 0)
            return "zero";
        if (number > 1000)
            // Nie obsługujemy liczb > 1000
            return Integer.toString(number);

        String[] jednosci = { "", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć" };
        String[] nastki = { "", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście",
                "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście" };
        String[] dziesiatki = { "", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt",
                "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt" };
        String[] setki = { "", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset",
                "siedemset", "osiemset", "dziewięćset" };

        StringBuilder result = new StringBuilder();

        result.append(setki[number / 100]).append(" ");

        int dziesiatkiJednosci = number % 100;
        if (dziesiatkiJednosci > 10 && dziesiatkiJednosci < 20) {
            result.append(nastki[dziesiatkiJednosci - 10]).append(" ");
        } else {
            result.append(dziesiatki[dziesiatkiJednosci / 10]).append(" ");
            result.append(jednosci[dziesiatkiJednosci % 10]).append(" ");
        }

        return result.toString().trim();
    }

    /**
     * Metoda zamieniająca liczbę zmiennoprzecinkową na tekstowy odpowiednik
     *
     * @param numberStr liczba zmiennoprzecinkowa jako String
     * @return tekstowy odpowiednik liczby
     */
    private String convertDecimalToWords(String numberStr) {
        String[] parts = numberStr.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);
        int fractionalPart = Integer.parseInt(parts[1]);

        String integerWords = convertIntegerToWords(integerPart);
        String fractionalWords = convertIntegerToWords(fractionalPart);

        return integerWords + " i " + fractionalWords + " setnych";
    }

    /**
     * Metoda przekazująca aktualną modyfikację tekstu do transformera
     *
     * @param text typu String przechowuje tekst mający zostać poddany transformacji
     * @return zwracany jest przetransformowany tekst
     */
    @Override
    public String transform(String text) {
        return replaceNumbersWithText(transformer.transform(text));
    }
}
