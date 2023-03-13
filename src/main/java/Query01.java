import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1-)Driver Tanimla
        Class.forName("org.postgresql.Driver");

        //2-)Database'e baglan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Corum19postgresql");

        //3-)statement
        Statement st = con.createStatement();
        System.out.println("Connect Success");

        //4-)ResultSet
        ResultSet veri=st.executeQuery("select * from ogrenciler");
        //5-)DAtalari al
        while(veri.next()){
            System.out.println(veri.getInt(1) +" "
            +veri.getString(2) + " "
            +veri.getString(3) + " "
            +veri.getString(4));
        }

        //Baglantilari kapatma
        con.close();
        st.close();
        veri.close();


    }
}