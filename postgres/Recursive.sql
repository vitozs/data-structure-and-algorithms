--ex 1 : Find the upward recommendation chain for member ID 27
with recursive recommenders(recommender) as (
	select recommendedby from cd.members where memid = 27
	union all
	select mems.recommendedby
		from recommenders recs
		inner join cd.members mems
			on mems.memid = recs.recommender
)
select recs.recommender, mems.firstname, mems.surname
	from recommenders recs
	inner join cd.members mems
		on recs.recommender = mems.memid
order by memid desc        

--ex 2 : Find the downward recommendation chain for member ID 1
with recursive recommendeds(memid) as (
	select memid from cd.members where recommendedby = 1
	union all
	select mems.memid
		from recommendeds recs
		inner join cd.members mems
			on mems.recommendedby = recs.memid
)
select recs.memid, mems.firstname, mems.surname
	from recommendeds recs
	inner join cd.members mems
		on recs.memid = mems.memid
order by memid     

--ex 3 : Produce a CTE that can return the upward recommendation chain for any member
with recursive recommenders(recommender, member) as (
	select recommendedby, memid
		from cd.members
	union all
	select mems.recommendedby, recs.member
		from recommenders recs
		inner join cd.members mems
			on mems.memid = recs.recommender
)
select recs.member member, recs.recommender, mems.firstname, mems.surname
	from recommenders recs
	inner join cd.members mems		
		on recs.recommender = mems.memid
	where recs.member = 22 or recs.member = 12
order by recs.member asc, recs.recommender desc      
