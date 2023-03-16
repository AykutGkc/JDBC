import java.sql.Connection;
import java.sql.Statement;

import static utilities.DatabaseUtilty.*;

public class Query08 {
    public static void main(String[] args) {

        createConnection();

        String sql01="select * from ogrenciler";
       System.out.println("Sütun isimleri "+getColumnNames(sql01));

        System.out.println("Okul No: "+getColumnData(sql01,"okul_no"));
        System.out.println("Ögrenci ismi: "+getColumnData(sql01,"ogrenci_ismi"));
        System.out.println("Sinif: "+getColumnData(sql01,"sinif"));

        closeConnection();


    }
}
