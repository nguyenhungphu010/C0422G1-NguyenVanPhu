use csdl_quan_ly_ban_hang; 
insert into customer(cName,cAge) values ("Minh Quan",10), ("Ngoc Oanh",20), ("Hong Ha",50); 
insert into `order`(cId,oDate) values (1,"2006-03-22"),(2,"2006-03-23"),(1,"2006-03-16"); 
insert into `product`(pName,pPrice) values ('May Giat', '3'),( 'Tu Lanh', '5'),( 'Dieu Hoa', '7'),('Quat', '1'),( 'Bep Dien', '2');
INSERT INTO `csdl_quan_ly_ban_hang`.`orderdetail` (`oID`, `pID`, `odQTY`) VALUES ('1', '1', '3'),('1', '3', '7'),('1', '4', '2'),('2', '1', '1'),('3', '1', '8'),('2', '5', '4'),('2', '3', '3');
-- hien thi cac thong tin ID, oDate, oPrice cua tat ca cac hoa don trong Order 
select `order`.oID, `order`.oDate, `order`.oPrice from  `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.cName, product.pName from customer 
	join `order` on `order`.cID = customer.cID
	join orderdetail on orderdetail.oId = `order`. oId
	join product on product.pID = orderdetail.pID;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.cName from customer
where cName not in (
	select customer.cName from customer 
	join `order` on `order`.cID = customer.cID
	join orderdetail on orderdetail.oId = `order`. oId
	join product on product.pID = orderdetail.pID
); 
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.oID,`order`.oDate, sum(orderdetail.odQTY*product.pPrice) as totalPrice from `order` 
	join orderdetail on orderdetail.oId = `order`. oId
	join product on product.pID = orderdetail.pID
	group by `order`.oID