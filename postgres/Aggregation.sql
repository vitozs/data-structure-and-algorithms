--exercicio 1 : Count the number of facilities
select COUNT(*) as count from cd.facilities;

--exercicio 2 : Count the number of expensive facilities
select count(*) from cd.facilities where guestcost >= 10

--exercicio 3 : Count the number of recommendations each member makes.
select recommendedby, count(*) 
from cd.members 
where recommendedby is not null
group by recommendedby
order by recommendedby

--exercicio 4 : List the total slots booked per facility
select facid, sum(slots) as "Total Slots"
from cd.bookings 
group by facid
order by facid;

--exercicio 5 : List the total slots booked per facility in a given month
select facid, sum(slots) as "Total Slots"
from cd.bookings 
where starttime >= '2012-09-01' and starttime < '2012-10-01'
group by facid
order by sum(slots);

--exercicio 6 : List the total slots booked per facility per month
select facid, extract(month from starttime) as month, sum(slots) as "Total Slots"
from cd.bookings 
where extract(year from starttime) = '2012'
group by facid, month
order by facid, month;

/*A função PostgreSQL EXTRACT() é usada para consultar campos associados à data e hora, como ano, mês e dia, a partir de um valor de data / hora.*/

--exercicio 7 : Find the count of members who have made at least one booking
select  count(distinct memid) from cd.bookings

--exercicio 8 : List facilities with more than 1000 slots booked
select facid, sum(slots) as  "Total Slots"
from cd.bookings
group by facid
having sum(slots) > 1000
order by facid

--exercicio 11 : Output the facility id that has the highest number of slots booked
select facid, sum(slots) as "Total Slots"
from cd.bookings
group by facid
order by sum(slots) desc
limit 1

--exercicio 12 : List the total slots booked per facility per month, part 2
select facid, extract(month from starttime) as month, sum(slots) as slots
from cd.bookings 
where extract(year from starttime) = '2012'
group by rollup(facid, month)
order by facid, month;

/*In PostgreSQL, the ROLLUP clause is a parameter of the GROUP BY 
clause that allows you to generate a report on multiple dimensions in one query. 
In some specific cases, the ROLLUP can simplify GROUPING SETS.*/

--exercicio 14 : List each member's first booking after September 1st 2012
select m.surname, m.firstname, m.memid, min(b.starttime) as starttime
	from cd.members m
	join cd.bookings b
		on m.memid = b.memid
	where starttime >= '2012-09-01'
	group by m.surname, m.firstname, m.memid
order by m.memid;

--exercicio 16 : Produce a numbered list of members
select (select count(*) from cd.members) as count, firstname, surname
from cd.members
order by joindate

