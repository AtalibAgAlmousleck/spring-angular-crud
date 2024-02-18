package com.atalibdev.student;

import java.util.List;

public interface StudentService {
    Student register(Student student);
    List<Student> fetch();
    void deleteUser(Long userId);
    Student update(Long studentId, Student updateStudent);
}
