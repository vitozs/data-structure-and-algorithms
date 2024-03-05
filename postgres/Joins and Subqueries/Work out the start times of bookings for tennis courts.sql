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

--Seleciona apenas TC1 e TC2 no intervalo de datas