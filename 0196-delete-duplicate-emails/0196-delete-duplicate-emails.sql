# Write your MySQL query statement 

    DELETE p1
    FROM Person p1 JOIN Person p2
    WHERE p1.id > p2.id AND p1.email = p2.email;