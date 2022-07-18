use quanlysinhvien;
-- task 1: 
select student.address, count(student.StudentName) as sl_sv_moi_tinh from student 
group by address;

-- task 2: 
select student.StudentName, student.StudentId, avg(mark.Mark) from student  
join mark on mark.StudentId = student.StudentId
group by StudentName;

-- task 3: 
select student.StudentName, student.StudentId, avg(mark.Mark) as diem_trung_binh from student  
join mark on mark.StudentId = student.StudentId
group by StudentName
having  diem_trung_binh >15; 

-- task 4: diem trung binh lon nhat 
with diem_trung_binh_table as 
(select  avg(mark.Mark) as diem_trung_binh from student  
join mark on mark.StudentId = student.StudentId
group by StudentName) 
select student.StudentName, student.StudentId,  avg(mark.Mark) as max_diem_trung_binh from student  
join mark on mark.StudentId = student.StudentId
group by StudentName
having max_diem_trung_binh= (select max(diem_trung_binh) from  diem_trung_binh_table); 

-- task 4: cach 2, 

select s.StudentId, s.StudentName, avg (Mark) from student s
join mark M on s.StudentId = M.StudentId 
group by StudentName 
having avg(Mark) >= all(select avg(Mark) from Mark 
group by Mark.StudentId ); 
