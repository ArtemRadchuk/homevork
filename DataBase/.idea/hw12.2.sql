select (select name from courses where id = course_id), count(*) /  (select courses.duration from courses where id = course_id) from courses.subscriptions  group by course_id ;rse_id ;
