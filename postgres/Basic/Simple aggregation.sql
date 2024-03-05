select joindate as latest
from cd.members
order by joindate DESC
limit 1

/*select max(joindate) as latest
	from cd.members; */