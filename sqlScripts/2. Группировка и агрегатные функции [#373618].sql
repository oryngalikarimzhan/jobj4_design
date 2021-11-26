create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices(name, price) values ('computer', 15000);
insert into devices(name, price) values ('smartphone', 8000);
insert into devices(name, price) values ('ereader', 5000);
insert into devices(name, price) values ('headphone', 4000);
insert into devices(name, price) values ('watch', 6000);
insert into devices(name, price) values ('laptop', 13000);
insert into devices(name, price) values ('tab', 8000);

insert into people(name) values ('Katya');
insert into people(name) values ('Nikita');
insert into people(name) values ('Oleg');
insert into people(name) values ('Kostya');
insert into people(name) values ('Pasha');
insert into people(name) values ('Misha');

insert into devices_people(people_id, device_id) values (1, 1);
insert into devices_people(people_id, device_id) values (1, 2);
insert into devices_people(people_id, device_id) values (1, 3);
insert into devices_people(people_id, device_id) values (1, 4);
insert into devices_people(people_id, device_id) values (2, 1);
insert into devices_people(people_id, device_id) values (3, 1);
insert into devices_people(people_id, device_id) values (4, 1);
insert into devices_people(people_id, device_id) values (5, 1);
insert into devices_people(people_id, device_id) values (6, 1);
insert into devices_people(people_id, device_id) values (4, 2);
insert into devices_people(people_id, device_id) values (3, 2);
insert into devices_people(people_id, device_id) values (2, 2);
insert into devices_people(people_id, device_id) values (5, 2);
insert into devices_people(people_id, device_id) values (6, 2);


select avg(price) from devices;

select p.name, avg(d.price) from devices as d 
join people as p
join devices_people as dp
on dp.people_id = p.id
on dp.device_id = d.id
group by p.name; 

select p.name, avg(d.price) from devices as d 
join people as p
join devices_people as dp
on dp.people_id = p.id
on dp.device_id = d.id
group by p.name
having avg(d.price) > 9000; 

