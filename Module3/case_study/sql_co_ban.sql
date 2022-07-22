use case_study_module_3; 
-- task 2 : Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT 
    *
FROM
    nhan_vien
WHERE
    (ho_va_ten LIKE 'H%'
        OR ho_va_ten LIKE 'K%'
        OR ho_va_ten LIKE 'T%')
        AND char_length(ho_va_ten) < 15;
-- task 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
    kh.*,
    TIMESTAMPDIFF(YEAR,
        kh.ngay_sinh,
        CURDATE()) AS age
FROM
    khach_hang kh
WHERE
    (kh.dia_chi LIKE '%Đà Nẵng%'
        OR kh.dia_chi LIKE '%Quảng Trị%')
HAVING age > 18 AND age < 50; 

-- task 4: 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    COUNT(hop_dong.ma_khach_hang) AS so_lan_dat_phong
FROM
    khach_hang
        JOIN
    hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
WHERE
    (ma_loai_khach = (SELECT 
            ma_loai_khach
        FROM
            loai_khach
        WHERE
            ten_loai_khach = 'Diamond'))
GROUP BY hop_dong.ma_khach_hang
ORDER BY so_lan_dat_phong;

-- task 5 : 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT 
    kh.ma_khach_hang,
    kh.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.ma_hop_dong,
    dich_vu.ten_dich_vu,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
   sum(ifnull(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia,
             0)) + dich_vu.chi_phi_thue AS tong_tien,
    dich_vu.chi_phi_thue
FROM
    khach_hang kh
        LEFT JOIN
    loai_khach ON loai_khach.ma_loai_khach = loai_khach.ma_loai_khach
        LEFT JOIN
    hop_dong ON hop_dong.ma_khach_hang = kh.ma_khach_hang
        left JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        left JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        left JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ma_hop_dong 
ORDER BY ma_khach_hang;
-- task 6: 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021
--  (Quý 1 là tháng 1, 2, 3).
SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
        RIGHT JOIN
    hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
WHERE
    dich_vu.ma_dich_vu NOT IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                JOIN
            hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
                JOIN
            loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
        WHERE
            (hop_dong.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-03-31')
        GROUP BY ten_dich_vu) 
GROUP BY dich_vu.ma_dich_vu
;
-- loai dich vu duoc dat trong 2020 
SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    hop_dong ON hop_dong.ma_dich_vu = dv.ma_dich_vu
        JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dv.ma_loai_dich_vu
WHERE
    hop_dong.ngay_lam_hop_dong BETWEEN '2020-01-01' AND '2020-12-31'
GROUP BY ma_dich_vu; 
    
-- loai dich vu duoc dat trong QUÝ 1 2021 
SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    hop_dong ON hop_dong.ma_dich_vu = dv.ma_dich_vu
        JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dv.ma_loai_dich_vu
WHERE
    hop_dong.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-12-31'
GROUP BY ma_dich_vu; 
    
-- task 7 : 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.so_nguoi_toi_da,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
        JOIN
    hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
WHERE
    hop_dong.ngay_lam_hop_dong BETWEEN '2020-01-01' AND '2020-12-31'
        AND dich_vu.ma_dich_vu NOT IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                JOIN
            hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
                JOIN
            loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
        WHERE
            hop_dong.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-12-31'
        GROUP BY ma_dich_vu)
GROUP BY ma_dich_vu; 

-- task 8 :  8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.

-- cach 1 : 
SELECT 
    khach_hang.ho_ten, COUNT(*)
FROM
    khach_hang
GROUP BY ho_ten
HAVING COUNT(*) = 1; 
-- cach 2: 
SELECT 
    kh1.ho_ten
FROM
    khach_hang kh1
        JOIN
    khach_hang kh2 ON kh1.ma_khach_hang = kh2.ma_khach_hang
WHERE
    kh1.ho_ten = kh2.ho_ten
GROUP BY ho_ten
HAVING COUNT(*) = 1; 

-- cách 3: 
select distinct khach_hang.ho_ten 
from khach_hang; 
-- task 9 :Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

SELECT 
    MONTH(hop_dong.ngay_lam_hop_dong) AS `thang`,
    COUNT(hop_dong.ma_khach_hang) AS so_luong_khach_dat
FROM
    hop_dong
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = 2021
GROUP BY `thang`
ORDER BY `thang`; 

-- task 10: 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT 
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    SUM(hop_dong_chi_tiet.so_luong) AS so_luong_dv_di_kem
FROM
    hop_dong
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
    LEFT JOIN 
    dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ma_hop_dong;

-- task 11:  11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và 
-- có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
SELECT 
dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem, 
    khach_hang.ho_ten
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        JOIN
    khach_hang ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
WHERE
    loai_khach.ten_loai_khach = 'Diamond'
        AND khach_hang.dia_chi LIKE '%Vinh%'
        OR khach_hang.dia_chi LIKE '%Quảng Ngãi%';

-- task 12: Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

-- dich vu trong 3 tháng cuối năm 2020; 

-- dich vu trong 6 thang dau nam 2021; 
SELECT 
    hop_dong.*, SUM(hop_dong_chi_tiet.so_luong)
FROM
    hop_dong
        LEFT JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
WHERE
    hop_dong.ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-31'
        AND hop_dong.ma_hop_dong NOT IN (SELECT 
            hop_dong.ma_hop_dong
        FROM
            hop_dong
                JOIN
            dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            hop_dong.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-06-30'
        GROUP BY hop_dong.ma_hop_dong)
GROUP BY hop_dong.ma_hop_dong;					
-- task 13: 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
with count_dv_di_kem as (
	SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(hop_dong_chi_tiet.so_luong) AS count_dv_di_kem
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
)
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(hop_dong_chi_tiet.so_luong) AS max_dv_di_kem
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
HAVING max_dv_di_kem = (SELECT 
        MAX(count_dv_di_kem)
    FROM
        count_dv_di_kem)
    ;
    
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(hop_dong_chi_tiet.so_luong) AS max_dv_di_kem
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
HAVING max_dv_di_kem = (
SELECT 
        MAX(so_luong)
    FROM
        hop_dong_chi_tiet
        );
-- TASK 14: 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung
--  (được tính dựa trên việc count các ma_dich_vu_di_kem).
SELECT 
    hop_dong.ma_hop_dong,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    dich_vu_di_kem.ma_dich_vu_di_kem,
    COUNT(hop_dong_chi_tiet.ma_dich_vu_di_kem) AS count_dv_di_kem
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
GROUP BY ma_dich_vu_di_kem
HAVING count_dv_di_kem = 1; 

-- TASK 15: 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT 
    nhan_vien.ma_nhan_vien,
    nhan_vien.ho_va_ten,
    COUNT(hop_dong.ma_nhan_vien) AS count_sl_chot_hop_dong
FROM
    nhan_vien
        JOIN
    hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
GROUP BY ma_nhan_vien
HAVING count_sl_chot_hop_dong <= 3; 

-- TASK 16 : Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
-- danh sach nhan vien chua tung lap hop dong tư 2019- 2021 
SET SQL_SAFE_UPDATES = 0;
DELETE FROM nhan_vien 
WHERE
    ma_nhan_vien IN (SELECT 
        *
    FROM
        (SELECT 
            ma_nhan_vien
        FROM
            nhan_vien
        
        WHERE
            ma_nhan_vien NOT IN (SELECT 
                nhan_vien.ma_nhan_vien
            FROM
                nhan_vien
            JOIN hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
            
            WHERE
                YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN '2020' AND '2021'
            GROUP BY ma_nhan_vien)) temp);
SET SQL_SAFE_UPDATES = 1;
-- cách 2: 
-- 1: danh sach nhan vien tao duoc hop dong; 
SELECT 
    hop_dong.ma_nhan_vien
FROM
    hop_dong
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN '2020' AND '2021'
GROUP BY ma_nhan_vien; 
-- 2 : danh sach nhan vien khong tao hop dong; 
SELECT 
    nhan_vien.ma_nhan_vien, nhan_vien.ho_va_ten
FROM
    nhan_vien
WHERE
    nhan_vien.ma_nhan_vien NOT IN (SELECT 
            hop_dong.ma_nhan_vien
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN '2020' AND '2021'
        GROUP BY hop_dong.ma_nhan_vien);
SELECT 
    *
FROM
    nhan_vien; 
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

-- task 17:Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với 
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 1.000.000 VNĐ.
SET SQL_SAFE_UPDATES = 0;
-- liet ke khach hang co tong so tien thanh toan trong 2021 > 1 trieu. 
SELECT 
    khach_hang.ma_khach_hang,
    loai_khach.ma_loai_khach,
    khach_hang.ho_ten,
    dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia AS total
FROM
    khach_hang
        JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
        JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = '2021'
        AND loai_khach.ten_loai_khach = 'Platinum'
GROUP BY khach_hang.ma_khach_hang
  having total > 1000000;
-- update ma loai khach; 
SET SQL_SAFE_UPDATES = 0;
UPDATE `loai_khach` 
SET 
    `ten_loai_khach` = 'Diamond'
WHERE
    ma_loai_khach IN (SELECT 
            temp.ma_loai_khach
        FROM
            (SELECT 
                loai_khach.ma_loai_khach,
                dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia AS total
            FROM
                loai_khach
            JOIN khach_hang ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
            JOIN hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
            JOIN dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
            JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            JOIN dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
            WHERE
                YEAR(hop_dong.ngay_lam_hop_dong) = '2021'
                    AND loai_khach.ten_loai_khach = 'Platinum'
            GROUP BY khach_hang.ma_khach_hang
            HAVING total > 1000000) temp);
SET SQL_SAFE_UPDATES = 1;

-- task 18 : Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SET SQL_SAFE_UPDATES = 0;
set foreign_key_checks = 0;
DELETE FROM khach_hang 
WHERE
    ma_khach_hang IN (SELECT 
        ma_khach_hang
    FROM
        hop_dong
    
    WHERE
        YEAR(ngay_lam_hop_dong) < 2021); 
set foreign_key_checks = 1; 
SET SQL_SAFE_UPDATES = 0;
select * from khach_hang; 

-- TASK 19  :Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
-- hiển thị những dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2021; 
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.gia,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(hop_dong_chi_tiet.so_luong) AS count_dv_di_kem
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = 2020
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
HAVING count_dv_di_kem > 10; 

-- update những dịch vụ đi kèm sử dụng hơn 10 lần trong năm 2021 
    SET SQL_SAFE_UPDATES = 0;
UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    ma_dich_vu_di_kem IN (SELECT 
            temp.ma_dich_vu_di_kem
        FROM
            (SELECT 
                dich_vu_di_kem.ma_dich_vu_di_kem
            FROM
                dich_vu_di_kem
            JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
            JOIN hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
            WHERE
                YEAR(hop_dong.ngay_lam_hop_dong) = 2020
            GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
            HAVING SUM(so_luong) > 10) temp); 
    SET SQL_SAFE_UPDATES = 1;
    
-- TASK 20 : Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
--  thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
SELECT 
    nv.ma_nhan_vien,
    nv.ho_va_ten,
    nv.email,
    nv.so_dien_thoai,
    nv.ngay_sinh,
    nv.dia_chi
FROM
    nhan_vien nv 
UNION ALL SELECT 
    kh.ma_khach_hang,
    kh.ho_ten,
    kh.email,
    kh.so_dien_thoai,
    kh.ngay_sinh,
    kh.dia_chi
FROM
    khach_hang kh; 
