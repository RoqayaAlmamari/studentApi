package com.example.studentApi.Service;

import com.example.studentApi.Model.Student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private Long nextId = 1L;

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudentById(Long id) {
        return students.get(id);
    }

    public Student createStudent(Student student) {
        student.setId(nextId);
        students.put(nextId, student);
        nextId++;
        return student;
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = students.get(id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            students.put(id, existingStudent);
            return existingStudent;
        } else {
            return null;
        }
    }

    public void deleteStudent(Long id) {
        students.remove(id);
    }
    public List<Student> searchStudents(String name) {
        List<Student> searchResults = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(student);
            }
        }
        return searchResults;
    }



}
