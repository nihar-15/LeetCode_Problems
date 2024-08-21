# Write your MySQL query statement below

SELECT Users.name , SUM(if(distance is NULL,0,distance)
	) AS travelled_distance
FROM Users LEFT JOIN Rides 
ON Users.id  = Rides.user_id
GROUP BY Rides.user_id
ORDER BY travelled_distance DESC ,  name
;