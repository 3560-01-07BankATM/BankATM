CREATE TABLE `DebitCards` (
                              `CardNum` varchar(16) NOT NULL,
                              `AccountID` int DEFAULT NULL,
                              `fee` int DEFAULT NULL,
                              `expirationDate` datetime DEFAULT NULL,
                              `cvv` varchar(3) DEFAULT NULL,
                              `chipAndPin` tinyint DEFAULT NULL,
                              `pin` varchar(45) DEFAULT NULL,
                              PRIMARY KEY (`CardNum`),
                              UNIQUE KEY `CardNum_UNIQUE` (`CardNum`),
                              KEY `AccountID_idx` (`AccountID`),
                              CONSTRAINT `DebitAccountID` FOREIGN KEY (`AccountID`) REFERENCES `Accounts` (`AccountNum`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
