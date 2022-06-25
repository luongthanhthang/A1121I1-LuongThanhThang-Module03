package model.service.impl;


import model.bean.Student;
import model.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    IStudentService studentService = new StudentServiceImpl();
    @Override
    public List<Student> findAll() {
//        return null;
        return studentService.findAll();
    }
}
