use quanlysinhvien; 
-- task 1: 
select`subject`.SubId,`subject`.SubName,max(Credit) as max_credit from`subject` ;
-- task 2: 
select `subject`.SubId, `subject`.SubName, max(Mark) as max_mark from mark
join `subject` on `subject`.SubId = mark.SubId; 
-- task 3: 

select student.StudentId, student.StudentName,  avg(Mark) from student
join mark on student.StudentId = mark.StudentId 
group by StudentId; 