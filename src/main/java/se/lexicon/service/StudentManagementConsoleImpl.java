package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {
    private final UserInputService scannerService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        return new Student(scannerService.getInt(), scannerService.getString());
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student removeStudent = studentDao.find(id);
        studentDao.delete(id);
        return removeStudent;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        Student updateStudent = studentDao.find(student.getId());
        updateStudent.setName(student.getName());
        return studentDao.save(updateStudent);
    }
}
