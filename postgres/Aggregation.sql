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

--exercicio 9 : Produce a numbered list of members
select row_number() over(order by joindate), firstname, surname
	from cd.members
order by joindate        

--exercicio 10 : Output the facility id that has the highest number of slots booked, again
select facid, total from (
	select facid, sum(slots) total, rank() over (order by sum(slots) desc) rank
        	from cd.bookings
		group by facid
	) as ranked
	where rank = 1       

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

--exercicio 13 : Rank members by (rounded) hours used
select firstname, surname,
	((sum(bks.slots)+10)/20)*10 as hours,
	rank() over (order by ((sum(bks.slots)+10)/20)*10 desc) as rank

	from cd.bookings bks
	inner join cd.members mems
		on bks.memid = mems.memid
	group by mems.memid
order by rank, surname, firstname;   


--exercicio 14 : List each member's first booking after September 1st 2012
select m.surname, m.firstname, m.memid, min(b.starttime) as starttime
	from cd.members m
	join cd.bookings b
		on m.memid = b.memid
	where starttime >= '2012-09-01'
	group by m.surname, m.firstname, m.memid
order by m.memid;

--exercicio 15 : Find the top three revenue generating facilities
select name, rank from (
	select facs.name as name, rank() over (order by sum(case
				when memid = 0 then slots * facs.guestcost
				else slots * membercost
			end) desc) as rank
		from cd.bookings bks
		inner join cd.facilities facs
			on bks.facid = facs.facid
		group by facs.name
	) as subq
	where rank <= 3
order by rank;        

--exercicio 16 : Produce a numbered list of members
select (select count(*) from cd.members) as count, firstname, surname
from cd.members
order by joindate

--exercicio 17 : Classify facilities by value
select name, case when class=1 then 'high'
		when class=2 then 'average'
		else 'low'
		end revenue
	from (
		select facs.name as name, ntile(3) over (order by sum(case
				when memid = 0 then slots * facs.guestcost
				else slots * membercost
			end) desc) as class
		from cd.bookings bks
		inner join cd.facilities facs
			on bks.facid = facs.facid
		group by facs.name
	) as subq
order by class, name;      

--exercicio 18 : Calculate the payback time for each facility
select 	facs.name as name,
	facs.initialoutlay/((sum(case
			when memid = 0 then slots * facs.guestcost
			else slots * membercost
		end)/3) - facs.monthlymaintenance) as months
	from cd.bookings bks
	inner join cd.facilities facs
		on bks.facid = facs.facid
	group by facs.facid
order by name;          


--exercicio 19 : Calculate a rolling average of total revenue
select 	dategen.date,
	(
		-- correlated subquery that, for each day fed into it,
		-- finds the average revenue for the last 15 days
		select sum(case
			when memid = 0 then slots * facs.guestcost
			else slots * membercost
		end) as rev

		from cd.bookings bks
		inner join cd.facilities facs
			on bks.facid = facs.facid
		where bks.starttime > dategen.date - interval '14 days'
			and bks.starttime < dategen.date + interval '1 day'
	)/15 as revenue
	from
	(
		-- generates a list of days in august
		select 	cast(generate_series(timestamp '2012-08-01',
			'2012-08-31','1 day') as date) as date
	)  as dategen
order by dategen.date;      

--exercicio 20 : Calculate a rolling average of total revenue
