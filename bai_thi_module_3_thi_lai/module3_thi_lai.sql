create database if not exists bai_thi_module3;
use bai_thi_module3;
-- drop database bai_thi_module3;
set foreign_key_checks = 0;
set sql_safe_updates = 0;

create table if not exists category(
category_id int primary key auto_increment,
category_name varchar(25)
);
insert into category(category_name) values
("computer"),
("phone"),
("televison")
;

-- drop table product;
create table if not exists product(
product_id int primary key auto_increment,
product_name varchar(50),
product_price double,
product_quantity int,
product_color varchar(50),
product_describe varchar(50),
category_id int,

constraint fk_category_id foreign key (category_id) references category(category_id) on delete cascade
);

insert into product(product_name, product_price, product_quantity, product_color, product_describe, category_id) values
("iphone 11", 790, 12,"black", "beautiful", 2),
("iphone 12", 800, 15,"black", "beautiful1", 2),
("iphone 13", 790, 12,"red", "beautiful2", 2),
("smart TV", 1790, 21,"blue", "beautiful5", 3);

select product_id, product_name, product_price, product_quantity, product_color, category_id from product;
update product set product_name = "Iphone 14", product_price = 2000, product_quantity = 30, product_color = "blue", product_describe = "Moi ra", category_id = 2  where product_id = 5;