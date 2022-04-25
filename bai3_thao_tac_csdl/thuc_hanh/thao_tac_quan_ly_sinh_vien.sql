use quan_ly_sinh_vien;
select * from student;
-- status bit 1 là true, 0 là false
-- Bước 3: Để hiển thị danh sách học viên đang theo học cần phải sử dụng câu lệnh select ... from kèm theo where để xét điều kiện truy vấn như sau:
select * from student where student.`status` = true;

-- Bước 4: Sử dụng điều kiện where Credit < 10 và from Subject để lấy ra danh sách các môn học có thời gian học nhỏ hơn 10
select * from `subject` where credit < 10;

-- Bước 5: Sử dụng câu lệnh Join và where để hiển thị danh sách học viên lớp A1
-- Join 2 bảng Student và Class bằng câu lệnh sau:
-- Sử dụng câu lệnh Where C.ClassName ='A1' để hiển thị danh sách học viên lớp A1
select student.student_id, student.student_name, class.class_name from student
join class on student.class_id = class.class_id where class_name = "A1";

-- Bước 6: Hiển thị điểm môn CF của các học viên
-- Hiển thị tất cả các điểm đang có của học viên
select student.student_id, student.student_name, `subject`.sub_name, mark.mark
from student 
join mark on student.student_id = mark.student_id
join `subject` on mark.sub_id = subject.sub_id
where `subject`.sub_name = "CF";

