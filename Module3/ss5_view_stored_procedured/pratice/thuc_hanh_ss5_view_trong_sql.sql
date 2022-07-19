use classicmodels; 
-- tạo bảng ảo. 
create view customer_view as 
select customerNumber, customerName, phone 
from customers; 
-- lấy dữ liệu từ bảng ảo
select * from customer_view; 
-- cập nhật view 
create or replace view customer_view as 
select customerNumber, customerName, contactFirstName, contactLastName, phone 
from customers
where city = "Nantes";
-- lấy dự liệu từ bảng ảo 
select * from customer_view; 
-- xóa bảng view 
DROP VIEW customer_views;