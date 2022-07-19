use quanlysinhvien;

-- TASK 1: Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’; 

SELECT 
    *
FROM
    student
WHERE
    student.StudentName LIKE 'h%';
    
-- TASK 2: Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.

SELECT 
    *
FROM
    class
WHERE
    MONTH(StartDate) = 12;

-- TASK 3: Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.

SELECT 
    *
FROM
    `subject`
WHERE
    Credit BETWEEN 3 AND 5; 

-- TASK 4: Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.

set sql_safe_updates = 0;
	UPDATE student 
SET 
    ClassId = 2
WHERE
    StudentName = 'Hung'; 
Set sql_safe_updates =1 ; 

-- TASK 5: Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. 
-- nếu trùng sắp theo tên tăng dần.

SELECT 
    student.StudentName, `subject`.SubName, mark.Mark
FROM
    student
        JOIN
    mark ON student.StudentId = mark.StudentId
        JOIN
    `subject` ON `subject`.SubId = mark.SubId
ORDER BY mark.Mark DESC , student.StudentName;