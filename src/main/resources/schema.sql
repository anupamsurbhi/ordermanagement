
CREATE TABLE pizza (
    code INT8 PRIMARY KEY,
    description VARCHAR(128),
    price DECIMAL(20, 2),
    inventory INT8,
    lastchangets TIMESTAMP
);

insert into pizza(code,description,price,inventory,lastchangets) values (1001,'Large - Hand Tossed - Alfardo Sause ',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1002,'Medium - Hand Tossed - Alfardo Sause ',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1003,'Small - Hand Tossed - Alfardo Sause ',7.50,130,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values (1004,'Large - Hand Tossed - BBQ Sause',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1005,'Medium - Hand Tossed - BBQ Sause ',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1006,'Small - Hand Tossed - BBQ Sause',7.50,130,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values (1007,'Large - Hand Tossed - Tomato Sause',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1008,'Medium - Hand Tossed - Tomato Sause',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1009,'Small - Hand Tossed - Tomato Sause',7.50,130,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values (1010,'Large - Hand Tossed - Garlic White Sause  ',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1011,'Medium - Hand Tossed - Garlic White  Sause ',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1012,'Small - Hand Tossed- Garlic White  Sause ',7.50,130,CURRENT_TIMESTAMP);

insert into pizza(code,description,price,inventory,lastchangets) values (1013,'Large - Thin Crust - Alfardo Sause ',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1014,'Medium - Thin Crust - Alfardo Sause ',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1015,'Small -  Thin Crust - Alfardo Sause ',7.50,130,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values (1016,'Large -  Thin Crust  - BBQ Sause',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1017,'Medium -  Thin Crust  - BBQ Sause ',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1018,'Small -  Thin Crust - BBQ Sause',7.50,130,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values (1019,'Large -  Thin Crust -Tomato Sause',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1020,'Medium -  Thin Crust - Tomato Sause',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1021,'Small -  Thin Crust -Tomato Sause',7.50,130,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values (1022,'Large -  Thin Crust - Garlic White Sause  ',10.25,100,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1023,'Medium -  Thin Crust -Garlic White  Sause ',9.25,150,CURRENT_TIMESTAMP);
insert into pizza(code,description,price,inventory,lastchangets) values(1024,'Small -  Thin Crust - Garlic White  Sause ',7.50,130,CURRENT_TIMESTAMP);

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
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3001,'`0% off deals on total',10.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3002,'20% off deals on total',20.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3003,'30% off deals on total',30.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3004,'40% off deals on total',40.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3005,'50% off deals on total',50.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3006,'60% off deals on total',60.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);
insert into deals (code,description, percent,dealstartdate,dealenddate,lastchangets) values(3007,'70% off deals on total',70.00,'2019-01-01','2019-12-31',CURRENT_TIMESTAMP);

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

insert into orders (ORDERNUMBER,FIRSTNAME,LASTNAME,FINALAMOUNT,BEFOREDISCOUNT,DISCOUNT,DEALCODE,ORDERDATE,ORDERTIME,LASTCHANGETS) 
values (90001,'FastSpring', 'coorporate', 100.00,200.00,100.00,3001,CURRENT_DATE(),CURRENT_TIME(),CURRENT_TIMESTAMP);
