#1
SELECT e.`employee_id`, 
CONCAT(`first_name`, ' ', `last_name`) AS `full_name`,
d.`department_id`, d.`name` AS `department_name`
FROM `departments` AS d
JOIN `employees` AS e
ON e.`employee_id` = d.`manager_id`
ORDER BY `employee_id`
LIMIT 5;

#2
SELECT t.`town_id`, t.`name` AS `town_name`, a.`address_text`
FROM `addresses` AS a
JOIN `towns`AS t
ON a.`town_id` = t.`town_id`
WHERE `name` IN ('Sofia', 'San Francisco', 'Carnation')
ORDER BY `town_id`, `address_id`;

#3
SELECT `employee_id`, `first_name`, `last_name`, `department_id`, `salary`
FROM `employees`
WHERE `manager_id` IS NULL;

#4
SELECT COUNT(*) AS `count`
FROM `employees`
WHERE `salary` > (SELECT AVG(`salary`) FROM `employees`);
