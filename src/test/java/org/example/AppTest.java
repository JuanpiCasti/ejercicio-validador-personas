package org.example;
import org.example.utils.logger.Error;
import org.example.utils.logger.Logger;
import org.example.utils.logger.adapters.DatabaseAdapter;
import org.example.utils.logger.strategies.DatabaseErrorLoggingStrategy;
import org.example.utils.logger.strategies.ErrorLoggingStrategy;
import org.example.utils.logger.strategies.TerminalErrorLoggingStrategy;
import org.example.utils.ObjectToMapConversor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Unit test for simple App.
 */


public class AppTest {

    private Logger logger;

    @BeforeEach
    public void init() {
        ErrorLoggingStrategy loggingStrategyDefault = new TerminalErrorLoggingStrategy();

        this.logger = new Logger(loggingStrategyDefault);
    }

    @Test
    public void logWithDBTest() {
        DatabaseAdapter mockedDBAdapter = mock(DatabaseAdapter.class);

        ErrorLoggingStrategy dbLoggingStrategy = new DatabaseErrorLoggingStrategy(mockedDBAdapter);

        this.logger.setErrorLoggingStrategy(dbLoggingStrategy);

        Error error = new Error(
                "An arithmetic error occurred when dividing by zero.",
                "Division.java line 815",
                LocalDateTime.now()
        );

        logger.log(error);

        verify(mockedDBAdapter).connect();
        verify(mockedDBAdapter).insert("error_log", ObjectToMapConversor.convertObjectToMap(error));
        verify(mockedDBAdapter).disconnect();
    }
}