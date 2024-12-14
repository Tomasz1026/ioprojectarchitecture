package pl.put.poznan.transformer.logic;

/**
 * Klasa sluzaca do transformacji tekstu do postaci malych liter
 *
 * 
 */

public class LowerTransformer extends Decorator {
    
     /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     *@param transformer typu TextTransformer
     */
    
    public LowerTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }
    
    /**
     * Metoda transformujaca tekst do postaci malych liter
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String lower(String text)
    {
        return text.toLowerCase();
    }
    
    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera, ktory nastepnie wykona metode lower
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracane jest wywolanie metody lower
     *
     */

    public String transform(String text){
        return lower(transformer.transform(text));
    }
}
