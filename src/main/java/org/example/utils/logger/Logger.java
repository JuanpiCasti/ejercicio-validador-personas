package org.example.utils.logger;

import org.example.utils.logger.strategies.ErrorLoggingStrategy;
import lombok.Setter;

public class Logger {
    @Setter
    private ErrorLoggingStrategy errorLoggingStrategy;

    public Logger(ErrorLoggingStrategy errorLoggingStrategy) {
        this.errorLoggingStrategy = errorLoggingStrategy;
    }

    public void log(Error error) {
        this.errorLoggingStrategy.logError(error);
    }
}
