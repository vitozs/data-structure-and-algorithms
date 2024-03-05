select distinct m.firstname, m.surname
from cd.members as m
inner join cd.members as r
on r.recommendedby = m.memid
order by m.surname, m.firstname


--The SELECT DISTINCT statement is used to return only distinct (different) values.



/*select distinct r.firstname, r.surname
	from cd.members as m
		inner join cd.members as r
		on r.memid = m.recommendedby
order by surname, firstname*/
