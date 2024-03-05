select name, 
case when(monthlymaintenance > 100) then
	'expensive'
else
	'cheap'
end as cost
from cd.facilities 

/*The CASE expression goes through conditions and returns a value when the first condition is met (like an if-then-else statement).

Once a condition is true, it will stop reading and return the result. If no conditions are true, it returns the value in the ELSE clause.

If there is no ELSE part and no conditions are true, it returns NULL.*/