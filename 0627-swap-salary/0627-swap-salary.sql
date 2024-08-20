# Write your MySQL query statement below
UPDATE Salary 
SET sex = 
CASE 
When sex ='f' Then 'm'
When sex = 'm' Then 'f'
 End ;
