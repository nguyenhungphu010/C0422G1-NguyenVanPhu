create database csdl_quan_ly_ban_hang; 
use  csdl_quan_ly_ban_hang;
CREATE TABLE customer (
    cID INT PRIMARY KEY,
    cAge INT NOT NULL,
    cName VARCHAR(45)
);
CREATE TABLE `order` (
    oID INT PRIMARY KEY,
    cDate DATE NOT NULL,
    oprice DOUBLE NOT NULL,
    cID INT,
    FOREIGN KEY (cID)
        REFERENCES customer (cID)
);
CREATE TABLE `product` (
    pID INT PRIMARY KEY,
    pName VARCHAR(45),
    pPrice DOUBLE NOT NULL
);
CREATE TABLE OrderDetail (
    oID INT,
    pID INT,
    odQTY INT NOT NULL,
    PRIMARY KEY (oID , pID),
    FOREIGN KEY (oID)
        REFERENCES `order` (oID),
    FOREIGN KEY (pID)
        REFERENCES `product` (pID)
);
