package com.jakubhoryd.core.testrail;

import com.jakubhoryd.core.utils.PropertyHelper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestRailManager {
    public static void addResultForTestCase(String testCaseId, int status, String comment) {

        if (PropertyHelper.getTestrailEnabled()) {
            APIClient apiClient = new APIClient();
            Map<String, Object> data = new HashMap<>();
            data.put("status_id", status);
            if (!comment.isEmpty()) {
                data.put("comment", comment);
            }
            try {
                apiClient.sendPost("add_result_for_case/" + PropertyHelper.getTestrailRunId() + "/" + testCaseId, data);
            } catch (IOException | APIException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
