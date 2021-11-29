CREATE TABLE `AccountTransaction` (
                                      `TransactionID` int NOT NULL AUTO_INCREMENT,
                                      `Amount` int DEFAULT NULL,
                                      `Datetime` datetime DEFAULT NULL,
                                      PRIMARY KEY (`TransactionID`),
                                      UNIQUE KEY `TransactionID_UNIQUE` (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
