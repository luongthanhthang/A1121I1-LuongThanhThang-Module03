package model.service.impl;


import model.bean.BookBorrowCard;
import model.repository.IBookBorrowCardRepository;
import model.repository.impl.BookBorrowCardRepositoryImpl;
import model.service.IBookBorrowCardService;

import java.util.List;

public class BookBorrowCardServiceImpl implements IBookBorrowCardService {
    IBookBorrowCardRepository borrowCardRepository = new BookBorrowCardRepositoryImpl();

    @Override
    public List<BookBorrowCard> findAll() {
        return null;
//        return borrowCardRepository.findAll();
    }

    @Override
    public List<BookBorrowCard> search(String nameType, Double priceSearch, Integer floorSearch) {
        return null;
    }

    @Override
    public boolean insert(BookBorrowCard bookBorrowCard) {
        return borrowCardRepository.insert(bookBorrowCard);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(BookBorrowCard BookBorrowCard) {
        return false;
    }

    @Override
    public BookBorrowCard findById(String id) {
        return null;
    }
}
