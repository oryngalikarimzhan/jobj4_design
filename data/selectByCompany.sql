CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'apple');
insert into company(id, name) values (2, 'google');
insert into company(id, name) values (3, 'microsoft');
insert into company(id, name) values (4, 'tesla');
insert into company(id, name) values (5, 'meta');
insert into company(id, name) values (6, 'netflix');
insert into company(id, name) values (7, 'amazon');

insert into person(id, name, company_id) values (1, 'petr', 1);
insert into person(id, name, company_id) values (2, 'misha', 1);
insert into person(id, name, company_id) values (3, 'vanya', 1);
insert into person(id, name, company_id) values (4, 'sasha', 1);
insert into person(id, name, company_id) values (5, 'masha', 2);
insert into person(id, name, company_id) values (6, 'dasha', 2);
insert into person(id, name, company_id) values (7, 'pasha', 2);
insert into person(id, name, company_id) values (8, 'kolya', 2);
insert into person(id, name, company_id) values (9, 'tolya', 3);
insert into person(id, name, company_id) values (10, 'galya', 3);
insert into person(id, name, company_id) values (11, 'ura', 3);
insert into person(id, name, company_id) values (12, 'sanya', 3);
insert into person(id, name, company_id) values (13, 'ulya', 4);
insert into person(id, name, company_id) values (14, 'seryoga', 4);
insert into person(id, name, company_id) values (15, 'borya', 4);
insert into person(id, name, company_id) values (16, 'polya', 4);
insert into person(id, name, company_id) values (17, 'ida', 5);
insert into person(id, name, company_id) values (18, 'maks', 5);
insert into person(id, name, company_id) values (19, 'zhenya', 5);
insert into person(id, name, company_id) values (20, 'volya', 5);
insert into person(id, name, company_id) values (21, 'grisha', 6);
insert into person(id, name, company_id) values (22, 'dima', 6);
insert into person(id, name, company_id) values (23, 'luba', 6);
insert into person(id, name, company_id) values (24, 'nastya', 6);
insert into person(id, name, company_id) values (25, 'vika', 7);
insert into person(id, name, company_id) values (26, 'lena', 7);
insert into person(id, name, company_id) values (27, 'vera', 7);
insert into person(id, name, company_id) values (28, 'tasha', 7);
insert into person(id, name, company_id) values (29, 'stas', 7);
insert into person(id, name, company_id) values (30, 'katya', 6);


/*1. В одном запросе получить

- имена всех person, которые не состоят в компании с id = 5;

- название компании для каждого человека.*/


select p.id, p.name, p.company_id, c.name 
from person as p
join company as c
on p.company_id = c.id
where company_id != 5;



/*2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании 
(нужно учесть, что таких компаний может быть несколько).
*/
select c.name as company_name, count(p.id) as employees
from person as p
join company as c
on c.id = p.company_id
group by c.name
having count(p.name) = 
(
	select count(company_id) from person
	group by company_id
	order by company_id desc
	limit 1
);

