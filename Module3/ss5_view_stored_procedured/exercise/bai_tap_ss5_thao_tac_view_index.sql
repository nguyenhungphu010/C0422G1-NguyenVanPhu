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

-- task 3:  ạo view lấy về các thông tin: productCode, productName, 
-- productPrice, productStatus từ bảng products.

create view 