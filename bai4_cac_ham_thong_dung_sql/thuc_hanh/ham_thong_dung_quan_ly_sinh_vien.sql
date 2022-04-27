use quan_ly_sinh_vien;
-- Hiển thị số lượng sinh viên ở từng nơi
select student.address, count(student.id) as so_luong_sinh_vien
from student
group by student.address
;

-- Tính điểm trung bình các môn học của mỗi học viên
select student.student_id, student_name, avg(mark.mark) as diem_trung_binh 
from mark
join student on student.student_id = mark.student_id
group by student.student_name, student.student_id
;

-- Bước 4: Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
-- Đầu tiên hiển thị điểm trung bình các môn học của mỗi học viên
select student.student_id, student_name, avg(mark.mark) as diem_trung_binh 
from mark
join student on student.student_id = mark.student_id
group by student.student_name, student.student_id
having avg(mark.mark) > 12
;

-- Bước 5: Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select student.student_id, student_name, avg(mark.mark) as diem_trung_binh_lon_nhat
from mark
join student on student.student_id = mark.student_id
group by student.student_name, student.student_id
having avg(mark.mark) >= all (select avg(mark) from mark GROUP BY mark.student_id);
;
-- hàm all : lấy tất cả dữ liệu từ bảng (select .... )

