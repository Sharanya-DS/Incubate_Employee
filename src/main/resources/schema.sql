CREATE TABLE incubatesoft (
	incubate_id INT PRIMARY KEY, 
	incubate_desc VARCHAR(75)
);

 
insert into incubatesoft values (123, 'First Incubate');


CREATE TABLE organization (
	org_id INT PRIMARY KEY, 
	org_name VARCHAR(75),
	incubate_id INT REFERENCES incubatesoft (incubate_id)
);
                                                                                                  


insert into organization values (1, 'First Organization', 123);
insert into organization values (2, 'Second Organization', 123);
insert into organization values (3, 'Third Organization', 123);


CREATE TABLE employee (
	employee_id INT PRIMARY KEY, 
	employee_name VARCHAR(65), 
	employee_salary NUMERIC(8,2),    
	org_id INT REFERENCES organization (org_id)
);


insert into employee values (1234, 'Jack Black', 2365, 1);
insert into employee values (9876, 'Peter Well', 987, 2);


CREATE TABLE address (
	address_id INT PRIMARY KEY, 
	address_string VARCHAR(65), 
	country VARCHAR(65), 
	pincode VARCHAR(6), 
	employee_id INT REFERENCES employee(employee_id)
);

insert into address values (1, '4 sample street', 'India', 500010, 1234);
insert into address values (2, '234 benjarong street', 'Thailand', 789653, 1234);