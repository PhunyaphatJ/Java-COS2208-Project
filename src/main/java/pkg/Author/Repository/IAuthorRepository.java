package pkg.Author.Repository;


import java.util.ArrayList;
import models.Author;

public interface IAuthorRepository {
    ArrayList<Author> getAll();
    Boolean addAuthor(Author author);
    Author findById(int id);
    Boolean updateAuthor(Author author);
}
