package org.example.utils.logger.strategies;

import org.example.utils.logger.Error;

public interface ErrorLoggingStrategy {
    void logError(Error error);
}
