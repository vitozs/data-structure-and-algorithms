select firstname, surname, joindate
from cd.members
where joindate = (
    select max(joindate) from cd.members
    )


/*
    select firstname, surname, joindate
    from cd.members
    order by joindate DESC
    limit 1
*/