use case_study_module_3; 
-- task 2 : 
select * from nhan_vien 
where ho_va_ten like "H%" or ho_va_ten like "K%" or ho_va_ten like "T%" and length(ho_va_ten) <15 ;
-- task 3: 
select kh.*, TIMESTAMPDIFF(year,kh.ngay_sinh,curdate()) AS age from khach_hang kh
where (kh.dia_chi like "%Đà Nẵng%" or kh.dia_chi like "%Quảng Trị%")
having age > 18 and age <50;
-- task 4: đếm số lần đặt phòng của khách hàng diamond 
select * from hop_dong 
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
join dich_vu  on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where loai_khach.ma_loai_khach =1 ;
-- task 4
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong from khach_hang
	join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
	where (ma_loai_khach = (select ma_loai_khach from loai_khach where ten_loai_khach ="Diamond") )
	group by hop_dong.ma_khach_hang
order by so_lan_dat_phong;
-- task 5; 
select kh.ma_khach_hang, kh.ho_ten,loai_khach.ten_loai_khach,hop_dong.ma_hop_dong, dich_vu.ten_dich_vu,
hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc, 
ifnull(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia ,0) + dich_vu.chi_phi_thue as tong_tien,
dich_vu.chi_phi_thue
from khach_hang kh
	join loai_khach on loai_khach.ma_loai_khach = loai_khach.ma_loai_khach
	join hop_dong on hop_dong.ma_khach_hang = kh.ma_khach_hang 
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
	join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
	join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
	group by ma_hop_dong, ma_khach_hang
order by ma_hop_dong;
-- task 6: chưa thể hiện đc các loại dịch vụ chưa từng được thuê trong quý 1. 
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, loai_dich_vu.ten_loai_dich_vu
 from dich_vu
	join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
	join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
    where dich_vu.ma_dich_vu not in (
    select dich_vu.ma_dich_vu
    from dich_vu
	join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
	join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
	where (hop_dong.ngay_lam_hop_dong between "2020-12-31" and "2021-03-31" )
    group by ten_dich_vu)
     group by ten_loai_dich_vu
;

-- loai dich vu duoc dat trong 2020 
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu dv 
    join hop_dong on hop_dong.ma_dich_vu = dv.ma_dich_vu
	join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dv.ma_loai_dich_vu
    where hop_dong.ngay_lam_hop_dong  between "2020-01-01" and "2020-12-31" 
    group by ma_dich_vu; 
    
-- loai dich vu duoc dat trong 2021 
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu dv 
    join hop_dong on hop_dong.ma_dich_vu = dv.ma_dich_vu
	join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dv.ma_loai_dich_vu
    where hop_dong.ngay_lam_hop_dong  between "2021-01-01" and "2021-12-31" 
    group by ma_dich_vu; 
    
-- task 7 : loai dich vu duoc dat trong 2020 chưa từng được đặt trong 2021
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu  
    join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
	join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
    where hop_dong.ngay_lam_hop_dong  between "2020-01-01" and "2020-12-31"  and dich_vu.ma_dich_vu 
    not in (select dich_vu.ma_dich_vu from dich_vu 
    join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
	join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
    where hop_dong.ngay_lam_hop_dong  between "2021-01-01" and "2021-12-31" 
    group by ma_dich_vu )
    group by ma_dich_vu; 

-- task 8 :  tim cac khach hang có ho_ten khong trung nhau/ dung 3 cach 
-- cach 1 : 
select khach_hang.ho_ten, count(*) from khach_hang
group by ho_ten
having count(*) = 1; 
-- cach 2: 
select kh1.ho_ten from khach_hang kh1
join khach_hang kh2 on kh1.ma_khach_hang = kh2.ma_khach_hang
where kh1.ho_ten = kh2.ho_ten
group by ho_ten
having count(*) =1 ; 
--  cach 3: chưa hiểu lắm 
-- select khach_hang.ho_ten from khach_hang
-- where ho_ten not in (select distinct kh1.ho_ten from khach_hang kh1
-- where exists( 
-- select kh1.ho_ten from khach_hang kh2
-- where kh1.ho_ten = kh2.ho_ten limit 1,1)); 

-- task 9 : 
select khach_hang.ho_ten, khach_hang.ma_khach_hang, count(khach_hang.ma_khach_hang) as so_khach_dat from khach_hang
join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
where hop_dong.ngay_lam_hop_dong between "2021-01-01" and "2021-01-31"
group by ho_ten
; 
select month(hop_dong.ngay_lam_hop_dong) as `thang`, count(hop_dong.ma_khach_hang) as so_luong_khach_dat from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = 2021
group by `thang`
order by `thang` ; 

-- task 10: 
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, count(hop_dong_chi_tiet.ma_dich_vu_di_kem) as so_luong_dv_di_kem  from hop_dong
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong. ma_hop_dong
group by ma_hop_dong
order by so_luong_dv_di_kem;

-- task 11:  
select dich_vu_di_kem.ten_dich_vu_di_kem, khach_hang.ho_ten from dich_vu_di_kem 
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
	join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong 
	join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
	join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
	where loai_khach.ten_loai_khach = "Diamond" and khach_hang.dia_chi like "%Vinh%" or khach_hang.dia_chi like "%Đà Nẵng%" ; 

-- task 12: 
-- dich vu trong 3 tháng cuối năm 2020; 
select dich_vu.ma_dich_vu ,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong, hop_dong.tien_dat_coc from dich_vu 
join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
where hop_dong.ngay_lam_hop_dong between "2020-09-01" and "2020-12-31" and hop_dong.ma_dich_vu 
	not in (select dich_vu.ma_dich_vu  from dich_vu 
	join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
	where hop_dong.ngay_lam_hop_dong between "2021-01-01" and "2021-06-30"
	group by ten_dich_vu)
group by ten_dich_vu; 
-- dich vu trong 6 thang dau nam 2021; 
select dich_vu.ma_dich_vu,dich_vu.ten_dich_vu  from dich_vu 
join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
where hop_dong.ngay_lam_hop_dong between "2021-01-01" and "2021-06-30"
group by ten_dich_vu; 

-- task 13: 
with count_dv_di_kem as (
	select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as count_dv_di_kem from dich_vu_di_kem
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
	group by hop_dong_chi_tiet.ma_dich_vu_di_kem
)
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,sum(hop_dong_chi_tiet.so_luong) as max_dv_di_kem from dich_vu_di_kem
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
	group by hop_dong_chi_tiet.ma_dich_vu_di_kem
    having max_dv_di_kem = (select max(count_dv_di_kem) from count_dv_di_kem )
    ;
-- task 14: 
select hop_dong.ma_hop_dong, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.ma_dich_vu_di_kem, count( hop_dong_chi_tiet.ma_dich_vu_di_kem) as count_dv_di_kem
 from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by ma_dich_vu_di_kem
having count_dv_di_kem=1; 

-- task 15: 
select nhan_vien.ma_nhan_vien, nhan_vien.ho_va_ten, count(hop_dong.ma_nhan_vien) as count_sl_chot_hop_dong from  nhan_vien
join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
group by ma_nhan_vien
having count_sl_chot_hop_dong >=1; 

-- task 16 : 
-- danh sach nhan vien chua tung lap hop dong tư 2019- 2021 
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien where ma_nhan_vien in (select * from 
(select ma_nhan_vien from nhan_vien where ma_nhan_vien not in 
(select nhan_vien.ma_nhan_vien from nhan_vien
join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) between "2020" and "2021"
group by ma_nhan_vien)) temp);
SET SQL_SAFE_UPDATES = 1;
-- cách 2: 
-- 1: danh sach nhan vien tao duoc hop dong; 
select hop_dong.ma_nhan_vien from hop_dong
where year(hop_dong.ngay_lam_hop_dong) between "2020" and "2021"
group by ma_nhan_vien; 
-- 2 : danh sach nhan vien khong tao hop dong; 
select nhan_vien.ma_nhan_vien, nhan_vien.ho_va_ten from nhan_vien
where nhan_vien.ma_nhan_vien 
not in (select hop_dong.ma_nhan_vien from hop_dong
where year(hop_dong.ngay_lam_hop_dong) between "2020" and "2021"
group by hop_dong.ma_nhan_vien); 
select* from nhan_vien; 
-- xoa bang tu du lieu. 
SET SQL_SAFE_UPDATES = 0;
DELETE FROM nhan_vien 
WHERE
    nhan_vien.ma_nhan_vien NOT IN 
    (SELECT 
        temp.ma_nhan_vien
    FROM
        (SELECT 
            nhan_vien.ma_nhan_vien
        FROM
            nhan_vien
        JOIN hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN '2020' AND '2021'
        GROUP BY ma_nhan_vien) temp); 
SET SQL_SAFE_UPDATES = 1;

-- task 17: 
-- liet ke khach hang platinum 
select khach_hang.ma_khach_hang, khach_hang.ho_ten, khach_hang.ma_loai_khach from khach_hang
join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
where ten_loai_khach = "Platinum"; 
-- liet ke khach hang co tong so tien thanh toan trong 2021 > 1 trieu. 
select khach_hang.ma_khach_hang,loai_khach.ma_loai_khach, khach_hang.ho_ten, dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia as total from khach_hang
	join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
	join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu 
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
	join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
	join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
	where year(hop_dong.ngay_lam_hop_dong) = "2021" and loai_khach.ten_loai_khach = "Diamond"
	group by khach_hang.ma_khach_hang;
-- update ma loai khach; 
SET SQL_SAFE_UPDATES = 0;
UPDATE `loai_khach` SET `ten_loai_khach` = 'Diamond' WHERE 
ma_loai_khach in (SELECT 
        temp.ma_loai_khach
    FROM(select loai_khach.ma_loai_khach from loai_khach
join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu 
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = "2021" and loai_khach.ten_loai_khach = "Platinum"
group by khach_hang.ma_khach_hang)temp); 
SET SQL_SAFE_UPDATES = 1;

-- task 18 : ràng buộc ko biết làm; 
SET SQL_SAFE_UPDATES = 0;
set foreign_key_checks = 0;
DELETE FROM khach_hang 
WHERE
    ma_khach_hang IN (SELECT 
        ma_khach_hang
    FROM
        hop_dong
    
    WHERE
        YEAR(ngay_lam_hop_dong) < '2021'); 
set foreign_key_checks = 1; 
SET SQL_SAFE_UPDATES = 0;
select * from khach_hang; 
-- task 19 : 
-- hiển thị những dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2021; 
select dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.gia,  dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as count_dv_di_kem from dich_vu_di_kem
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
    join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
    where year(hop_dong.ngay_lam_hop_dong) = "2021"
	group by hop_dong_chi_tiet.ma_dich_vu_di_kem
    having count_dv_di_kem >10 ; 

-- update những dịch vụ đi kèm sử dụng hơn 10 lần trong năm 2021 
    SET SQL_SAFE_UPDATES = 0;
update dich_vu_di_kem set gia = gia*2 where ma_dich_vu_di_kem in
(select temp.ma_dich_vu_di_kem from(select dich_vu_di_kem.ma_dich_vu_di_kem from dich_vu_di_kem
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
    join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
    where year(hop_dong.ngay_lam_hop_dong) = "2021"
	group by hop_dong_chi_tiet.ma_dich_vu_di_kem
    having sum(so_luong) >10)temp); 
    SET SQL_SAFE_UPDATES = 1;
    
-- task 20 : 
select nv.ma_nhan_vien, nv.ho_va_ten,  nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi from nhan_vien nv 
union all 
select kh.ma_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi from khach_hang kh; 
