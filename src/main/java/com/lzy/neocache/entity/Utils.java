package com.lzy.neocache.entity;

public class Utils {

    public static int optimalBitCount(int totalCount, double errorProbability) {
        return (int) Math.ceil(
                -totalCount * Math.log(errorProbability) / Math.pow(Math.log(2), 2));
    }

    public static int hashFunctionCount(int totalCount, int bitArraySize) {
        return (int) Math.ceil(Math.log(2) * ((double) bitArraySize / totalCount));
    }

}
