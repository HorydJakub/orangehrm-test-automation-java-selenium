package core.testrail;

import core.GlobalConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestRailManager {
    public static void addResultForTestCase(String testCaseId, int status, String comment) {

        if (GlobalConfig.TESTRAIL_ENABLED) {
            APIClient apiClient = new APIClient();
            Map<String, Object> data = new HashMap<>();
            data.put("status_id", status);
            if (!comment.isEmpty()) {
                data.put("comment", comment);
            }
            try {
                apiClient.sendPost("add_result_for_case/" + GlobalConfig.TESTRAIL_RUN_ID + "/" + testCaseId, data);
            } catch (IOException | APIException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
