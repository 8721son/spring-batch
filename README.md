# spring-batch
TB_ORDER

    CREATE TABLE `tb_order` (

	`idx` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '고유 번호',
	`store` VARCHAR(100) NULL COMMENT '가게 이름',
	`name` VARCHAR(100) NULL COMMENT '상품 이름',
	`price` int(11) unsigned NULL COMMENT '상품 가격',
	`product_count` int(11) unsigned NULL COMMENT '상품 수량',
	`total_price` int(11) unsigned NULL COMMENT '총금액',
	PRIMARY KEY(`idx`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

TB_BATCH

    CREATE TABLE `tb_batch` (

    `idx` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '고유 번호',
    `store` VARCHAR(100) NULL COMMENT '가게 이름',
    `name` VARCHAR(100) NULL COMMENT '상품 이름',
    `total_price` int(11) unsigned NULL COMMENT '총금액',
    `product_count` int(11) unsigned NULL COMMENT '총수량',
	
    PRIMARY KEY(`idx`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

STORED_PROCEDURE (더미데이터 생성용)

    CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_ORDER`()


    BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE st VARCHAR(50);
    DECLARE na VARCHAR(2) ;
    DECLARE pr INT DEFAULT 0;
    DECLARE cnt INT DEFAULT 0;

 	WHILE i <= 200000 DO
 		SET pr = 65 + rand()*26;
 		SET na = CHR(pr);
 		SET pr = pr * 100;
 		SET cnt = (rand()*9)+1;
 		
 		IF(pr<7500) THEN SET st = 'suyeong';
 		ELSEIF (pr<8500) THEN SET st = 'centom';
 		ELSE SET st = 'gwangan';
 		END IF;
 		
        INSERT INTO tb_order(store,name,price,product_count,total_price)
          VALUES(st,na,pr,cnt,pr*cnt);
          
        SET i = i + 1;
        
    END WHILE;

    END