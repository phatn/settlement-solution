CREATE TABLE IF NOT EXISTS `party_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_bank` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `ssi_reference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ssi_code` varchar(255) DEFAULT NULL,
  `supporting_information` varchar(255) DEFAULT NULL,
  `payer_party_id` bigint(20) NOT NULL,
  `receiver_party_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`ssi_code`),
  FOREIGN KEY (`payer_party_id`) REFERENCES `party_account` (`id`),
  FOREIGN KEY (`receiver_party_id`) REFERENCES `party_account` (`id`)
);


CREATE TABLE IF NOT EXISTS `currency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `symbol` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`code`)
);


CREATE TABLE IF NOT EXISTS `settlement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trade_id` bigint(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `currency_id` bigint(20) NOT NULL,
  `message_id` varchar(255) NOT NULL,
  `value_date` date NOT NULL,
  `ssi_code` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`trade_id`),
  FOREIGN KEY (`ssi_code`) REFERENCES `ssi_reference` (`id`),
  FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`)
);