package io.dinixweb.Springboot.Security.service;

import io.dinixweb.Springboot.Security.model.Students;
import io.dinixweb.Springboot.Security.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final ResultRepository resultRepository;

    @Autowired
    private final ParentRepository parentRepository;

    @Autowired
    private final SubjectRepository subjectRepository;

    @Autowired
    private final SubjectListRepository subjectListRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public GlobalService(StudentRepository studentRepository, ResultRepository resultRepository, ParentRepository parentRepository, SubjectRepository subjectRepository, SubjectListRepository subjectListRepository) {
        this.studentRepository = studentRepository;
        this.resultRepository = resultRepository;
        this.parentRepository = parentRepository;
        this.subjectRepository = subjectRepository;
        this.subjectListRepository = subjectListRepository;
    }

    public List<Students> getALlStudents(){
        return studentRepository.findAll();
    }

    void addNewStudent(Students students){
        studentRepository.save(students);
    }


}
