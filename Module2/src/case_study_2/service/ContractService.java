package case_study_2.service;

import case_study_2.service.IService;

public interface ContractService extends IService {
    void createNewContract();
    void displayListContract();
    void editContract();
}
