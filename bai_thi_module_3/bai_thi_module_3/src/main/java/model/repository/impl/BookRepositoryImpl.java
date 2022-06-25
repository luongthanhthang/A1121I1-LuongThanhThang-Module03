package model.repository.impl;

import model.bean.Book;
import model.bean.BookBorrowCard;
import model.repository.BaseRepository;
import model.repository.IBookRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private static final String SELECT_BY_ID = "select * from book where book_id = ?";

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from book;");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bookId = resultSet.getString("book_id");
                String bookName = resultSet.getString("book_name");
                String author = resultSet.getString("book_author");
                String describe = resultSet.getString("book_describe");
                Integer quantity = resultSet.getInt("book_quantity");
                bookList.add(new Book(bookId, bookName, author, describe, quantity));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book findById(String id) {
        Book book = null;
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {

            preparedStatement.setString(1, id);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String bookId = resultSet.getString("book_id");
                String name = resultSet.getString("book_name");
                String author = resultSet.getString("book_author");
                String describe = resultSet.getString("book_describe");
                Integer quantity = resultSet.getInt("book_quantity");
                book = new Book(bookId, name, author, describe, quantity);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }
}