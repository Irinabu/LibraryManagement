import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class DataBase {

    String nameOfTable;
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
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

    public void RemoveLibrarian(String fname, String lname){

        String query = "delete from librarian where firstName = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb", "root", "Irina*Burada*10*");
             PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setString(1, fname);



            stmt.executeUpdate();

            System.out.println("deleted with success");
            System.out.println(listOfLibrarians());

        }
        catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void InsertBook(Book b){

        String query = " insert into book (idbook, title, author, category, count)"
                + " values (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb", "root", "Irina*Burada*10*");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            Random rand = new Random();
            int id = rand.nextInt(1000);

            b.id = id;
            stmt.setInt(1,b.id);
            stmt.setString(2, b.title);
            stmt.setString(3,b.author);
            stmt.setString(4,b.category);
            stmt.setInt(5,b.availableNumber);



            stmt.executeUpdate();

            System.out.println("inserted");
            System.out.println(listOfBooks());
            connection.close();



        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }


}
