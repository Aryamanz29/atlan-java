/* SPDX-License-Identifier: Apache-2.0
   Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.util;

/* Based on original code from https://github.com/stripe/stripe-java (under MIT license) */
import static java.util.Objects.requireNonNull;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities for working with strings.
 */
public final class StringUtils {
    private static final Pattern whitespacePattern = Pattern.compile("\\s");
    private static final Pattern connectionQNPrefix = Pattern.compile("(default/[a-z0-9-]+/[0-9]{10})/.*");
    private static final Pattern uuidPattern =
            Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    /**
     * Checks whether a string contains any whitespace characters or not.
     *
     * @param str the string to check.
     * @return {@code true} if the string contains any whitespace characters; otherwise, {@code
     *     false}.
     */
    public static boolean containsWhitespace(String str) {
        requireNonNull(str);
        return whitespacePattern.matcher(str).find();
    }

    /**
     * Compares two strings for equality. The time taken is independent of the number of characters
     * that match.
     *
     * @param a one of the strings to compare.
     * @param b the other string to compare.
     * @return true if the strings are equal, false otherwise.
     */
    public static boolean secureCompare(String a, String b) {
        byte[] digesta = a.getBytes(StandardCharsets.UTF_8);
        byte[] digestb = b.getBytes(StandardCharsets.UTF_8);

        return MessageDigest.isEqual(digesta, digestb);
    }

    /**
     * Determine the name of a field that's read or written by a getter/setter method,
     * from the name of the method.
     *
     * @param methodName from which to reverse-engineer the field name
     * @return the field name
     */
    public static String getFieldNameFromMethodName(String methodName) {
        if (methodName.length() > 3 && (methodName.startsWith("set") || methodName.startsWith("get"))) {
            StringBuilder sb = new StringBuilder(methodName);
            sb.delete(0, 3);
            sb.replace(0, 1, sb.substring(0, 1).toLowerCase(Locale.ROOT));
            return sb.toString();
        }
        return null;
    }

    /**
     * Encode the provided content for storage as a README's content.
     *
     * @param decoded to be encoded
     * @return encoded README content
     */
    public static String encodeContent(String decoded) {
        return decoded == null
                ? null
                : URLEncoder.encode(decoded, StandardCharsets.UTF_8).replace("+", "%20");
    }

    /**
     * Decode the provided content from the README-encoded form to plain HTML.
     *
     * @param encoded to be decoded
     * @return decoded README content (HTML)
     */
    public static String decodeContent(String encoded) {
        return encoded == null ? null : URLDecoder.decode(encoded.replace("%20", "+"), StandardCharsets.UTF_8);
    }

    /**
     * Retrieve the connection's qualifiedName from the provided asset qualifiedName.
     * Note that this will also return null if the qualifiedName provided is for a connection (only) already!
     *
     * @param qualifiedName of the asset, from which to retrieve the connection's qualifiedName
     * @return the qualifiedName of the connection, or null if none can be determined
     */
    public static String getConnectionQualifiedName(String qualifiedName) {
        if (qualifiedName != null) {
            Matcher m = connectionQNPrefix.matcher(qualifiedName);
            if (m.find() && m.groupCount() > 0) {
                return m.group(1);
            }
        }
        return null;
    }

    /**
     * Retrieve the name of a data asset from the provided qualifiedName.
     *
     * @param qualifiedName from which to retrieve the name component
     * @return the name of the data asset
     */
    public static String getNameFromQualifiedName(String qualifiedName) {
        if (qualifiedName != null && qualifiedName.indexOf("/") > 0) {
            return qualifiedName.substring(qualifiedName.lastIndexOf("/") + 1);
        }
        return null;
    }

    /**
     * Retrieve the qualifiedName of the parent data asset of the provided asset's qualifiedName.
     *
     * @param qualifiedName from which to retrieve the parent asset's qualifiedName
     * @return the qualifiedName of the parent data asset
     */
    public static String getParentQualifiedNameFromQualifiedName(String qualifiedName) {
        if (qualifiedName != null && qualifiedName.indexOf("/") > 0) {
            return qualifiedName.substring(0, qualifiedName.lastIndexOf("/"));
        }
        return null;
    }

    /**
     * Remove any leading and trailing /-slashes from the provided string.
     *
     * @param toTrim the string to trim
     * @return the string, without any leading or trailing / (if any)
     */
    public static String trimPathDelimiters(String toTrim) {
        if (toTrim == null) {
            return "";
        } else {
            if (toTrim.startsWith("/")) {
                toTrim = toTrim.substring(1);
            }
            if (toTrim.endsWith("/")) {
                toTrim = toTrim.substring(0, toTrim.length() - 1);
            }
            return toTrim;
        }
    }

    /**
     * Checks whether a string is a valid UUID(v4) or not.
     *
     * @param str the string to check.
     * @return {@code true} if the string is a valid UUID(v4); otherwise, {@code
     *     false}.
     */
    public static boolean isUUID(String str) {
        return str != null && uuidPattern.matcher(str).find();
    }
}