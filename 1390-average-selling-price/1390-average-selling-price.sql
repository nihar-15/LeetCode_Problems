SELECT 
    Prices.product_id,
    IFNULL(ROUND(SUM(price * units) / SUM(UnitsSold.units), 2), 0) AS average_price
FROM 
    Prices 
LEFT JOIN 
    UnitsSold 
ON 
    Prices.product_id = UnitsSold.product_id 
    AND purchase_date >= start_date
    AND purchase_date <= end_date
GROUP BY 
    Prices.product_id;
