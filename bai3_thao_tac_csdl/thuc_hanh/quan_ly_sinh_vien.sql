create database if not exists quan_ly_sinh_vien;
use quan_ly_sinh_vien;

-- drop database quan_li_sinh_vien;
-- SET SQL_SAFE_UPDATES = 0;

-- bảng class
create table if not exists class(
class_id int primary key auto_increment,
class_name varchar(30),
start_date date,
`status` bit
);

-- bảng student
create table if not exists student(
student_id int primary key auto_increment,
student_name varchar(30),
address varchar(50),
phone varchar(10),
`status` bit,
class_id int,
foreign key (class_id) references class(class_id)
);

-- bảng subject
create table if not exists `subject`(
sub_id int primary key auto_increment,
sub_name varchar(30),
credit int,
`status` bit
);

-- bảng mark
create table if not exists mark(
mark_id int primary key auto_increment,
sub_id int,
student_id int,
mark int,
exam_times int,

foreign key (sub_id) references `subject`(sub_id),
foreign key (student_id) references `student`(student_id)
);

-- thêm dữ liệu
-- current_date ngày hiện tại của máy

insert into class (class_name, start_date, `status`) values ('A1', '2008-12-20', 1),  
('A2', '2008-12-22', 1), 
('B3', current_date, 0);
select * from class;

insert into student(student_name, address, phone, `status`, class_id) values ('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai phong',"0905113113", 1, 1), 
('Manh', 'HCM', '0123123123', 0, 2);
select * from student;

insert into `subject`(sub_name, credit, `status`) values ('CF', 5, 1),
       ('C', 6, 1),
       ('HDJ', 5, 1),
       ('RDBMS', 10, 1);
       select * from `subject`;

insert into mark(sub_id, student_id, mark, exam_times) values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       select * from `mark`;
