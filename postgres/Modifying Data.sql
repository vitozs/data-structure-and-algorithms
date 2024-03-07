--exercicio 1 : Insert some data into a table
insert into cd.facilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values (9,'Spa', 20, 30, 100000, 800);

--exercicio 2 : Insert multiple rows of data into a table
insert into cd.facilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) 
values (9,'Spa', 20, 30, 100000, 800),
(10,'Squash Court 2', 3.5, 17.5, 5000, 80);

--exercicio 3 : Insert calculated data into a table
insert into cd.facilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) 
values ((select max(facid) from cd.facilities) + 1,'Spa', 20, 30, 100000, 800);

--exercicio 4 : Update some existing data
update cd.facilities set initialoutlay	= 10000 where facid = 1;

--exercicio 5 : Update multiple rows and columns at the same time
update cd.facilities set membercost = 6, guestcost = 30 where facid in (0,1);

--exercicio 6 : Update a row based on the contents of another row
update cd.facilities set 
membercost = ((select membercost from cd.facilities where facid = 0)*0.1 + (select membercost from cd.facilities where facid = 1)), 
guestcost = ((select guestcost from cd.facilities where facid = 0)*0.1 + (select guestcost from cd.facilities where facid = 1))
where facid =1;

--exercicio 7 : Delete all bookings
delete from cd.bookings;

--exercicio 8 : Delete a member from the cd.members table
Delete from cd.members where memid = 37;

--exercicio 9 : Delete based on a subquery
delete from cd.members 
where memid not in (select memid from cd.bookings)