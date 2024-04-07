package com.unique.uniqueidgenerator.constant;

import java.time.Instant;

public interface Constants {
    int TIME_STAMP_BIT = 41;
    long TIME_EPOCH = Instant.parse("1971-01-01T00:00:00Z").toEpochMilli();
    int DATA_CENTER_ID_BITS = 5;
    int MACHINE_ID_BITS = 5;
    int SEQUENCE_BITS = 12;
    long MAX_TIMESTAMP = (1L << TIME_STAMP_BIT) - 1;
    int MAX_DATA_CENTER_ID = (1 << DATA_CENTER_ID_BITS) - 1;
    int MAX_MACHINE_ID = (1 << MACHINE_ID_BITS) - 1;
    long MAX_SEQUENCE = (1 << SEQUENCE_BITS) - 1;
}
