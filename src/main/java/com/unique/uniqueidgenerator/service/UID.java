package com.unique.uniqueidgenerator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

import static com.unique.uniqueidgenerator.constant.Constants.*;

@Service
@ConfigurationProperties
public class UID {

  @Value("sign")
  private static int sign;

  @Value("data.center.id")
  private static int dataCenterId;

  @Value("machine.id")
  private static int machineId;

  private static long sequence = 0;
  private static long lastTimestamp = -1L;

  private UID() {}

    public static BigInteger randomUniqueId() {
    return generateUniqueID();
  }

  private static BigInteger generateUniqueID() {
    long currentTimestamp = System.currentTimeMillis();
    if (currentTimestamp < lastTimestamp) {
      throw new RuntimeException("Clock is in correct in  the System, Set the clock");
    }
    if (lastTimestamp == currentTimestamp) {
      sequence = (sequence + 1) & MAX_SEQUENCE;
      if (sequence == 0) {
        currentTimestamp = waitNextMillis();
      }
    } else {
      sequence = 0;
    }
    lastTimestamp = currentTimestamp;

    BigInteger signBit = BigInteger.valueOf(getSingBit()).shiftLeft(63);
    BigInteger timestampBits =
        BigInteger.valueOf((currentTimestamp - TIME_EPOCH) & MAX_TIMESTAMP)
            .shiftLeft((DATA_CENTER_ID_BITS + MACHINE_ID_BITS + SEQUENCE_BITS));
    BigInteger dataCenterBits =
        BigInteger.valueOf(getDataCenterID()).shiftLeft(MACHINE_ID_BITS + SEQUENCE_BITS);
    BigInteger machineBits = BigInteger.valueOf(getMachineID()).shiftLeft(SEQUENCE_BITS);
    BigInteger sequenceBits = BigInteger.valueOf(sequence & MAX_SEQUENCE);
    return signBit.or(timestampBits).or(dataCenterBits).or(machineBits).or(sequenceBits);
  }

  private static long waitNextMillis() {
    long timestamp = System.currentTimeMillis();
    while (timestamp <= lastTimestamp) {
      timestamp = System.currentTimeMillis();
    }
    return timestamp;
  }

  private static long getSingBit() {
    return sign;
  }

  private static int getDataCenterID() {
    return dataCenterId & MAX_DATA_CENTER_ID;
  }

  private static int getMachineID() {
    return machineId & MAX_MACHINE_ID;
  }
}
