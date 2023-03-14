import pojos.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query09 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Corum19postgresql");

        Statement st = con.createStatement();

        //Doctor tablosunu olusturun
        //String sql01="create table doctors (id int, isim varchar(30),bolum varchar(20),ucret int)";
        //st.execute(sql01);

        //POJO class kullanarak tabloya veri ekleyelim

        List<Doctor> kayitlar =new ArrayList<>();
        kayitlar.add(new Doctor(20,"Ali Can","Cildiye",500));
        kayitlar.add(new Doctor(21,"sibel bilen","psikiyatri",800));
        kayitlar.add(new Doctor(22,"serhat guler","ruh sagligi",700));
        kayitlar.add(new Doctor(23,"hediye keskin","noroloji",100));
        kayitlar.add(new Doctor(24,"veli han","kbb",400));
        kayitlar.add(new Doctor(25,"ali han","dermotoloji",500));
        kayitlar.add(new Doctor(26,"hakan bal","ortodonti",500));
        kayitlar.add(new Doctor(27,"Ali Can","Cildiye",500));
        kayitlar.add(new Doctor(28,"Ali Can","Cildiye",500));

        PreparedStatement data= con.prepareStatement("insert into doctors values (?,?,?,?)");

        for (Doctor each:kayitlar){
            data.setInt(1,each.getId());
            data.setString(2,each.getIsim());
            data.setString(3, each.getBolum());
            data.setDouble(4,each.getUcret());
            data.addBatch(); //datalari bir araya getirir
        }
        data.executeBatch(); //Bütün verileri gönderir.

        con.close();
        st.close();
        data.close();


    }
}
