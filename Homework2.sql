/*
2.1 TASK 1 - select all records from employee table
*/

SELECT * FROM EMPLOYEE;

/*
2.1 TASK 2 - select all records from employee table where last name is King
*/

SELECT * FROM EMPLOYEE WHERE UPPER(LASTNAME) LIKE UPPER('King');

/*
2.1 TASK 3 - select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
*/

SELECT * FROM EMPLOYEE WHERE UPPER(FIRSTNAME) LIKE UPPER('Andrew') AND REPORTSTO = NULL;

/*
2.2 TASK 1 - select all albums in Album table and sort result set in descending order by title
*/

SELECT * FROM ALBUM ORDER BY TITLE DESC;

/*
2.2 TASK 2 - select first name from Customer and sort result set in ascending order by city
*/

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

/*
2.3 TASK 1 - insert two new records into Genre table  
*/