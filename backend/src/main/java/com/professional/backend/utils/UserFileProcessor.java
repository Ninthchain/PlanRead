package com.professional.backend.utils;

import org.springframework.web.multipart.MultipartFile;

public class UserFileProcessor {

    public static String getExtensionName(MultipartFile file) {
        String filename = file.getName();
        String extensionName = new String();

        for (int i = filename.lastIndexOf('.') + 1; i < filename.length(); i++) {

            extensionName += filename.charAt(i);
        }

        return extensionName;
    }

    public static String getExtensionName(String filename) {

        String extensionName = new String();

        for (int i = filename.lastIndexOf('.') + 1; i < filename.length(); i++) {

            extensionName += filename.charAt(i);
        }

        return extensionName;
    }
}
