package case_study_4.service;

import case_study_4.model.Employee;

public interface IEmployeeService extends IService<Employee> {
    void add();
    void delete ();
    void display();
}
