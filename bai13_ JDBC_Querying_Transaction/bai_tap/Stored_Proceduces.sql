use demo;

drop procedure if exists get_user_by_id;

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT) 
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;



create table Permision(
id int(11) primary key,
name varchar(50)
);
insert into Permision(id, name) values(1, 'add');
insert into Permision(id, name) values(2, 'edit');
insert into Permision(id, name) values(3, 'delete');
insert into Permision(id, name) values(4, 'view');
 
create table User_Permision(
permision_id int(11),
user_id int(11)
);

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
DELIMITER $$
CREATE PROCEDURE select_all_users() 
BEGIN
    select * from users;
    END$$
DELIMITER ;

call select_all_users();

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
drop procedure if exists edit_user ;

DELIMITER $$
CREATE PROCEDURE edit_user(in `name_input` varchar(25), in country_input varchar(25) , in email_input varchar(25), in id_input int) 
BEGIN
    update users set `name` = name_input, email= email_input, country =country_input where id = id_input;
    END$$
DELIMITER ;

call edit_user('thang', 'quang nam', 'thang@gmail.com', 19);

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
drop procedure if exists delete_user ;

DELIMITER $$
CREATE PROCEDURE delete_user(in id_input int) 
BEGIN
    delete from users where id = id_input;
    END$$
DELIMITER ;

call delete_user(19);

