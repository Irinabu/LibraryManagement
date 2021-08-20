public class Admin extends User{
    int adminId;

    public Admin(int _adminId, String fname, String lname, String _email, String _password){

        adminId = _adminId;
        firstName = fname;
        lastName = lname;
        email = _email;
        password = _password;

    }

    public String toString(){
        return (firstName + " " + lastName + " " );
    }

}
