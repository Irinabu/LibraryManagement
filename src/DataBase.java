import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    String nameOfTable;
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DataBase(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb", "root", "Irina*Burada*10*");
            statement = connection.createStatement();


        }catch(Exception e){

            System.out.println(e);

        }


    }

    public ArrayList<Librarian> listOfLibrarians() {

    ArrayList<Librarian> librarianArrayList = new ArrayList<>();
    try {

        resultSet = statement.executeQuery("select * from librarian");
        while (resultSet.next()) {
            Librarian a = new Librarian(resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6));
            librarianArrayList.add(a);
        }
        connection.close();


    }catch(Exception e){
        System.out.println(e);

    }

    return librarianArrayList;
}

    public ArrayList<Admin> listOfAdmins() {

        ArrayList<Admin> adminArrayList = new ArrayList<>();
        try {

            resultSet = statement.executeQuery("select * from admin");
            while (resultSet.next()) {

                Admin a = new Admin(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                adminArrayList.add(a);
            }
            connection.close();


        }catch(Exception e){
            System.out.println(e);

        }

        return adminArrayList;
    }

public ArrayList<Book> listOfBooks(){

    ArrayList<Book> bookArrayList = new ArrayList<>();
    try {

        resultSet = statement.executeQuery("select * from book");
        while (resultSet.next()) {
            Book b = new Book(resultSet.getString(3), resultSet.getString(2),resultSet.getString(4), resultSet.getInt(5));
            bookArrayList.add(b);
        }
        connection.close();


    }catch(Exception e){
        System.out.println(e);

    }

    return bookArrayList;

}

}
