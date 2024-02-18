package com.atalibdev.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student register(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetch() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteUser(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student update(Long studentId, Student updateStudent) {
        Student existingStudent =
                studentRepository.findById(studentId)
                        .orElseThrow(() -> new RuntimeException("User not found with id " + studentId));
        existingStudent.setName(updateStudent.getName());
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setMajor(updateStudent.getMajor());
        return studentRepository.save(existingStudent);
    }
}
