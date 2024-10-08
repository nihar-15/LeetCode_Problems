SELECT Products.product_name, SUM(Orders.unit) AS unit
FROM Products
JOIN Orders ON Products.product_id = Orders.product_id
WHERE Orders.order_date LIKE '2020-02%' 
GROUP BY Products.product_id, Products.product_name
HAVING SUM(Orders.unit) >= 100;
