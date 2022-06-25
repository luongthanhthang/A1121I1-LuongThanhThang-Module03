package model.service;


import model.bean.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(String id);

}
