import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    String nameOfTable;

public ArrayList<Librarian> listOfLibrarians() {

    ArrayList<Librarian> librarianArrayList = new ArrayList<>();
    try {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb", "root", "Irina*Burada*10*");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from librarian");

        while (rs.next()) {
            Librarian a = new Librarian(rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6));
            librarianArrayList.add(a);
        }
        con.close();


    }catch(Exception e){
        System.out.println(e);

    }

    return librarianArrayList;
}

}
