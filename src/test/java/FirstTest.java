import org.junit.Assert;
import org.junit.Test;

public class FirstTest {
    @Test
    public void firstTest01(){

        Assert.assertTrue(4<5);



    }

    @Test
    public void firstTest02(){

        Assert.assertTrue("Test Fail",3<4); //Test kaldiginda mesaj aliriz.-->Test Fail.

    }

    @Test
    public void firstTest03(){

        Assert.assertEquals("Sayilar esit degil","3","3");


    }

}
