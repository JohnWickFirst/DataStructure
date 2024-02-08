package com.security.JwtSecurity.Logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class LoggingAtFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return true;
    }
}
