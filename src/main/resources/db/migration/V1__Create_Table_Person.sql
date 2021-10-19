CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
)