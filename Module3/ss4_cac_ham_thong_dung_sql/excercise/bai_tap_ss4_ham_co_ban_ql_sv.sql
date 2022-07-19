use quanlysinhvien; 

-- task 1: Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
-- sử dụng truy vấn con để sửa. 

SELECT 
    *
FROM
    `subject`
    WHERE 
    Credit = (SELECT MAX(Credit)
				 FROM `subject`);
-- task 2: Hiển thị các thông tin môn học có điểm thi lớn nhất.
-- sử dụng truy vấn con để sửa. 
SELECT 
    `subject`.SubId, `subject`.SubName, mark.Mark
FROM
    mark
        JOIN
    `subject` ON `subject`.SubId = mark.SubId
    WHERE 
    Mark = (SELECT MAX(Mark) 
              FROM  mark); 
    
-- task 3: Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

SELECT 
    student.StudentId,
    student.StudentName,
    AVG(Mark) AS avg_student_point
FROM
    student
        JOIN
    mark ON student.StudentId = mark.StudentId
GROUP BY StudentId
ORDER BY avg_student_point DESC; 