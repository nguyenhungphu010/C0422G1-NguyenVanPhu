drop database if exists bai_tap_chuyen_doi_ERD; 
create database bai_tap_chuyen_doi_ERD; 
use bai_tap_chuyen_doi_ERD; 
create table phieu_xuat(
soPX int primary key, 
ngay_xuat date not null
);
create table vat_tu(
ma_vat_tu int primary key,
ten_vat_tu varchar(45) not null
);
create table phieu_nhap(
soPN int primary key, 
ngay_nhap date not null );

create table nha_cung_cap(
ma_ncc int primary key, 
ten_ncc varchar(45) not null, 
dia_chi_ncc varchar(45)
);
create table don_dat_hang(
so_don_hang int primary key, 
ngay_dat_hang date not null,
ma_ncc int, 
foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);
create table so_dien_thoai(
so_dien_thoai int unique, 
ma_ncc int,
foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);
create table xuat_vat_tu (
soPX int, 
ma_vat_tu int,
don_gia_xuat double not null, 
so_luong_xuat int not null,
primary key (soPX,ma_vat_tu), 
foreign key (soPX) references phieu_xuat(soPX),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
); 
create table nhap_vat_tu(
ma_vat_tu int,
soPN int , 
don_gia_nhap double not null, 
so_luong_nhap int not null,
primary key (soPN,ma_vat_tu),
foreign key (soPN) references phieu_nhap(soPN),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
); 
create table dat_hang_vat_tu(
so_don_hang int not null, 
ma_vat_tu int not null,
primary key (so_don_hang,ma_vat_tu), 
foreign key (so_don_hang) references don_dat_hang(so_don_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);


