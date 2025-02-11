package com.professional.backend.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFileProcessor {

    public static String getExtensionName(String filename) {
        
        return filename.replaceAll("^.*?\\.", "");
    }

    public static String getFileNameWithoutExtension(String filename) {
        
        return filename.replaceAll("\\..*", "");
    }

    public static String getFileChecksum(byte[] fileData) throws NoSuchAlgorithmException {

        byte[] hash = MessageDigest.getInstance("MD5").digest(fileData);
        String checksum = new BigInteger(1, hash).toString(16);

        return checksum;
    }

}
