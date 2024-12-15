package pl.put.poznan.transformer.logic;

/**
 * Klasa bazowa transformatora
 * Każdy transformator dziedziczący po tej klasie może modyfikować tekst, a
 * następnie
 * przekazać go do kolejnego transformatora w łańcuchu.
 */
public abstract class BaseTransformer implements InterfaceTextTransformer {
    /**
     * Zmienna przechowująca referencję do następnego transformatora w łańcuchu.
     */
    protected InterfaceTextTransformer transformer;

    /**
     * Konstruktor klasy bazowej transformatora
     *
     * @param transformer Referencja do transformatora, który będzie odpowiedzialny
     *                    za kolejną transformację tekstu.
     */
    public BaseTransformer(InterfaceTextTransformer transformer) {
        this.transformer = transformer;
    }

    /**
     * Abstrakcyjna metoda transformująca tekst
     *
     * @param text Tekst do przetworzenia przez transformator.
     * @return Zwrócony tekst po transformacji.
     */
    @Override
    public abstract String transform(String text);
}
