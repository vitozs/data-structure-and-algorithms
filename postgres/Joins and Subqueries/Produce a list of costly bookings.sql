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

		
	