create database Worker_DB;


create table workers(
	id int primary key identity(1,1), 
	name varchar(50), 
	address varchar(50), 
	email varchar(50)
);


insert into workers (name, address, email) values
(1, 'Nguyen Van Hoang', 'Quang Ngai' , 'hoanvan09@gmail.com');

select * from workers;

delete from workers where id = 3;