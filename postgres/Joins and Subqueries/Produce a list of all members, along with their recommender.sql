select  r.firstname memfname, r.surname memscname, m.firstname recfname, m.surname recsname
from cd.members m
right join cd.members r
on m.memid = r.recommendedby
order by memscname, memfname



/*
    select mems.firstname as memfname, mems.surname as memsname, recs.firstname as recfname, recs.surname as recsname
	from 
		cd.members mems
		left outer join cd.members recs
			on recs.memid = mems.recommendedby
    order by memsname, memfname;     
*/