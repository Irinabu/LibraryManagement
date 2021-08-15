public class Librarian extends User{
    int borrowedBooks;

    public Librarian(String fname, String lname, int books, String _email, String _password) {
        firstName = fname;
        lastName = lname;
        borrowedBooks = books;
        email = _email;
        password = _password;
    }

    public String toString(){
        return (firstName + " " + lastName + " " + borrowedBooks);
    }


}
