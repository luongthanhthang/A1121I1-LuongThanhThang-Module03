package model.repository;


import model.bean.BookBorrowCard;

import java.util.List;

public interface IBookBorrowCardRepository {
    List<BookBorrowCard> findAll();
    List<BookBorrowCard> search(String nameType, Double priceSearch, Integer floorSearch);
    boolean insert(BookBorrowCard bookBorrowCard);
    boolean delete(String id);
    boolean update(BookBorrowCard BookBorrowCard);
    BookBorrowCard findById(String id);
}
