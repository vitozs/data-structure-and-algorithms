select surname 
from cd.members
union 
select name 
from cd.facilities

/*The UNION operator allows you to combine the result sets of two or more SELECT statements into a single result set.*/