--exercicio 1 : Format the names of members
select surname ||', '|| firstname as name from cd.members

--exercicio 2 : Find facilities by a name prefix
select * from cd.facilities where name LIKE 'Tennis%'

--exercicio 3 : Perform a case-insensitive search
select * from cd.facilities where upper(name) LIKE 'TENNIS%'

--exercicio 4 : Find telephone numbers with parentheses
select memid, telephone 
from cd.members
where telephone  ~ '[()]' --like "(%"
order by memid;

--exercicio 5 : Pad zip codes with leading zeroes
select lpad(cast(zipcode as char(5)),5,'0') zip from cd.members order by zip          

--exercicio 6 : Count the number of members whose surname starts with each letter of the alphabet

