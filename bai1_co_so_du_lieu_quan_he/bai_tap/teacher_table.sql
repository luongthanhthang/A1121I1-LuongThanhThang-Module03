-- khởi tạo database
create database if not exists my_database_2;
-- sử dụng database
use my_database_2;

-- xoá bảng
drop table teacher;

-- xoá database
drop database my_database_2;
-- -- tạo bảng student
create table `my_database_2`.`teacher`(
`id` int primary key auto_increment,
`name` varchar(50),
 `age` int,
 `country` varchar(50)
);
-- thêm 1 recoll(hàng) vào bảng
insert into teacher( `name`, `age`, `country`) values("Lương Thanh Thắng", 20, "Đà Nẵng");
insert into teacher( `name`, `age`, `country`) values("Lê Hùng Sơn", 20, "Đà Nẵng");
insert into teacher( `name`, `age`, `country`) values("Lương Thanh Huyền", 22, "Quảng Nam");

-- Trước khi update phải tắt “Safe Update Mode” vì tính bảo mật
SET SQL_SAFE_UPDATES = 0;

-- sửa đổi thông tin
update teacher set `name` = "Thắng Thanh Lương" where `id` = 3;
update teacher set `Birthday`="2000-06-27", `name`="Thắng Lương Thanh" where `id` = 3;

-- xoá thông tin 
delete from teacher where `id` is null;

-- Thêm trường mới cho student (vd thêm trường ngày sinh)
alter table teacher add `Birthday` date;

-- xoá hết bảng, tự động id vẫn tính
delete from teacher;

-- xoá hết tự động id xét về lại từ đầu
truncate teacher;

-- hiển thị bảng
select * from teacher;