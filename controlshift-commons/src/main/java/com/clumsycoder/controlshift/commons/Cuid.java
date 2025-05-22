package com.clumsycoder.controlshift.commons;

import io.github.thibaultmeyer.cuid.CUID;

/**
 * Utility class for generating CUIDs (Collision-resistant Unique Identifiers).
 */
public class Cuid {

    /**
     * Generates a CUID with the default length of 24 characters.
     *
     * @return A randomly generated CUID.
     */
    public static String getCuid() {
        return CUID.randomCUID2().toString();
    }

    /**
     * Generates a CUID of the specified length.
     * If the provided length is invalid (≤ 0 or > 30), a default-length CUID is returned.
     *
     * @param length Desired length of the CUID.
     * @return A randomly generated CUID.
     */
    public static String getCuid(int length) {
        if (length <= 0 || length > 30) {
            return getCuid();
        }
        return CUID.randomCUID2(length).toString();
    }
}