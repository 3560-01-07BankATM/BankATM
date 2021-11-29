CREATE TABLE `Customers` (
                             `CustomerID` int NOT NULL,
                             `Name` varchar(255) DEFAULT NULL,
                             `PhysicalAddress` varchar(255) DEFAULT NULL,
                             `PhoneNumber` varchar(45) DEFAULT NULL,
                             `EmailAddress` varchar(45) DEFAULT NULL,
                             PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
