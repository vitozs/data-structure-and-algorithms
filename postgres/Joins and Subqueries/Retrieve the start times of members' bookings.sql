select starttime 
from cd.bookings as b
join cd.members as m
on b.memid = m.memid
where m.surname ='Farrell' and firstname = 'David'