--exercicio 1 : Retrieve the start times of members' bookings
select starttime 
from cd.bookings as b
join cd.members as m
on b.memid = m.memid
where m.surname ='Farrell' and firstname = 'David'

--exercicio 2 : Work out the start times of bookings for tennis courts
select b.starttime as start, f.name 
from cd.bookings as b
join cd.facilities as f
on f.facid = b.facid
where 
f.name in ('Tennis Court 2', 'Tennis Court 1') and
b.starttime >= '2012-09-21' and 
b.starttime < '2012-09-22'
order by
b.starttime

--exercicio 3 : Produce a list of all members who have recommended another member
select distinct m.firstname, m.surname
from cd.members as m
inner join cd.members as r
on r.recommendedby = m.memid
order by m.surname, m.firstname

--exercicio 4 : Produce a list of all members, along with their recommender
select  r.firstname memfname, r.surname memscname, m.firstname recfname, m.surname recsname
from cd.members m
right join cd.members r
on m.memid = r.recommendedby
order by memscname, memfname

--exercicio 5 : Produce a list of all members who have used a tennis court
select distinct m.firstname || ' ' || m.surname as member, f.name as facility
	from cd.members as m
inner join cd.bookings as b
	on m.memid = b.memid
inner join cd.facilities as f
	on b.facid = f.facid
where f.name in ('Tennis Court 1', 'Tennis Court 2')
order by member, facility

--exercicio 6 : Produce a list of costly bookings
select m.firstname || ' ' || m.surname as member, f.name as facility,
case
	when m.memid = 0 then
		b.slots * f.guestcost
	else 
		b.slots * f.membercost
end as cost
    from cd.members as m
        join cd.bookings as b
    on m.memid = b.memid
        join cd.facilities as f
    on b.facid = f.facid
where b.starttime >= '2012-09-14' and
b.starttime < '2012-09-15' and 
((m.memid = 0 and b.slots * f.guestcost >30) or (m.memid != 0 and b.slots * f.membercost > 30))

		
	

--exercicio 7 : Produce a list of all members, along with their recommender, using no joins.
select distinct m.firstname || ' ' || m.surname as member, 

  (select r.firstname || ' ' || r.surname as recommender
 		from cd.members as r 
   		where r.memid = m.recommendedby
  )
	from 
		cd.members as m
order by member;

--exercicio 8 : Produce a list of costly bookings, using a subquery
select member, facility, cost from (
	select 
		mems.firstname || ' ' || mems.surname as member,
		facs.name as facility,
		case
			when mems.memid = 0 then
				bks.slots*facs.guestcost
			else
				bks.slots*facs.membercost
		end as cost
		from
			cd.members mems
			inner join cd.bookings bks
				on mems.memid = bks.memid
			inner join cd.facilities facs
				on bks.facid = facs.facid
		where
			bks.starttime >= '2012-09-14' and
			bks.starttime < '2012-09-15'
	) as bookings
	where cost > 30
order by cost desc;  

