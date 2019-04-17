CREATE TABLE category(


  id IDENTITY,
  name VARCHAR(50),
  description VARCHAR(255),
  image_url VARCHAR(50),
  is_active BOOLEAN ,
  
  
  CONSTRAINT pk_category_id PRIMARY KEY (id)


);

INSERT INTO category (name, description, image_url, is_active) VALUES ('Laptop', 'This is Laptop category', 'CAT_1.png', true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('Television', 'This is Television category', 'CAT_2.png', true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('Mobile', 'This is Mobile category', 'CAT_3.png', true);

CREATE TABLE user_detail (
   id IDENTITY,
   first_name VARCHAR(50),
   last_name VARCHAR(50),
   role VARCHAR(50),
   enabled BOOLEAN,
   password VARCHAR(50),
   email VARCHAR(100),
   contact_number VARCHAR(15),
   CONSTRAINT pk_user_id PRIMARY KEY (id)

);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Virat', 'Kohli', 'ADMIN', true, 'admin', 'vk@gmail.com', '8888888888');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ravindra', 'jadeja', 'SUPPLIER', true, '12345', 'rj@gmail.com', '9999999999');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, '12345', 'ra@gmail.com', '7777777777');


CREATE TABLE product (
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
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
  CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)

);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES('PRDABC123DEFX', 'iphone 5s', 'apple', 'This is one of the best available iphone in the market', 18000.00, 5, true, 3, 2, 0, 0);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES('PRDABC456DEFX', 'Samsung galaxy', 'Samsung', 'This is one of the best available Samsung in the market', 20000.00, 2, true, 3, 3, 0, 0);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES('PRDABC789DEFX', 'Google pixel', 'Google', 'This is one of the best available Google pixel in the market', 19000.00, 5, true, 3, 2, 0, 0);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES('PRDABC321DEFX', 'Macbook', 'apple', 'This is one of the best available Macbook in the market', 38000.00, 3, true, 1, 2, 0, 0);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES('PRDABC654DEFX', 'Dell', 'Dell', 'This is one of the best available Dell in the market', 34000.00, 5, true, 1, 3, 0, 0);

























