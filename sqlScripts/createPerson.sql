create table person (
    id serial primary key, 
    personName text,
	birthday date,
	passportNumber int
);
insert into person (personName, birthday, passportNumber) values ('oryngali', '1996-02-09', '351604');
select * from person;

