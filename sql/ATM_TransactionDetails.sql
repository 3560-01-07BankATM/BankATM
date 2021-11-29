CREATE TABLE `TransactionDetails` (
                                      `TransactionID` int NOT NULL,
                                      `toAccountID` int DEFAULT NULL,
                                      `fromAccountID` int DEFAULT NULL,
                                      PRIMARY KEY (`TransactionID`),
                                      KEY `toAccountID_idx` (`toAccountID`),
                                      KEY `fromAccountID_idx` (`fromAccountID`),
                                      CONSTRAINT `fromAccountID` FOREIGN KEY (`fromAccountID`) REFERENCES `Accounts` (`AccountNum`),
                                      CONSTRAINT `toAccountID` FOREIGN KEY (`toAccountID`) REFERENCES `Accounts` (`AccountNum`),
                                      CONSTRAINT `TransactionID` FOREIGN KEY (`TransactionID`) REFERENCES `AccountTransaction` (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
