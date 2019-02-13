Insert into Role (id,name,created_date,last_updated_date) values (20001,'Admin',sysdate(),sysdate());
Insert into Role (id,name,created_date,last_updated_date) values (20002,'Developer',sysdate(),sysdate());
Insert into Role (id,name,created_date,last_updated_date) values (20003,'Guest',sysdate(),sysdate());


Insert into User (id,name,email,roleid,created_date,last_updated_date) values (10006,'Prashant Gupta','prashant.gupta@orange.com',20001,sysdate(),sysdate());
Insert into User (id,name,email,roleid,created_date,last_updated_date) values (10007,'Amit Gupta','amit.gupta@orange.com',20001,sysdate(),sysdate());
Insert into User (id,name,email,roleid,created_date,last_updated_date) values (10008,'Rahul Gupta','rahul.gupta@orange.com',20002,sysdate(),sysdate());
Insert into User (id,name,email,roleid,created_date,last_updated_date) values (10009,'Ayaansh Gupta','ayaansh.gupta@orange.com',20003,sysdate(),sysdate());

Insert Into Order1 (id,description,created_date,last_updated_date,) values(40001,'Order1',sysdate(),sysdate());
Insert Into Order1 (id,description,created_date,last_updated_date,) values(40002,'Order2',sysdate(),sysdate());
Insert Into Order1 (id,description,created_date,last_updated_date,) values(40003,'Order3',sysdate(),sysdate());

Insert Into Note (id,title,description,created_date,last_updated_date,Order_id) values(30001,'note1','note1-desc',sysdate(),sysdate(),40001);
Insert Into Note (id,title,description,created_date,last_updated_date,Order_id) values(30002,'note2','note2-desc',sysdate(),sysdate(),40001);
Insert Into Note (id,title,description,created_date,last_updated_date,Order_id) values(30003,'note3','note3-desc',sysdate(),sysdate(),40002);
Insert Into Note (id,title,description,created_date,last_updated_date,Order_id) values(30004,'note4','note3-desc',sysdate(),sysdate(),40003);