use quanlysinhvien; 
select*from student 
where student.StudentName like 'h%'; 
select*from class 
where month(StartDate) =12; 
select*from `subject`
where Credit between 3 and 5; 

set sql_safe_updates = 0; 
update student 
set ClassId = 2
where StudentName = 'Hung'; 
Set sql_safe_updates =1 ; 

select student.StudentName, `subject`.SubName, mark.Mark from student 
join mark on student.StudentId = mark.StudentId
join `subject` on `subject`.SubId = mark.SubId
order by mark.Mark desc, `subject`.SubName;