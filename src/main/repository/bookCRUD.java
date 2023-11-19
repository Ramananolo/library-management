package repository;

import entiter.book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bookCRUD implements CrudOperations<Book> {
    private Connection connection;

    public bookCRUD(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Books\";")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int pageNumber = resultSet.getInt("pageNumber");
                Date releaseDate = resultSet.getDate("releaseDate");
                int idAuthor = resultSet.getInt("idAuthor");
                Book.Topic topicValue = Book.Topic.valueOf(resultSet.getString("topic"));
                String status = resultSet.getString("status");
                Book book = new Book(id, name, pageNumber, releaseDate, idAuthor,topicValue, status);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
