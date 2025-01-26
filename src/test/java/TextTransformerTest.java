import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.TextTransformer;
import org.junit.jupiter.api.*;


public class TextTransformerTest {

    public TextTransformer textTransformer;
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerTest.class);

    @BeforeEach
    public void setUp() throws BadTextTransformationException {
        String [] empty = {};
        textTransformer = new TextTransformer(empty);
    }

    @Test
    public void lowerCapitalizetest() {
        try{
            String[] toTransform ={"lower","capitalize"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("Test",textTransformer.transform("TEST"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void lowerInversetest() {
        try{
            String[] toTransform ={"lower","inverse"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("tset",textTransformer.transform("TEST"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void lowerFullFormtest() {
        try{
            String[] toTransform ={"lower","expand"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("profesor",textTransformer.transform("PROF."));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void numbersUppertest() {
        try{
            String[] toTransform ={"numbersToText","upper"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("DZIESIĘĆ",textTransformer.transform("10"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void fullformUppertest() {
        try{
            String[] toTransform ={"expand","upper"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("PROFESOR",textTransformer.transform("prof."));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void lowerShortformtest() {
        try{
            String[] toTransform ={"lower","abbreviate"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("np.",textTransformer.transform("NA PRZYKŁAD"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void upperLowerCapitalizetest() {
        try{
            String[] toTransform ={"upper","lower","capitalize"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("Test",textTransformer.transform("test"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void upperInversetest() {
        try{
            String[] toTransform ={"upper","inverse"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("TSET",textTransformer.transform("test"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void duplicatesUppertest() {
        try{
            String[] toTransform ={"duplicate","upper"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("DO",textTransformer.transform("do do do"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

    @Test
    public void duplicatesCapitalizetest() {
        try{
            String[] toTransform ={"duplicate","capitalize"};
            textTransformer = new TextTransformer(toTransform);
            Assertions.assertEquals("Do",textTransformer.transform("do do do"));
        } catch (BadTextTransformationException e) {
            logger.debug(e.toString());
        }

    }

}