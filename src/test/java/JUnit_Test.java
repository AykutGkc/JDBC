import org.junit.Assert;
import org.junit.Test;

import static utilities.DatabaseUtilty.*;


public class JUnit_Test {
    @Test
    public void test01(){
        createConnection();
        //Derya soylu ve ahmet aslan isimli ögrenciler databae de var mi?
        String sql01="select * from ogrenciler";
        System.out.println(getColumnData(sql01, "ogrenci_ismi")); //Ögrenci isimlerini yazddirir.
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu")); //TEst gectikten sonra negatif durum da test edilir.

        // ogrenciler icinde Ahmet Aslan var mi?Yoksa message'i döner
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData(sql01,"Ogrenci_ismi").contains("Ahmet Aslan"));
        closeConnection();
    }

    @Test
    public void test02(){
        createConnection();
        //118 numarali ögrenci database de var mi?
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData("select * from ogrenciler","okul_no").
                contains(118));



        closeConnection();
    }

}
