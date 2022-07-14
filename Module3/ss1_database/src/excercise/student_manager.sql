use student_manager; 
CREATE TABLE `class` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);
 
 CREATE TABLE teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `age` INT NOT NULL,
    `country` VARCHAR(45) DEFAULT 'vietnam',
    CHECK (age >18) 
); 
 alter table teacher  add email VARCHAR(45) UNIQUE; 
 alter table teacher drop email; 
update teacher set age = 24, country = "Ninh Binh" where id = 1; 
insert into teacher(`name`,age,country ) values ("Phu",30,"Da Nang"),("Chanh",34,"Quang Nam"),("Hai",29,"Quang Nam"),("Chien", 29,"Quang Tri");
insert into class(`name`) values ("C01"),("C02"),("C03"),("C04");
select*from teacher 
where not  country ="Quang Nam" and not `name`= "Chanh"; 