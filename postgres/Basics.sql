--exercicio 1 : Retrieve everything from a table
select * from cd.facilities

--exercicio 2 : Retrieve specific columns from a table
select name, membercost 
from cd.facilities

--exercicio 3 : Control which rows are retrieved - part 1
select * from cd.facilities where membercost > 0

--exercicio 4 : Control which rows are retrieved - part 2
select facid, name, membercost, monthlymaintenance from cd.facilities where membercost > 0 and membercost < (monthlymaintenance / 50)

--exercicio 5 : Basic string searches
select * from cd.facilities where name like '%Tennis%'

--exercicio 6 : Matching against multiple possible values
select * from cd.facilities where facid in (1,5);

--exercicio 7 : Classify results into buckets
select name, 
case when(monthlymaintenance > 100) then
	'expensive'
else
	'cheap'
end as cost
from cd.facilities 

--exercicio 8 : Working with dates

select memid, surname, firstname, joindate
from cd.members
where joindate >= '2012-09-01'

--exercicio 9 : Removing duplicates, and ordering results
select surname 
from cd.members
group by surname
order by surname ASC
limit 10


