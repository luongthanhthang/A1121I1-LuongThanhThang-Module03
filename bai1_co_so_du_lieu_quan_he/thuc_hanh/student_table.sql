-- khởi tạo database
create database if not exists my_database;
-- sử dụng database
use my_database;

-- xoá database
drop database my_database;
-- -- tạo bảng student
 create table student(
`id` int primary key auto_increment,
`name` varchar(50),
 `age` int,
 `country` varchar(50)
);
-- thêm 1 recoll(hàng) vào bảng
insert into student( `name`, `age`, `country`) values("Lương Thanh Thắng", 20, "Đà Nẵng");
insert into student( `name`, `age`, `country`) values("Lê Hùng Sơn", 20, "Đà Nẵng");
insert into student( `name`, `age`, `country`) values("Lương Thanh Huyền", 22, "Quảng Nam");

-- Trước khi update phải tắt “Safe Update Mode” vì tính bảo mật
SET SQL_SAFE_UPDATES = 0;

-- sửa đổi thông tin
update student set `name` = "Thắng Thanh Lương" where `id` = 3;
update student set `Birthday`="2000-06-27", `name`="Thắng Lương Thanh" where `id` = 3;

-- xoá thông tin 
delete from student where `id` is null;

-- Thêm trường mới cho student (vd thêm trường ngày sinh)
alter table student add `Birthday` date;

-- xoá hết bảng, tự động id vẫn tính
delete from student;

-- xoá hết tự động id xét về lại từ đầu
truncate student;

-- hiển thị bảng
select * from student;