import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.DatabaseUtilty.*;

public class TestNG_Test {

@Test
    public void test01(){
   createConnection();
    String sql01="select * from ogrenciler";
    Assert.assertTrue(getColumnData(sql01,"ogrenci_ismi").contains("Derya Soylu"),
            "DATABASE'DE KAYIT BULUNAMADI");

    


    closeConnection();
}

@Test
    public void test02(){
    createConnection();

    Assert.assertTrue(getColumnData("select * from ogrenciler","OKUL_no").contains(120),
            "DATABASE'DE KAYIT BULUNAMADI");


    closeConnection();
}


}
