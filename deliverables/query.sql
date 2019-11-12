SELECT sale_month,
	ticket_volume,
	total_sales,
	monthly_revenue,
	SUM(monthly_revenue) OVER 
		(ORDER BY sale_month ASC rows 11 preceding) AS total_revenue
FROM (
	-- select sales by volume and revenue by month
	SELECT 
		date_trunc('month', saletime) AS sale_month,
		SUM((pricepaid * qtysold) - commission) AS monthly_revenue,
		SUM(qtysold * pricepaid) AS total_sales,
		SUM(qtysold) AS ticket_volume
	FROM sales,
		-- select all events matching top 3 categories
		(
		SELECT eventid as id
		FROM event
		WHERE catid IN
			(
			SELECT catid
				FROM (
					(SELECT top 3 * 
					FROM (
						SELECT event.catid
						FROM event
						GROUP BY event.catid
						ORDER BY count(event.catid) DESC
						)
					)
				) 
			)
		)	
	WHERE sales.eventid = id
	GROUP BY sale_month
	ORDER BY sale_month
	) 
