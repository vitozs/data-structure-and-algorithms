select distinct m.firstname ||''|| m.surname as member, 

  (select r.firstname ||''|| r.surname as recommender
 		from cd.members as r 
   		where r.memid = m.recommendedby
  )
	from 
		cd.members as m
order by member;