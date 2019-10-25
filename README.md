# ca-10072019
SQL and Unit testing assessment.


1. I created a database schema on AWS, with constraints: 

CREATE TABLE FRUIT (
FRUIT_ID number(3) PRIMARY KEY,
FRUIT_NAME varchar2(200) UNIQUE NOT NULL
);

CREATE TABLE COLOR (
COLOR_ID number(3) PRIMARY KEY,
COLOR_NAME varchar2(200) 
);

CREATE TABLE FRUITXREFCOLOR (
FRUIT_ID number(3) ,
COLOR_ID number(3) 
);

2 . I read the given excell file, named ManualLoadData.xls (using Apache POI library) and  insert the relevant data into the respective tables the (using  JDBC) which I have already created in step. 
	
	The execution will be triggered from main.class file in the following sequence:
		- Read the excell,
			- Created Sheetdata POJO class in order to store the data in a model class.
		- Insert Database
			- While inserting data into the tables dublicate and/or null value insertion is avoided by using if conditions.
		- Select the red fruits,
		- Generate report (TheReport.txt file is generated at project level)
		- Truncate tables (for futher executions).
