package pl.put.poznan.transformer.exceptions;

public class BadTextTransformationException extends Exception{
    public BadTextTransformationException(){}

    public BadTextTransformationException(String message){
        super(message);
    }
}
