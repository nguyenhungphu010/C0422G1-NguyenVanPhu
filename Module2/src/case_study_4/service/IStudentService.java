package case_study_4.service;

import case_study_4.model.Student;

public interface IStudentService extends IService<Student>{
    void add ();
    void delete();
    void display();
}
