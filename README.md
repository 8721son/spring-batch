# spring-batch

CREATE TABLE `tb_order` (

	`idx` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '고유 번호',
	`store` VARCHAR(100) NULL COMMENT '가게 이름',
	`name` VARCHAR(100) NULL COMMENT '상품 이름',
	`price` int(11) unsigned NULL COMMENT '상품 가격',
	`product_count` int(11) unsigned NULL COMMENT '상품 수량',
	`total_price` int(11) unsigned NULL COMMENT '총금액',
	PRIMARY KEY(`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_batch` (

	`idx` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '고유 번호',
	`store` VARCHAR(100) NULL COMMENT '가게 이름',
	`name` VARCHAR(100) NULL COMMENT '상품 이름',
	`total_price` int(11) unsigned NULL COMMENT '총금액',
	`product_count` int(11) unsigned NULL COMMENT '총수량',
	
	PRIMARY KEY(`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

