use classicmodels; 
delimiter // 
create procedure getCusById (IN cusNum Int(11))
begin 
select * from customers where customerName = cusNum; 
end // 
delimiter ; 
-- gọi store procedure 
call getCusById(175); 

-- tham số loại Out 

delimiter //
create procedure GetCustomerCountByCity ( IN in_city varchar(50), OUT total int)
begin
select count(customerNumber)
Into total 
from customers 
where city = in_city; 
end // 
delimiter ; 

-- goi store proceudre 
call GetCustomerCountByCity ('Lyon', @total); 
select @total; 

--  tham so loai in out 
delimiter //
create procedure SetCounter (INOUT counter INT, IN inc INT)
begin 
set counter = counter + inc; 
end // 
delimiter ; 
-- goi store procedure 
set @counter = 1; 
call SetCounter(@counter,1); 
call SetCounter(@counter,1); 
call SetCounter(@counter,5); 
select @counter; 
call SetCounter(@counter,1); 
call SetCounter(@counter,1); 