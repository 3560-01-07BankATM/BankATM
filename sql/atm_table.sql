CREATE TABLE `ATM` (
                       `ID` int NOT NULL AUTO_INCREMENT,
                       `Address` varchar(255) DEFAULT NULL,
                       `Ones` varchar(100) DEFAULT NULL,
                       `Fives` varchar(100) DEFAULT NULL,
                       `Tens` varchar(100) DEFAULT NULL,
                       `Twenties` varchar(100) DEFAULT NULL,
                       `Fifties` varchar(100) DEFAULT NULL,
                       `Hundreds` varchar(100) DEFAULT NULL,
                       PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
