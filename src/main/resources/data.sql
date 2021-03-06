CREATE TABLE IF NOT EXISTS `PERSON` (
    `id` BIGINT  PRIMARY KEY AUTO_INCREMENT,
     `NAME` VARCHAR(50) NOT NULL,
     `age` BIGINT  NOT NULL,
     NASC_DATE DATE
);
CREATE TABLE IF NOT EXISTS `ITEM` (
    `id` BIGINT  PRIMARY KEY AUTO_INCREMENT,
     `NAME` VARCHAR(50) NOT NULL,
     `VAL` DECIMAL(20,2)
);
CREATE TABLE IF NOT EXISTS `ORDERS` (
    `id` BIGINT  PRIMARY KEY AUTO_INCREMENT,
     `ITEM` BIGINT NOT NULL,
     `PERSON` BIGINT,
     `VAL` DECIMAL(20,2)
);

INSERT INTO ITEM (`NAME`, `VAL`) VALUES ('Celta 2000', 12.50);
INSERT INTO ITEM (`NAME`, `VAL`) VALUES ('RTX2060', 12000.99);
INSERT INTO ITEM (`NAME`, `VAL`) VALUES ('RTX3060', 22000.99);