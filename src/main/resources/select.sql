INSERT INTO Person(name, age) VALUES('Tom', 35);
INSERT INTO Person(name, age) VALUES('Bob', 52);
INSERT INTO Person(name, age) VALUES('Katy', 14);


INSERT INTO Item(person_id, item_name) VALUES(1, 'Book');
INSERT INTO Item(person_id, item_name) VALUES(1, 'AirPods');
INSERT INTO Item(person_id, item_name) VALUES(2, 'Iphone');
INSERT INTO Item(person_id, item_name) VALUES(3, 'Kindle');
INSERT INTO Item(person_id, item_name) VALUES(3, 'TV');
INSERT INTO Item(person_id, item_name) VALUES(3, 'PlayStation');


SELECT * FROM Person;
SELECT * FROM Item;