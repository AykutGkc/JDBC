import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtilty.closeConnection;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Corum19postgresql");

        Statement st=con.createStatement();

        // SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)

        //st.execute("create table urun (id int,isim varchar(10),fiyat int)");

        //Cok miktarda kayit eklemek icin PreparesStatemnt kullanilir.
        // Bunun haricinde pojo class kullanarak da bunu yapabiliriz.

        List<Urun> kayitlar=new ArrayList<>();

        kayitlar.add(new Urun(100,"Laptop",35000));
        kayitlar.add(new Urun(101,"Mause",750));
        kayitlar.add(new Urun(102,"MacBookPro",95000));
        kayitlar.add(new Urun(103,"Ana Kart",5000));
        kayitlar.add(new Urun(104,"Klavye",1500));
        kayitlar.add(new Urun(105,"IPad",45000));

        PreparedStatement tablo=con.prepareStatement("insert into urun values(?,?,?)");

        for(Urun each:kayitlar){
            tablo.setInt(1,each.getId());
            tablo.setString(2,each.getIsim());
            tablo.setDouble(3,each.getFiyat());
            tablo.addBatch();

        }
            tablo.executeBatch();

        closeConnection();




    }
}
