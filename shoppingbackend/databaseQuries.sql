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
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(10),
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);

INSERT into user_detail
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Devi', 'Patnaik', 'ADMIN', true, 'admin', 'devi.patnaik.nit@gmail.com', '9148749525');

INSERT into user_detail 
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Ratan', 'Tata', 'SUPPLIER', true, 'tcs', 'ratan.tata@gmail.com', '9990009999');

INSERT into user_detail 
(first_name,last_name,role,enabled,password,email,contact_number) 
VALUES ('Sachin', 'Tendulkar', 'SUPPLIER', true, 'cricket', 'sachin.tendulkar@gmail.com', '7772227777');


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