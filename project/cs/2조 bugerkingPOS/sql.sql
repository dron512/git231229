CREATE DATABASE burgerking;

CREATE TABLE IF NOT EXISTS `inventory` (
  `inventory_id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`inventory_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `inventory_history` (
  `history_id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int NOT NULL,
  `menu_name` varchar(50) NOT NULL DEFAULT '',
  `change_quantity` int NOT NULL,
  `sold_quantity` int NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`history_id`),
  KEY `menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_time` datetime NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `order_menu` (
  `order_menu_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `menu_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_menu_id`),
  KEY `order_id` (`order_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `order_menu_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `order_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `payment_method` enum('카드','현금') NOT NULL,
  `payment_amount` decimal(10,0) NOT NULL,
  `payment_time` datetime NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO inventory (menu_id, stock)
VALUES (1, 100), 
       (2, 100), 
       (3, 100), 
       (4, 100), 
       (5, 100), 
       (6, 100), 
       (7, 100), 
       (8, 100), 
       (9, 100), 
       (10, 100), 
       (11, 100), 
       (12, 100), 
       (13, 100), 
       (14, 100), 
       (15, 100), 
       (16, 100), 
       (17, 100), 
       (18, 100), 
       (19, 100), 
       (20, 100), 
       (21, 100);

INSERT INTO menu (menu_name, price, type)
VALUES ('와퍼', 5000, '버거'), 
       ('불고기와퍼', 5500, '버거'), 
       ('게살와퍼', 5500, '버거'), 
       ('집게리아버거', 8000, '버거'), 
       ('게살버거', 7500, '버거'), 
       ('새우버거', 6500, '버거'), 
       ('쉬림프와퍼', 6000, '버거'), 
       ('고래버거', 7000, '버거'), 
       ('플라크톤버거', 6500, '버거'), 
       ('너겟킹8조각', 4500, '사이드'), 
       ('해쉬브라운', 2500, '사이드'), 
       ('너겟킹', 4500, '사이드'), 
       ('21치즈스틱', 3500, '사이드'), 
       ('언니언링', 3000, '사이드'), 
       ('바삭킹', 3500, '사이드'), 
       ('쉐이킹프라이', 3000, '사이드'), 
       ('크리미모짜볼', 4000, '사이드'), 
       ('코울슬로', 2000, '사이드'), 
       ('코카콜라', 2000, '음료'), 
       ('스프라이트', 2000, '음료'), 
       ('아메리카노', 2500, '음료');
