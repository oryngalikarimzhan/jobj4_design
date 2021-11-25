insert into role(name) values ('security');
insert into role(name) values ('office manager');
insert into role(name) values ('clerk');
insert into role(name) values ('sales manager');

insert into users(name, role_id) values ('Bob', 1);
insert into users(name, role_id) values ('Oryngali', 2);
insert into users(name, role_id) values ('Nurym', 3);
insert into users(name, role_id) values ('Erlan', 4);

insert into rules(name) values ('manage');
insert into rules(name) values ('sale');
insert into rules(name) values ('consult');
insert into rules(name) values ('solve issue');
insert into rules(name) values ('arrange meeting');
insert into rules(name) values ('protect');
insert into rules(name) values ('keep safety');

insert into role_rules(role_id, rule_id) values (1, 7);
insert into role_rules(role_id, rule_id) values (1, 8);
insert into role_rules(role_id, rule_id) values (2, 4);
insert into role_rules(role_id, rule_id) values (2, 2);
insert into role_rules(role_id, rule_id) values (2, 6);
insert into role_rules(role_id, rule_id) values (3, 4);
insert into role_rules(role_id, rule_id) values (3, 5);
insert into role_rules(role_id, rule_id) values (4, 2);
insert into role_rules(role_id, rule_id) values (4, 3);

insert into category(name) values ('client servise');
insert into category(name) values ('client issue');
insert into category(name) values ('assignment');
insert into category(name) values ('request');

insert into state(name) values ('pending');
insert into state(name) values ('done');

insert into item(description, user_id, category_id, state_id) values ('send an order', 3, 1, 1);
insert into item(description, user_id, category_id, state_id) values ('make project', 2, 3, 2);
insert into item(description, user_id, category_id, state_id) values ('sale', 4, 1, 2);
insert into item(description, user_id, category_id, state_id) values ('send a message', 3, 4, 1);

insert into comments(comment, item_id) values ('ok', 1);
insert into comments(comment, item_id) values ('3 package', 1);
insert into comments(comment, item_id) values ('ok', 2);
insert into comments(comment, item_id) values ('ok', 3);


 







