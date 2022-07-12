package case_study_2.service;

import case_study_2.models.facility.Facility;

public interface IFacilityService extends IService<Facility> {
    // thêm mới cơ sở hạ tầng để trả về danh sách để chọn dịch vụ mong muốn.
    void add (Facility facility);
    void addNewRoomService ();
    void addNewVillaService();
    void addNewHouseService();
    // method kiểm tra bảo trì của cơ sở hạ tầng
    void maintenanceCheck(Facility facility);
    // method thể hiện các cơ sở hạ tầng cần bảo trì.
    void displayMaintenance();
    // method thể hiện số lần đã sử dụng dịch vụ của cơ sở hạ tầng.
    void displayNumberUsedOfService();

}
