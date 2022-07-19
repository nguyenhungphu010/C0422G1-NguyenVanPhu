use bai_tap_ss5; 
select * from Products 
where productName = "IPhone"
; 
-- Task 1:  Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục) 
alter table Products add index  unique_index (productCode ); 
explain select*from Products where productCode = 123; 

-- task2: tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table Products add index composite_index (productName,productPrice); 
explain select* from Products where productName = "IPhone" or productPrice = 1500000; 

-- so sánh câu truy vấn 
-- trước khi tạo index : duration/ fetch : 0.000 sec
-- sau khi tạo unique index : duration/ fetch : 0.156 sec
-- sau khi tạo composite index : duration/ fetch : 0.109 sec.

-- task 3:  Tạo view lấy về các thông tin: productCode, productName, 
-- productPrice, productStatus từ bảng products.
-- tạo bảng ảo

CREATE VIEW product_views AS
    SELECT 
        productCode, productName, productPrice, productStatus
    FROM
        Products; 
        
-- cập nhật bảng ảo 

CREATE OR REPLACE VIEW product_views AS
    SELECT 
        productCode, productName, productPrice, productStatus
    FROM
        Products; 
SET SQL_SAFE_UPDATES = 0;
UPDATE product_views 
SET 
    productName = 'Galaxy S11'
WHERE
    productPrice = 21000000; 
SET SQL_SAFE_UPDATES = 0;
-- lấy dữ liệu từ bảng ảo
select*from product_views; 
-- xóa bảng ảo 
drop view product_views; 

-- task 4: thao tác với procedure 
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product 

delimiter //
create procedure get_all_product()
  begin
    select * from Products
    where productStatus = 0;
  end //
delimiter ;
-- gọi procedure 
call get_all_product(); 

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_new_product(p_Code int, p_Name varchar(45), p_Price double, p_Amount int, p_Description varchar(45))
  begin
    INSERT INTO Products(productCode,productName, productPrice, productAmount, productDescription)
    VALUES (p_Code,p_Name, p_Price, p_Amount, p_Description);
  end //
delimiter ;
call add_new_product (127,"Oppo A1", 1300000, 6,"Oppo Product"); 

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure modifile_product_by_id(p_id int, p_name varchar(45))
  begin
    update Products
    set productName = p_name
    where Id = p_id;
  end //
delimiter ;
call modifile_product_by_id(1,"Iphone 13 Promax"); 
select * from Products ; 

-- 
delimiter //
create procedure delete_product_by_id(p_id int)
  begin
    delete from Products 
    where Id = p_id; 
  end //
delimiter ;

call delete_product_by_id (3); 
select * from Products ; 