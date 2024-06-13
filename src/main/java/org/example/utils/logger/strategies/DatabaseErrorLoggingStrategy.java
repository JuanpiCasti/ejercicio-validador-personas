package org.example.utils.logger.strategies;

import org.example.utils.logger.Error;
import org.example.utils.logger.adapters.DatabaseAdapter;
import org.example.utils.ObjectToMapConversor;

public class DatabaseErrorLoggingStrategy implements ErrorLoggingStrategy {
    private DatabaseAdapter databaseAdapter;

    public DatabaseErrorLoggingStrategy(DatabaseAdapter databaseAdapter) {
        this.databaseAdapter = databaseAdapter;
    }

    @Override
    public void logError(Error error) {
        this.databaseAdapter.connect();

        this.databaseAdapter.insert("error_log", ObjectToMapConversor.convertObjectToMap(error));

        this.databaseAdapter.disconnect();
    }
}
