package case_study_3.service;

import case_study_3.model.ElectricalBill;

public interface IBillService extends IService<ElectricalBill>{
    void add ();
    void edit();
    void display();
}
