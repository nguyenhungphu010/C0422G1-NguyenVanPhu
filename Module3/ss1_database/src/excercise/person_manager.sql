use case_study_module_3;
create table vi_tri (
ma_vi_tri int auto_increment,
ten_vi_tri varchar(45),
primary key(ma_vi_tri)
);
create table trinh_do(
ma_trinh_do int, 
ten_trinh_do varchar(45),
primary key(ma_trinh_do)
); 
create table bo_phan(
ma_bo_phan int, 
ten_bo_phan varchar(45),
primary key(ma_bo_phan)
); 
create table loai_khach(
ma_loai_khach int, 
ten_loai_khach varchar(45),
primary key(ma_loai_khach)
); 
create table loai_dich_vu(
ma_loai_dich_vu int, 
ten_loai_dich_vu varchar(45),
primary key(ma_loai_dich_vu)
); 
create table kieu_thue(
ma_kieu_thue int, 
ten_kieu_thue varchar(45),
primary key(ma_kieu_thue)
); 
insert into vi_tri(ten_vi_tri) values("Sales executive"),("Sales Manager"),("Production Manager");