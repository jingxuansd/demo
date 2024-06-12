USE mysql;

DELIMITER //

CREATE PROCEDURE CreateDatabases()
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE dbName VARCHAR(100);

    WHILE i < 1000 DO
        SET dbName = CONCAT('db', i);
        SET @createStmt = CONCAT('CREATE DATABASE ', dbName);
        PREPARE stmt FROM @createStmt;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;

CALL CreateDatabases();

DROP PROCEDURE CreateDatabases;