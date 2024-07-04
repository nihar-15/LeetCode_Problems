# Write your MySQL query statement below

SELECT name AS Customers
FROM Customers 
WHERE id  IN  
(SELECT id 
FROM Customers 
WHERE id NOT IN(SELECT customerID FROM Orders)
 );