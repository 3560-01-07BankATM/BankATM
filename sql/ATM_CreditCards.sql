CREATE TABLE `CreditCards` (
                               `CardNum` int NOT NULL,
                               `AccountID` int DEFAULT NULL,
                               `fee` int DEFAULT NULL,
                               `expirationDate` date DEFAULT NULL,
                               `chipAndPin` tinyint DEFAULT NULL,
                               `cvv` varchar(3) DEFAULT NULL,
                               `creditLimit` int DEFAULT NULL,
                               `creditUsed` int DEFAULT NULL,
                               PRIMARY KEY (`CardNum`),
                               KEY `AccountID_idx` (`AccountID`),
                               CONSTRAINT `CreditAccountID` FOREIGN KEY (`AccountID`) REFERENCES `Accounts` (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
