select c.customer_id from Customer C 
group by c.customer_id
 having COUNT(Distinct c.product_key) = 
 (select count(*) from 
  Product 
 );