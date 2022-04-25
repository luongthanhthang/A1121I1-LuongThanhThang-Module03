create database if not exists xay_dung;
use xay_dung;

-- drop database xay_dung;

--  thuộc tính đa trị sdt(của nhà cung cấp)
create table if not exists so_dien_thoai(
id_sdt int primary key auto_increment,
sdt varchar(10) not null
);

-- nhà cung cấp
create table if not exists nha_cung_cap(
ma_ncc int primary key,
ten_ncc varchar(30),
dia_chi varchar(30),
id_sdt int,
foreign key(id_sdt) references so_dien_thoai(id_sdt)
);

-- Đơn đặt hàng
create table if not exists don_dat_hang(
so_dh int primary key,
ngay_dh date,
-- mã nhà cung cấp
ma_ncc int,
foreign key(ma_ncc) references nha_cung_cap(ma_ncc)
);


-- phiếu xuất
create table if not exists phieu_xuat(
so_phieu_xuat int primary key auto_increment,
ngay_xuat date
);

-- phiếu nhập
create table if not exists phieu_nhap(
so_phieu_nhap int primary key auto_increment,
ngay_nhap date
);

-- vật tư
create table if not exists vat_tu(
ma_vat_tu int primary key,
ten_vat_tu varchar(30) not null
);

-- quan hệ n-n phiếu xuất và vật tư
create table if not exists chi_tiet_phieu_xuat(
don_gia_xuat double,
so_luong_xuat int,
so_phieu_xuat int,
ma_vat_tu int,
primary key(so_phieu_xuat,ma_vat_tu),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat)
);

-- quan hệ n-n vật tư và phiếu nhập
create table if not exists chi_tiet_phieu_nhap(
don_gia_nhap double,
so_luong_nhap int,
ma_vat_tu int ,
so_phieu_nhap int ,
primary key(ma_vat_tu, so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
);

-- quan hệ n-n vật tư và đơn đặt hàng 
create table if not exists chi_tiet_don_dat_hang(
ma_vat_tu int,
so_dh int,
primary key(ma_vat_tu, so_dh),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_dh) references don_dat_hang(so_dh)
);


