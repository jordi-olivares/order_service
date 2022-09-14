CREATE TABLE users
(
    id INTEGER PRIMARY KEY,
    ds_name VARCHAR(100) NOT NULL,
    ds_lastname VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL
);
CREATE SEQUENCE mouse_seq
 START WITH     1
 INCREMENT BY   1;
CREATE TABLE mice
(
	mouse_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('mouse_seq'),
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE,
	model VARCHAR(100) NOT NULL
);
CREATE SEQUENCE monitor_seq
 START WITH     1
 INCREMENT BY   1;
CREATE TABLE monitors
(
	monitor_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('monitor_seq'),
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE,
	model VARCHAR(100) NOT NULL
);
CREATE SEQUENCE keyboard_seq
 START WITH     1
 INCREMENT BY   1;
CREATE TABLE keyboards
(
	keyboard_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('keyboard_seq'),
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE,
	model VARCHAR(100) NOT NULL
);
CREATE SEQUENCE order_seq
 START WITH     1
 INCREMENT BY   1;
CREATE TABLE orders
(
	order_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('order_seq'),
	description VARCHAR(100) NOT NULL
);
--
CREATE SEQUENCE computer_seq
 START WITH     1
 INCREMENT BY   1;
CREATE TABLE computers
(
	computer_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('computer_seq'),
	keyboard_id INTEGER NOT NULL REFERENCES keyboards (keyboard_id),
	mouse_id INTEGER NOT NULL REFERENCES mice (mouse_id),
	monitor_id INTEGER NOT NULL REFERENCES monitors (monitor_id),
	order_id INTEGER NOT NULL REFERENCES orders (order_id),
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE
);
