Insert into Role (id,name,created_date,last_updated_date) values (20001,'Admin',sysdate(),sysdate());
Insert into Role (id,name,created_date,last_updated_date) values (20002,'Developer',sysdate(),sysdate());
Insert into Role (id,name,created_date,last_updated_date) values (20003,'Guest',sysdate(),sysdate());


Insert into User (id,name,roleid,created_date,last_updated_date) values (10006,'Prashant Gupta',20001,sysdate(),sysdate());
Insert into User (id,name,roleid,created_date,last_updated_date) values (10007,'Amit Gupta',20001,sysdate(),sysdate());
Insert into User (id,name,roleid,created_date,last_updated_date) values (10008,'Rahul Gupta',20002,sysdate(),sysdate());
Insert into User (id,name,roleid,created_date,last_updated_date) values (10009,'Ayaansh Gupta',20003,sysdate(),sysdate());