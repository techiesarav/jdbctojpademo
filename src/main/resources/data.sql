insert into person values(100,'raj','banglore',sysdate());
insert into person values(101,'sarav','chennai',sysdate());
insert into person values(102,'viji','snkl',sysdate());

insert into course values(10000L,'JPA in Depth',sysdate(),sysdate());
insert into course values(10001L,'kick Microservices',sysdate(),sysdate());
insert into course values(10002L,'Angular Beginer',sysdate(),sysdate());

insert into passport(id,number) values(3000,'E00E01');
insert into passport(id,number) values(3001,'E00E02');
insert into passport(id,number) values(3002,'E00E03');

insert into student(id,name,passport_id) values(2000,'indu',3000);
insert into student(id,name,passport_id) values(2001,'sarav',3000);
insert into student(id,name,passport_id) values(2002,'uma',3001);

insert into review values(4000,4,'spring in depth',10000L);
insert into review values(4001,4,'jpa in depth',10000L);
insert into review values(4002,4,'microservices in depth',10001L);

insert into student_course(student_id,course_id) values(2000,10000L);
insert into student_course(student_id,course_id) values(2000,10001L);
insert into student_course(student_id,course_id) values(2001,10000L);