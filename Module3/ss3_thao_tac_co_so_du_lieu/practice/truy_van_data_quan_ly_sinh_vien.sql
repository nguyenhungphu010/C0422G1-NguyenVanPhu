use quanlysinhvien; 
select*from student
where status = false; 
select*from `subject`
where Credit <10; 
select S.StudentId, S.StudentName, Sub.SubName, M.Mark
from student S join mark M on S.StudentId = M.StudentId join `subject` Sub on M.SubId = Sub.SubId;
select S.StudentId, S.StudenName, Sub.SubName, M.Mark
from student S join mark M on S.StudentId = M.StudentId join `subject` Sub on M.SubId = Sub.SubId
where Sub.SubName = 'CF';