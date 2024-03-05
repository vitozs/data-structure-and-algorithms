select surname 
from cd.members
group by surname
order by surname ASC
limit 10