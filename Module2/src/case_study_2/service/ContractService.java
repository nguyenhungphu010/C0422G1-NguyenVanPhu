package case_study_2.service.implement;

import case_study_2.service.IService;

public interface ContactService extends IService {
    void createNewContact();
    void displayListContact();
    void editContact();
}
