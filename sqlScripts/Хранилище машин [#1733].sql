/*1.1 Создать структур данных в базе. Таблицы. Кузов. Двигатель, Коробка передач.*/
create table body(
	id serial primary key,
	serial_number int
);

create table engine(
	id serial primary key,
	serial_number int
);

create table transmission(
	id serial primary key,
	serial_number int
);
/*1.2. Создать структуру Машина. Машина не может существовать без данных из п.1.*/
create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id) not null unique,
	engine_id int references engine(id) not null unique,
	transmission_id int references transmission(id) not null unique
);

/*1.3 Заполнить таблицы через insert. */
insert into body(serial_number) values (1224);
insert into body(serial_number) values (485659);
insert into body(serial_number) values (2341224);
insert into body(serial_number) values (531224);
insert into body(serial_number) values (7561224);


insert into engine(serial_number) values (6783244);
insert into engine(serial_number) values (67867676);
insert into engine(serial_number) values (64554676);
insert into engine(serial_number) values (9856453);
insert into engine(serial_number) values (8356724);


insert into transmission(serial_number) values (775645);
insert into transmission(serial_number) values (3245423);
insert into transmission(serial_number) values (98753);
insert into transmission(serial_number) values (87566476);
insert into transmission(serial_number) values (456533);

insert into car(name, body_id, engine_id, transmission_id) values ('toyota', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('honda', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('huyindai', 3, 3, 3);
insert into car(name, body_id, engine_id, transmission_id) values ('kia', 4, 4, 4);

/*2.1 Вывести список всех машин и все привязанные к ним детали.*/
select c.name, 
b.serial_number as "body SN", 
e.serial_number as "engine SN", 
t.serial_number as "transmission SN"
from car as c 
left join body as b on c.body_id = b.id
join engine as e on c.engine_id = e.id
join transmission as t on c.transmission_id = t.id;


/*2.2 Вывести отдельно детали (1 деталь - 1 запрос), 
которые не используются НИ в одной машине, 
кузова, двигатели, коробки передач.*/

select b.serial_number as "body SN" 
from body as b 
left join car as c on c.body_id = b.id 
where c.name is null;

select e.serial_number as "engine SN" 
from engine as e 
left join car as c on c.engine_id = e.id 
where c.name is null;

select t.serial_number as "transmission SN" 
from transmission as t 
left join car as c on c.transmission_id = t.id 
where c.name is null;

