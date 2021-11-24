package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String stringNum = "million";
        int intNum = 1000000;
        byte byteNum = (byte) 1000000;
        short shortNum = (short) 1000000;
        long longNum = 1000000;
        float floatNum = 1000000f;
        double doubleNum = 1000000;
        char charSymbol = 'm';
        boolean isMillion = true;
        LOG.debug("string : {}, int : {}, byte : {}, short : {}, "
                        + "long : {}, float : {}, double : {}, char : {}, boolean : {}",
                stringNum, intNum, byteNum, shortNum, longNum, floatNum, doubleNum, charSymbol, isMillion);
    }
}
