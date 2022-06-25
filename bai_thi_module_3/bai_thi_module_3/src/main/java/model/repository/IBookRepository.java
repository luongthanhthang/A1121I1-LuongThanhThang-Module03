package model.repository;


import model.bean.Book;
import model.bean.BookBorrowCard;

import java.util.List;

public interface IBookRepository {
    List<Book> findAll();
    Book findById(String id);
}
