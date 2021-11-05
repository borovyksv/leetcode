package com.company.algorithms.firstbad;

public class VersionControl {

    public static final int BAD_VERSION = 4;

    protected boolean isBadVersion(int version) {
//        System.err.println("call to isBadVersion: " + version);
        return version >= BAD_VERSION;
    }
}
