package com.hotabmax.readAndWriteTXTLogic.converterFromUTF8ToInteger;

public class ConverterFromUTF8ToInteger {
    public static int convert(int utf8number){
        int returnedNumber = 0;
        if (utf8number == 49) returnedNumber = 1;
        if (utf8number == 50) returnedNumber = 2;
        if (utf8number == 51) returnedNumber = 3;
        if (utf8number == 52) returnedNumber = 4;
        if (utf8number == 53) returnedNumber = 5;
        if (utf8number == 54) returnedNumber = 6;
        if (utf8number == 55) returnedNumber = 7;
        if (utf8number == 56) returnedNumber = 8;
        if (utf8number == 57) returnedNumber = 9;
        return returnedNumber;
    }
}
