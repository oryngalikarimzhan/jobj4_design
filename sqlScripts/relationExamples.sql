create table animals_class(
    id serial primary key,
    class_name varchar(255)
);

create table animal(
    id serial primary key,
    name varchar(255),
    class_id int references animals_class(id)
);

insert into animals_class(class_name) values ('mammals');
insert into animals_class(class_name) values ('birds');
insert into animals_class(class_name) values ('fish');
insert into animals_class(class_name) values ('amphibia');
insert into animals_class(class_name) values ('reptile');

insert into animal(name, class_id) VALUES ('tiger', 1);
insert into animal(name, class_id) VALUES ('eagle', 2);
insert into animal(name, class_id) VALUES ('shark', 3);
insert into animal(name, class_id) VALUES ('frog', 4);
insert into animal(name, class_id) VALUES ('crocodile', 5);

select * from aniamal;

select * from animals_class where id in (select id from animal);




create table players(
     id serial primary key,
     name varchar(255)
 );
 
 create table olympic_games(
     id serial primary key,
     name varchar(255)
 );
 
 create table players_by_games(
     id serial primary key,
     player_id int references players(id),
     game_id int references games(id)
 );
 
insert into players(name) values ('oryngali');
insert into players(name) values ('saniya');
insert into players(name) values ('usain');
insert into players(name) values ('michael');

insert into olympic_games(name) values ('swimming');
insert into olympic_games(name) values ('sprint');
insert into olympic_games(name) values ('wheightlifting');
insert into olympic_games(name) values ('gimnastics');


insert into players_by_games(player_id, game_id) values (1, 3);
insert into players_by_games(player_id, game_id) values (2, 4);
insert into players_by_games(player_id, game_id) values (3, 2);
insert into players_by_games(player_id, game_id) values (4, 1);



create table nationality(
    id serial primary key,
    name varchar(255)
);

create table person(
    id serial primary key,
    name varchar(255)
);

create table persons_nationality(
    id serial primary key,
	person_id int references person(id) unique,
    nationality_id int references nationality(id) unique
);

insert into nationality(name) values ('kazakh');
insert into nationality(name) values ('russian');
insert into nationality(name) values ('korean');

insert into person(name) values ('oryngali');
insert into person(name) values ('petr');
insert into person(name) values ('viktor');

insert into persons_nationality(person_id, nationality_id) values (1, 1);
insert into persons_nationality(person_id, nationality_id) values (2, 2);
insert into persons_nationality(person_id, nationality_id) values (3, 3);
