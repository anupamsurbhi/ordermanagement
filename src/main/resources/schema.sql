
CREATE TABLE pizza (
    code INT8 PRIMARY KEY,
    description VARCHAR(128),
    price DECIMAL(20, 2),
    inventory INT8,
    lastchangets TIMESTAMP
);

insert into pizza(code,description,price,inventory,lastchangets) values (1001,'Cheese Pizza Large',5.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1002,'Cheese Pizza Medium',4.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1003,'Cheese Pizza Small',3.50,130,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1004,'Thin Pizza Crust Large',8.99,180,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1005,'Thin Pizza Crust Medium',7.99,40,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1006,'Thin Pizza Crust Small',6.50,80,CURRENT_TIMESTAMP);

CREATE TABLE Toppings (
    code INT8 PRIMARY KEY,
    description VARCHAR(128),
    price DECIMAL(20, 2),
    active VARCHAR(1),
    inventory INT8,
    lastchangets TIMESTAMP
);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2001,'Olives',2.50,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2002,'Onions',1.25,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2003,'Tomato',2.25,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2004,'Spanish',0.75,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2005,'Carrots',3.05,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2006,'Feta Cheese',1.05,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2007,'mix veggies',3.25,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2008,'meat',3.65,'Y',200,CURRENT_TIMESTAMP);
insert into toppings(code,description,price,active,inventory,lastchangets) values(2009,'chicken',5.25,'Y',200,CURRENT_TIMESTAMP);



CREATE TABLE deals (
    code INT8 PRIMARY KEY,
    description VARCHAR(128),
    percent DECIMAL(4, 2),
    dealstartdate DATE,
    dealenddate DATE,
    lastchangets TIMESTAMP
);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3001,'50% off deals on total',50.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3002,'20% off deals on total',20.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3003,'30% off deals on total',30.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3004,'40% off deals on total',40.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);

CREATE TABLE orders (
    ordernumber INT8 PRIMARY KEY,
    firstname VARCHAR(16),
    lastname VARCHAR(16),
    finalamount DECIMAL(20, 2),
    beforediscount DECIMAL(20, 2),
    discount DECIMAL(20, 2),
    dealcode INT8,
    orderdate DATE,
    ordertime TIME,
    lastchangets TIMESTAMP
    );


