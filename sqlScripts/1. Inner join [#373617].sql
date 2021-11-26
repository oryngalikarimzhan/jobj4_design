create table rank(
    id serial primary key,
    name varchar(255)
);

create table officer(
    id serial primary key,
    name varchar(255),
    rank_id int references rank(id),
	since date
);

insert into rank(name) values ('sergeant');
insert into rank(name) values ('lieutenant');
insert into rank(name) values ('major');
insert into rank(name) values ('colonel');

insert into officer(name, rank_id, since) values ('Ivan', 1, '2018-01-01');
insert into officer(name, rank_id, since) values ('Boris', 2, '2014-01-01');
insert into officer(name, rank_id, since) values ('Petr', 3, '2009-01-01');
insert into officer(name, since) values ('Vasya', '2020-01-01');
insert into officer(name, since) values ('Anya', '2020-01-01');

select o.name, r.name, o.since from officer as o join rank as r on o.rank_id = r.id;
select o.name as Имя, r.name as Звание, o.since as "В службе с" from officer as o join rank as r on o.rank_id = r.id;
select o.name as Имя, r.name as Звание, o.since as "В службе с" from officer as o join rank as r on o.rank_id = r.id where r.name != 'sergeant';
select o.name as Имя, r.name as Звание, o.since as "В службе с" from officer as o join rank as r on o.rank_id = r.id where o.since < '2010-01-01';
