package com.carlsonwagonlit.linedef

import java.util.Collections

/**
 * Jackson requires a no-argument constructor, so all fields are vars with default arguments
 */
data class LineDef(
        var subGuidId: String = "",
        var gdsId: String = "",
        var topGuid: String = "",
        var topGuidSource: String = "",
        var subGuid: String = "",
        var subGuidSource: String = "",
        var travelerType: String = "",
        var travelerTypeSource: String = "",
        var airfareReasonCode: String = "",
        var airfareReasonCodeSource: String = "",
        var lowestFare: String = "",
        var lowestFareSource: String = "",
        var costCenter: String = "",
        var costCenterSource: String = "",
        var travelReason: String = "",
        var travelReasonSource: String = "",
        var hotelReasonCode: String = "",
        var hotelReasonCodeSource: String = "",
        var carReasonCode: String = "",
        var carReasonCodeSource: String = "",
        var authorizerEmail: String = "",
        var authorizerEmailSource: String = "",
        var authorizerEmails1x: List<String> = Collections.emptyList(),
        var authorizerEmails1xSource: String = "",
        var authorizerEmails2x: List<String> = Collections.emptyList(),
        var authorizerEmails2xSource: String = "",
        var authorizerEmails3x: List<String> = Collections.emptyList(),
        var authorizerEmails3xSource: String = "",
        var travelerEmail: String = "",
        var travelerEmailSource: String = "",
        var arrangerEmail: String = "",
        var arrangerEmailSource: String = ""
)