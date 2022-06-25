package model.repository;


import model.bean.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
