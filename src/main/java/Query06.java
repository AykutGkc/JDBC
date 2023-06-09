import java.sql.*;

import static utilities.DatabaseUtilty.closeConnection;

public class Query06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Corum19postgresql");

       // Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values (800,'Ali Can',11,'E')");

        //Ayni SQL kodlarini kullancaksak statement degil PreparedStatement kullaniriz.
        //Statement kullandigimizda her seferin kodu database iletir.
        //PreperedStatemnt kullandigimizda örnegi saklar sadece datalari iletir.

        PreparedStatement ps=con.prepareStatement("insert into ogrenciler values (?,?,?,?)");
        ps.setInt(1,201);
        ps.setString(2,"Ali Can");
        ps.setInt(3,11);
        ps.setString(4,"E");
        ps.executeUpdate();

        ps.setInt(1,127);
        ps.setString(2,"Ali C");
        ps.setInt(3,11);
        ps.setString(4,"E");
        ps.executeUpdate();

        closeConnection();

    }
}
