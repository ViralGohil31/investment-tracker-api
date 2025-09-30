package com.investment.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvestmentTrackerConstants {
    public static final String REQUEST_ID_HEADER = "Request-ID";
    public static final String RECEIVED_REQUEST = "{} - Received '{}' request";
    public static final String COMPLETED_REQUEST = "{} - Completed '{}' request";
}
