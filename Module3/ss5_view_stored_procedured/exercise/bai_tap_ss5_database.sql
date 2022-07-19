drop database if exists bai_tap_ss5;
create database bai_tap_ss5;
use bai_tap_ss5;
CREATE TABLE Products  (
Id INT AUTO_INCREMENT,
productCode int, 
productName varchar(45), 
productPrice double not null, 

productAmount int not null, 
productDescription varchar(45), 
productStatus bit(1) default 0, 
    PRIMARY KEY (Id)
);
insert into Products (productCode, productName, productPrice,productAmount, productDescription)
values (123,"IPhone", 20000000, 5, "Apple Product"), 
(124,"Galaxy", 21000000, 4, "Sumsung Product"), 
(125,"Signature S", 200000000, 0, "Vertu Product"), 
(126,"KEY2 Red", 1500000, 30, "BlackBerry Product"); 