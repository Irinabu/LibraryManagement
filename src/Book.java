public class Book {
    String author;
    String title;
    String category;
    int availableNumber;
    int id;

    public Book(){};

    public Book(String _author, String _title, String _category, int _availableNumber){
        author = _author;
        title = _title;
        category = _category;
        availableNumber = _availableNumber;

    }

    public String toString(){
        return (author + " " + title + " " + category + " " + availableNumber);
    }

}
