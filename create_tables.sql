CREATE TABLE users
(
    id INTEGER PRIMARY KEY,
    ds_name SERIAL VARCHAR(100) NOT NULL,
    ds_lastname VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL
);
CREATE TABLE mice
(
	mouse_id INTEGER PRIMARY KEY,
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE,
	model VARCHAR(100) NOT NULL
);
CREATE TABLE monitors
(
	monitor_id INTEGER PRIMARY KEY,
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE,
	model VARCHAR(100) NOT NULL
);
CREATE TABLE keyboards
(
	keyboard_id INTEGER PRIMARY KEY,
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE,
	model VARCHAR(100) NOT NULL
);
CREATE TABLE services
(
	service_id INTEGER PRIMARY KEY,
	description VARCHAR(100) NOT NULL
);
CREATE TABLE computers
(
	computer_id INTEGER PRIMARY KEY,
	keyboard_id INTEGER NOT NULL REFERENCES keyboards (keyboard_id),
	mouse_id INTEGER NOT NULL REFERENCES mice (mouse_id),
	monitor_id INTEGER NOT NULL REFERENCES monitors (monitor_id),
	brand VARCHAR(100) NOT NULL,
	serial_number INTEGER NOT NULL UNIQUE
);
CREATE TABLE orders
(
	order_id INTEGER PRIMARY KEY,
	service_id INTEGER NOT NULL REFERENCES services (service_id),
	computer_id INTEGER NOT NULL REFERENCES computers(computer_id)
);