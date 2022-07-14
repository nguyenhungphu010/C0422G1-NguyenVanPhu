drop database if exists bai_tap_chuyen_doi_ERD; 
create database bai_tap_chuyen_doi_ERD; 
use bai_tap_chuyen_doi_ERD;
CREATE TABLE phieu_xuat (
    soPX INT PRIMARY KEY,
    ngay_xuat DATE NOT NULL
);
CREATE TABLE vat_tu (
    ma_vat_tu INT PRIMARY KEY,
    ten_vat_tu VARCHAR(45) NOT NULL
);
CREATE TABLE phieu_nhap (
    soPN INT PRIMARY KEY,
    ngay_nhap DATE NOT NULL
);

CREATE TABLE nha_cung_cap (
    ma_ncc INT PRIMARY KEY,
    ten_ncc VARCHAR(45) NOT NULL,
    dia_chi_ncc VARCHAR(45)
);
CREATE TABLE don_dat_hang (
    so_don_hang INT PRIMARY KEY,
    ngay_dat_hang DATE NOT NULL,
    ma_ncc INT,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cung_cap (ma_ncc)
);
CREATE TABLE so_dien_thoai (
    so_dien_thoai INT UNIQUE,
    ma_ncc INT,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cung_cap (ma_ncc)
);
CREATE TABLE xuat_vat_tu (
    soPX INT,
    ma_vat_tu INT,
    don_gia_xuat DOUBLE NOT NULL,
    so_luong_xuat INT NOT NULL,
    PRIMARY KEY (soPX , ma_vat_tu),
    FOREIGN KEY (soPX)
        REFERENCES phieu_xuat (soPX),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
CREATE TABLE nhap_vat_tu (
    ma_vat_tu INT,
    soPN INT,
    don_gia_nhap DOUBLE NOT NULL,
    so_luong_nhap INT NOT NULL,
    PRIMARY KEY (soPN , ma_vat_tu),
    FOREIGN KEY (soPN)
        REFERENCES phieu_nhap (soPN),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
CREATE TABLE dat_hang_vat_tu (
    so_don_hang INT NOT NULL,
    ma_vat_tu INT NOT NULL,
    PRIMARY KEY (so_don_hang , ma_vat_tu),
    FOREIGN KEY (so_don_hang)
        REFERENCES don_dat_hang (so_don_hang),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);


