package com.atlan.live;

import com.atlan.Atlan;

public class AtlanLiveTest {

    public static final String ANNOUNCEMENT_TITLE = "Automated testing.";
    public static final String ANNOUNCEMENT_MESSAGE = "Automated testing of the Java client.";

    static {
        Atlan.setApiToken(System.getenv("ATLAN_API_KEY"));
        Atlan.setBaseUrl(System.getenv("ATLAN_BASE_URL"));
    }
}