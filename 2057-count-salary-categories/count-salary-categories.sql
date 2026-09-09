select 'Low Salary'as category, count(income) as accounts_count
from Accounts
where income < 20000

UNION ALL

select 'Average Salary' as category, count(income) as accounts_count
from Accounts
where income between 20000 and 50000

UNION ALL

select 'High Salary' as category, count(income) as accounts_count
from Accounts
where income > 50000


order by category asc;
