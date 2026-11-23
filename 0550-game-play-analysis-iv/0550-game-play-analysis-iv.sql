# Write your MySQL query statement below
WITH FirstLogin AS (
    SELECT 
        player_id,
        event_date,
        MIN(event_date) OVER (PARTITION BY player_id) AS first_login_date
    FROM Activity
)
SELECT 
    ROUND(
        COUNT(DISTINCT CASE 
            WHEN DATEDIFF(event_date, first_login_date) = 1 THEN player_id 
        END) / COUNT(DISTINCT player_id),
        2
    ) AS fraction
FROM FirstLogin;