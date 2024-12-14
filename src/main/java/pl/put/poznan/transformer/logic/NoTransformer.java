package pl.put.poznan.transformer.logic;

public class NoTransformer  implements InterfaceTextTransformer{

    //public NoTransformer(){}
    @Override
    public String transform(String text) {
        return text;
    }
}
