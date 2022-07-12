package case_study_2.service;

import case_study_2.models.person.Person;

import java.text.ParseException;

public interface IPersonService extends IService<Person>{
    void add() throws ParseException;
    void display();
    void edit () throws ParseException;
}
