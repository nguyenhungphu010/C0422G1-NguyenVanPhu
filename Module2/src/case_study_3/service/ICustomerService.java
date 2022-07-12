package case_study_3.service;

import case_study_2.models.person.Person;
import case_study_2.service.IService;
import case_study_3.model.Customer;

import java.text.ParseException;

public interface ICustomerService extends IService<Customer> {
    void add() ;
    void display();
    void search () ;
}
