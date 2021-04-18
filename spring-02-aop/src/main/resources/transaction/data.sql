CREATE TABLE IF NOT EXISTS `testdb`.tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `dept_id` int(11) NOT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


USE `testdb`;
INSERT INTO tbl_employee(id, name, age, dept_id, salary) VALUES (1, 'zhangsan', 18, 1, 1000.00);
INSERT INTO tbl_employee(id, name, age, dept_id, salary) VALUES (2, 'lisi', 20, 2, 1000.00);