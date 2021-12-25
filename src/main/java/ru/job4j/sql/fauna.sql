SELECT * FROM fauna WHERE name LIKE '%fish%';
SELECT * FROM fauna WHERE avr_age BETWEEN 10000 AND 21000;
SELECT * FROM fauna WHERE discovery_date is null;
SELECT * FROM fauna WHERE discovery_date < '01.01.1950';