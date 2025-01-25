import org.junit.Before;
import org.junit.jupiter.api.*;
import pl.put.poznan.transformer.logic.transformers.*;
import pl.put.poznan.transformer.logic.*;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceTextTransformerTest {
    public InterfaceTextTransformer transformer;

    @BeforeEach
    public void setUp(){
        transformer = new NoTransformer();
    }

    @Test
    public void uppertest(){
        transformer = new UpperTransformer(transformer);
        Assertions.assertEquals("TEST",transformer.transform("test") );
        //Assertions.assertTrue(true);
    }

    @Test
    public void lowertest(){
        transformer = new LowerTransformer(transformer);
        Assertions.assertEquals("test",transformer.transform("TEST"));
    }

    @Test
    public void capitalizetest(){
        transformer = new CapitalizeTransformer(transformer);
        Assertions.assertEquals("Test",transformer.transform("test"));
    }

    @Test
    public void duplicatetest(){
        transformer = new DuplicatesTransformer(transformer);
        Assertions.assertEquals("do ",transformer.transform("do do do"));
    }

    @Test
    public void fullformtest(){
        transformer = new AbbreviationTransformer(transformer, true);
        Assertions.assertEquals("na przykład",transformer.transform("np."));
    }

    @Test
    public void inversetest(){
        transformer = new InverseTransformer(transformer);
        Assertions.assertEquals("tset",transformer.transform("test"));
    }

    @Test
    public void latextest(){
        transformer = new LatexTransformer(transformer);
        Assertions.assertEquals("\\&",transformer.transform("&"));
    }

    @Test
    public void numberstest(){
        transformer = new NumbersToTextTransformer(transformer);
        Assertions.assertEquals("dziesięć",transformer.transform("10"));
    }

    @Test
    public void shorttest(){
        transformer = new AbbreviationTransformer(transformer, false);
        Assertions.assertEquals("prof.",transformer.transform("profesor"));
    }

    @Test
    public void shorttest2(){
        transformer = new AbbreviationTransformer(transformer, false);
        Assertions.assertEquals("np.",transformer.transform("na przykład"));
    }
}
