use classicmodels 
-- tạo Stored Procedure 
delimiter // 
create procedure findAllCustomer()
begin 
select* from customers; 
end // 
delimiter ; 

-- gọi procedure 

call findAllCustomer(); 

-- sửa procedure , drop để xóa Procedure 

delimiter // 
drop procedure if exists `findAllCustomer`// 
create procedure findAllCustomer()
begin 
select* from customers where customerNumber = 175;
end // 
delimiter ; 
-- call procedure 

call findAllCustomers();
