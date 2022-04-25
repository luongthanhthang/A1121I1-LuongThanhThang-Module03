create database if not exists quan_li_ban_hang;
use quan_li_ban_hang;

-- Customer
create table if not exists customer(
`c_id` int primary key auto_increment,
`c_name` varchar(30),
`c_age` int
);

-- Order 
create table if not exists `order`(
`o_id` int primary key auto_increment,
`c_id` int,
`o_date` date,
`o_total_price` double,
foreign key(`c_id`) references customer(`c_id`)
);

-- product
create table if not exists product(
`p_id` int primary key auto_increment,
`p_name` varchar(30),
`p_price` double
);

-- quan hệ 1-n  
create table if not exists order_detail(
`o_id` int,
`p_id` int,
`od_qty` int,
primary key(o_id, p_id),
foreign key(`o_id`) references `order`(`o_id`),
foreign key(`p_id`) references `product`(`p_id`)
);
