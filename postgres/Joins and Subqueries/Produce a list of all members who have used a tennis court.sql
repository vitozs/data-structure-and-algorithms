select distinct m.firstname || ' ' || m.surname as member, f.name as facility
	from cd.members as m
inner join cd.bookings as b
	on m.memid = b.memid
inner join cd.facilities as f
	on b.facid = f.facid
where f.name in ('Tennis Court 1', 'Tennis Court 2')
order by member, facility

/*The expression || ' ' || in PostgreSQL is used to concatenate an empty space (' ') with a string or column value. 
It results in adding a space before and after the original value. For example, if you have a column named name with the value 'John', the expression name || ' ' 
would yield 'John '.*/