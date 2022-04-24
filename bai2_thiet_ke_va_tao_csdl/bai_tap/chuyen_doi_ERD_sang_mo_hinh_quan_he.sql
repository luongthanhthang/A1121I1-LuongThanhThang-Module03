create database xay_dung;
use xay_dung;

-- drop database xay_dung;

-- phiếu xuất
create table phieu_xuat(
so_px int primary key auto_increment,
ngay_xuat date
);

-- phiếu nhập
create table phieu_nhap(
so_pn int primary key auto_increment,
ngay_nhap date
);

-- vật tư
create table vat_tu(
ma_vtu int primary key,
ten_vtu varchar(30)
);

--  thuộc tính đa trị sdt(của nhà cung cấp)
create table sdt(
id_sdt int primary key auto_increment,
sdt varchar(10)
);

-- nhà cung cấp
create table nha_cc(
ma_ncc int primary key,
ten_ncc varchar(30),
dia_chi varchar(30),
id_sdt int,
foreign key(id_sdt) references sdt(id_sdt)
);

-- Đơn đặt hàng
create table don_dh(
so_dh int primary key auto_increment,
ngay_dh date,
-- mã nhà cung cấp
ma_ncc int,
foreign key(ma_ncc) references nha_cc(ma_ncc)
);

-- quan hệ n-n phiếu xuất và vật tư
create table chi_tiet_phieu_xuat(
dg_xuat double,
sl_xuat int,
so_px int,
ma_vtu int,
primary key(so_px,ma_vtu),
-- foreign key(so_px) references phieu_xuat(so_px) ,
foreign key(ma_vtu)  references vat_tu(ma_vtu),
foreign key(so_px) references phieu_xuat(so_px)
);

-- quan hệ n-n vật tư và phiếu nhập
create table chi_tiet_phieu_nhap(
dg_nhap double,
sl_nhap int,
ma_vtu int ,
so_pn int ,
primary key(ma_vtu, so_pn),
foreign key(ma_vtu) references vat_tu(ma_vtu),
foreign key(so_pn) references phieu_nhap(so_pn)
);

-- quan hệ n-n vật tư và đơn đặt hàng 
create table chi_tiet_don_dat_hang(
ma_vtu int,
so_dh int,
primary key(ma_vtu, so_dh),
foreign key(ma_vtu) references vat_tu(ma_vtu),
foreign key(so_dh) references don_dh(so_dh)
);


