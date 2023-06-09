import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static utilities.DatabaseUtilty.closeConnection;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Corum19postgresql");

        Statement st = con.createStatement();

        //SORU: Öğrenciler tablosuna yeni bir kayıt ekleyin (300, 'Sena Can', 12, 'K')

        //int s1=st.executeUpdate("insert into ogrenciler values(313, 'Sena Can', 12, 'K')");
        //System.out.println(s1+ " satir database eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

        String [] veri= {"insert into ogrenciler values (900, 'Sena Can', 12, 'K')",
                         "insert into ogrenciler values (901, 'Sena Can', 12, 'K')",
                         "insert into ogrenciler values (902, 'Sena Can', 12, 'K')"};

        //1.Yol
 /*       int count=0;
        for (String each:veri){
            count=count+st.executeUpdate(each);
        }
        System.out.println(count+" satir database eklendi");


        //2.Yol
 /*       String [] veri= {"insert into ogrenciler values (700, 'Sena Can', 12, 'K')",
                       "insert into ogrenciler values (701, 'Sena Can', 12, 'K')",
                       "insert into ogrenciler values (702, 'Sena Can', 12, 'K')"};

        for(String each:veri){
            st.addBatch(each); //Yukaridaki datalarin hepsini birlestirir.
        }
        st.executeBatch(); //Birlestirdigi datalari tek seferde gönderir.

  */

        String sql05="Update ogrenciler set okul_no=705 where okul_no=702";
        int a=st.executeUpdate(sql05);
        System.out.println(a);

        closeConnection();

    }
}
