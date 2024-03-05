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

/*This answer provides a mild simplification to the previous iteration: in the no-subquery version, 
we had to calculate the member or guest's cost in both the WHERE clause and the CASE statement. 
In our new version, we produce an inline query that calculates the total booking cost for us, 
allowing the outer query to simply select the bookings it's looking for. 
For reference, you may also see subqueries in the FROM clause referred to as inline views.*/