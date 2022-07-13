use student_manager; 
create table `class`(
`id` int primary key auto_increment,
`name` varchar(45)
 );
 
 create table teacher(
 id int primary key auto_increment, 
`name` varchar (45),
`age` int, 
`country` varchar(45)
); 
insert into teacher(`name`,age,country ) values ("Phu",30,"Da Nang"),("Chanh",34,"Quang Nam"),("Hai",29,"Quang Nam"),("Chien", 29,"Quang Tri");
insert into class(`name`) values ("C01"),("C02"),("C03"),("C04");