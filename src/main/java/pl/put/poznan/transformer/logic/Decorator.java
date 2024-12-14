package pl.put.poznan.transformer.logic;

public class Decorator implements InterfaceTextTransformer{
    protected InterfaceTextTransformer transformer;

    public Decorator(InterfaceTextTransformer transformer){
        this.transformer = transformer;
    }

    @Override
    public String transform(String text){
        return text;
    }
}
