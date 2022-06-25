package model.service;


import model.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
