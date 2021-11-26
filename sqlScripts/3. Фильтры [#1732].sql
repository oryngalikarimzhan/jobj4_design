create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id), 
	expired_date date, 
	price int
);

insert into type(name) values ('сыр');
insert into type(name) values ('молоко');
insert into type(name) values ('мороженое');
insert into type(name) values ('мясо');
insert into type(name) values ('овощи');
insert into type(name) values ('фрукты');


insert into product(name, type_id, expired_date, price) values ('сыр плавленный', 1, '2021-12-12', 1000);
insert into product(name, type_id, expired_date, price) values ('сыр моцарелла', 1, '2021-09-12', 1500);
insert into product(name, type_id, expired_date, price) values ('сыр гауда', 1, '2021-12-12', 1200);
insert into product(name, type_id, expired_date, price) values ('молоко Домик в деревне', 2, '2021-10-12', 100);
insert into product(name, type_id, expired_date, price) values ('молоко шадринское', 2, '2021-12-12', 150);
insert into product(name, type_id, expired_date, price) values ('молоко домашнее', 2, '2021-12-12', 105);
insert into product(name, type_id, expired_date, price) values ('мороженое бомба', 3, '2021-12-12', 150);
insert into product(name, type_id, expired_date, price) values ('мороженое шин лайн', 3, '2021-12-12', 80);
insert into product(name, type_id, expired_date, price) values ('мороженое эскимо', 3, '2021-12-12', 90);
insert into product(name, type_id, expired_date, price) values ('мясо говядины', 4, '2021-11-12', 800);
insert into product(name, type_id, expired_date, price) values ('мясо баранины', 4, '2021-12-12', 750);
insert into product(name, type_id, expired_date, price) values ('мясо конины', 4, '2021-12-12', 850);
insert into product(name, type_id, expired_date, price) values ('огурец', 5, '2021-12-12', 70);
insert into product(name, type_id, expired_date, price) values ('морковь', 5, '2021-12-12', 60);
insert into product(name, type_id, expired_date, price) values ('картофель', 5, '2021-12-12', 30);
insert into product(name, type_id, expired_date, price) values ('яблоко апорт', 6, '2021-12-12', 100);
insert into product(name, type_id, expired_date, price) values ('яблоко лимонник', 6, '2021-12-12', 75);
insert into product(name, type_id, expired_date, price) values ('апельсин', 6, '2021-12-12', 130);


select p.name, t.name as "type" from product as p
join type as t
on p.type_id = t.id 
group by p.name, t.name
having t.name = 'сыр';


select name from product where name like '%мороженое' 
or name like 'мороженое%'
or name like '%мороженое%';

select name, expired_date from product 
where expired_date < current_date;

select name, price from product 
where price = (select max(price) from product);

select t.name, count(p.name) from product as p
join type as t
on p.type_id = t.id
group by t.name;

select p.name from product as p
join type as t
on p.type_id = t.id
group by p.name, t.name
having t.name = 'сыр'
or t.name = 'молоко';

select t.name, count(p.name) from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(p.name) < 10;

select * from product as p
join type as t
on p.type_id = t.id;
