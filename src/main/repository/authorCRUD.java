package repository;

import entiter.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class authorCRUD implements CrudOperations<Author> {
    private Connection connection;

    public authorCRUD(Connection connection) {
        this.connection = connection;
    }

    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Author\"; ")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Author author = new Author(id, name, sex);
                authors.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

}