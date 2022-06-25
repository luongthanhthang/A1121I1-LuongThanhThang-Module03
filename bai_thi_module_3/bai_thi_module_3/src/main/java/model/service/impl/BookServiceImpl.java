package model.service.impl;


import model.bean.Book;
import model.repository.IBookRepository;
import model.repository.impl.BookRepositoryImpl;
import model.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id);
    }
}
