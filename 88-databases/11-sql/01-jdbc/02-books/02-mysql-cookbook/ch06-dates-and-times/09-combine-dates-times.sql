
SELECT MAKETIME(10,30,58), MAKETIME(-5,0,11);
/*
+--------------------+-------------------+
| MAKETIME(10,30,58) | MAKETIME(-5,0,11) |
+--------------------+-------------------+
| 10:30:58           | -05:00:11         |
+--------------------+-------------------+
1 row in set (0.00 sec)
*/

SELECT d, DATE_FORMAT(d,'%Y-%m-01') FROM date_val;
/*
+------------+---------------------------+
| d          | DATE_FORMAT(d,'%Y-%m-01') |
+------------+---------------------------+
| 1864-02-28 | 1864-02-01                |
| 1900-01-15 | 1900-01-01                |
| 1999-12-31 | 1999-12-01                |
| 2000-06-04 | 2000-06-01                |
| 2017-03-16 | 2017-03-01                |
+------------+---------------------------+
5 rows in set (0.00 sec)
*/


SELECT t1, TIME_FORMAT(t1,'%H:%i:00') FROM time_val;
/*
+----------+----------------------------+
| t1       | TIME_FORMAT(t1,'%H:%i:00') |
+----------+----------------------------+
| 15:00:00 | 15:00:00                   |
| 05:01:30 | 05:01:00                   |
| 12:30:20 | 12:30:00                   |
+----------+----------------------------+
3 rows in set (0.00 sec)
*/

SELECT d, CONCAT(YEAR(d),'-',MONTH(d),'-01') FROM date_val;
/*
+------------+------------------------------------+
| d          | CONCAT(YEAR(d),'-',MONTH(d),'-01') |
+------------+------------------------------------+
| 1864-02-28 | 1864-2-01                          |
| 1900-01-15 | 1900-1-01                          |
| 1999-12-31 | 1999-12-01                         |
| 2000-06-04 | 2000-6-01                          |
| 2017-03-16 | 2017-3-01                          |
+------------+------------------------------------+
5 rows in set (0.00 sec)
*/
