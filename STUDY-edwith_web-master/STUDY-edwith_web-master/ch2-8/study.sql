[cmd]
mysql -uroot -p

[mysql v8.0 shell]
create user 'user'@'localhost' identified by 'password';
grant all on db.* to 'user'@'localhost';
flush privileges;

[cmd]
mysql -h127.0.0.1 -uuser -p db

[mysql v8.0 shell]
select version(), current_date;
show databases;

select * from department;
select empno, name, job from employee;
select empno as 사번, name as 이름, job as 직업 from employee;
SELECT concat( empno, '-', deptno) AS '사번-부서번호' FROM employee;
select empno as 사번, name as 이름, job as 직업 from employee order by 이름;
select name, hiredate from employee where hiredate < '1981-01-01';
select name, deptno from employee where deptno in (10, 30);
select name, job from employee where name like '%A%';
SELECT deptno, AVG(salary) , SUM(salary) FROM employee group by deptno;

insert into ROLE (role_id, description) values ( 200, 'CEO');
update ROLE set description = 'CTO' where role_id = 200;

CREATE TABLE EMPLOYEE2(   
    empno      INTEGER NOT NULL PRIMARY KEY,  
    name       VARCHAR(10),   
    job        VARCHAR(9),   
    boss       INTEGER,   
    hiredate   VARCHAR(12),   
    salary     DECIMAL(7, 2),   
    comm       DECIMAL(7, 2),   
    deptno     INTEGER);

alter table 테이블명 add  필드명 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT];
alter table 테이블명 drop 필드명;
alter table 테이블명 change 필드명 새필드명 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT];
alter table 테이블명 rename 변경이름

drop table 테이블이름;
