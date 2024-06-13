package org.example;

import org.example.utils.logger.Error;
import org.example.utils.logger.Logger;
import org.example.utils.logger.adapters.MySQLDatabaseAdapter;
import org.example.utils.logger.strategies.DatabaseErrorLoggingStrategy;
import org.example.utils.logger.strategies.TerminalErrorLoggingStrategy;

import java.time.LocalDateTime;

public class Example {

    public static void main(String[] args) {
        Logger logger = new Logger(new TerminalErrorLoggingStrategy());

        logger.log(new Error(
                "An arithmetic error occurred when dividing by zero.",
                "Division.java line 815",
                LocalDateTime.now()
        ));

        logger.setErrorLoggingStrategy(new DatabaseErrorLoggingStrategy(new MySQLDatabaseAdapter()));

        logger.log(new Error(
                "An arithmetic error occurred when dividing by zero.",
                "Division.java line 815",
                LocalDateTime.now()
        ));
    }
}
