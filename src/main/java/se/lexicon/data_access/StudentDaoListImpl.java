package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {
    List<Student> students;

    public StudentDaoListImpl() {
        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public void delete(int id) {
        students.remove(this.find(id));
    }
}
