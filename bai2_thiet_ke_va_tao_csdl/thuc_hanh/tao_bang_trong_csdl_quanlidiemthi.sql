create database if not exists quan_ly_diem_thi;
use quan_ly_diem_thi;

-- drop database quan_ly_diem_thi;

-- table học sinh
create table if not exists hoc_sinh(
ma_hs varchar(30) primary key,
ten_hs varchar(50),
ngay_sinh date,
lop varchar(30),
GT varchar(30)
);

-- bảng giáo viên
create table if not exists giao_vien(
ma_gv varchar(30) primary key,
ten_gv varchar(30),
sdt varchar(10)
);

-- table môn học
create table mon_hoc(
ma_mh varchar(30) primary key,
ten_mh varchar(30)
);

-- table bảng điểm
create table if not exists bang_diem(
ma_hs varchar(20),
ma_mh varchar(20),
diem_thi int,
ngay_kt datetime,
primary key (ma_hs,ma_mh),
foreign key (ma_hs) references hoc_sinh(ma_hs),
foreign key (ma_mh) references mon_hoc(ma_mh)
);

-- thêm thuộc tính (mã giáo viên) cho môn học
alter table mon_hoc add `ma_gv` varchar(30);
alter table mon_hoc add foreign key (`ma_gv`) references giao_vien(`ma_gv`);


