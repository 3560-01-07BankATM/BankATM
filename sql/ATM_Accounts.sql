CREATE TABLE `Accounts` (
                            `AccountNum` int NOT NULL AUTO_INCREMENT,
                            `CustomerID` int DEFAULT NULL,
                            `Type` varchar(255) DEFAULT NULL,
                            `Balance` int DEFAULT NULL,
                            `OverdraftProtected` tinyint DEFAULT NULL,
                            PRIMARY KEY (`AccountNum`),
                            UNIQUE KEY `AccountNum_UNIQUE` (`AccountNum`),
                            KEY `CustomerID_idx` (`CustomerID`),
                            CONSTRAINT `CustomerID` FOREIGN KEY (`CustomerID`) REFERENCES `Customers` (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
