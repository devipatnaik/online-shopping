CREATE TABLE CATEGORY (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(250),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(id)
);

INSERT into Category(name,description,image_url,is_active)VALUES('Laptop', 'This is the description for Laptop Category!', 'CAT_1.png', true);
INSERT into Category(name,description,image_url,is_active)VALUES('Television', 'This is the description for Television Category!', 'CAT_2.png', true);
INSERT into Category(name,description,image_url,is_active)VALUES('Mobile', 'This is the description for Mobile Category!', 'CAT_3.png', true);

CREATE TABLE user_detail (

	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT into user_detail
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Devi', 'Patnaik', 'ADMIN', true, 'admin', 'devipatnaik.nit@gmail.com', '9148749525');

INSERT into user_detail 
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Ratan', 'Tata', 'SUPPLIER', true, 'ratan', 'ratan.tata@gmail.com', '9990009999');

INSERT into user_detail 
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Sachin', 'Tendulkar', 'USER', true, 'sachin', 'sachin.tendulkar@gmail.com', '9880227979');

INSERT into user_detail 
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Sujata', 'Patnaik', 'USER', true, 'sujata', 'sujatadas99@gmail.com', '9937379074');

----- BCrypte
INSERT into user_detail
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Devi', 'Patnaik', 'ADMIN', true, '$2b$10$KqV9MzhiJFip4MUDWIz5wO1DE9Im3iwt2SD5K6AjKzmUbNNefDpoS', 'devipatnaik.nit@gmail.com', '9148749525');

INSERT into user_detail 
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Ratan', 'Tata', 'SUPPLIER', true, '$2b$10$p0ZtA40ZWaShFywB0ddsq.3/RGPsiiBTGEcBGDJy9.L1sRSFBeDQ2', 'ratan.tata@gmail.com', '9990009999');

INSERT into user_detail 
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Sachin', 'Tendulkar', 'ADMIN', true, '$2b$10$KbcATdSq8uZrX0YI5AKwWuT5aiFNutObRnqIH/zPFHX6rBW.Nqeqq', 'sachin.tendulkar@gmail.com', '9880227979');



CREATE TABLE Product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
	
);

INSERT into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PRDABC123DEFX', 'iPhone 5S', 'apple', 'This is one of the best phone available in the market right now!!', '18000', 5, true, 3, 2);

INSERT into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by Samsung!!', '32000', 2, true, 3, 3);

INSERT into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android phone available in the market right now!!', '57000', 5, true, 3, 2);

INSERT into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PRDMNO123PQRX', 'Macbook Pro', 'apple', 'This is one of the best Laptop available in the market right now!!', '88000', 3, true, 1, 2);

INSERT into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PRDABC123XZCX', 'Dell Insprion', 'dell', 'This is one of the ever green Laptop available in the market right now!!', '41000', 5, true, 1, 3);

/* UPDATE 
UPDATE product SET is_active= 'TRUE' WHERE ID = 1; */

CREATE TABLE Address (
	id IDENTITY,
	address_line_one VARCHAR(255),
	address_line_two VARCHAR(255),
	city VARCHAR(255),
	state VARCHAR(15),
	country VARCHAR(255),
	postal_code VARCHAR(255),
	billing BOOLEAN NOT NULL,
	shipping BOOLEAN NOT NULL,
	user_id INT,
	CONSTRAINT pk_address_id PRIMARY KEY(id),
	CONSTRAINT fk_address_id FOREIGN KEY (user_id) REFERENCES user_detail(id)
);

INSERT into Address(user_id,address_line_one,address_line_two,city,state,country,postal_code,billing,shipping)
VALUES (1, '#861,4th Floor,4th Main Cross', 'Chodeswari Layout,Tulasi Theater Road', 'Banglore', 'Karnataka', 'India', '560037', 'TRUE','FALSE');

INSERT into Address(user_id,address_line_one,address_line_two,city,state,country,postal_code,billing,shipping)
VALUES (1, '#335,2nd Floor,9th Cross', 'Sanjya Nagar', 'Banglore', 'Karnataka', 'India', '560037', 'FALSE','TRUE');

CREATE TABLE Cart (
	id IDENTITY,
	cart_lines INT,
	grand_total double,
	user_id INT,
	CONSTRAINT pk_cart_id PRIMARY KEY(id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user_detail(id)
);

show columns from table_name

INSERT into Cart(user_id,grand_total,cart_lines)
VALUES (1, 0, 0);


