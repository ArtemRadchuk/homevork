select count(*) /  (select courses.duration from courses where id = course_id) from courses.subscriptions  group by course_id ;
