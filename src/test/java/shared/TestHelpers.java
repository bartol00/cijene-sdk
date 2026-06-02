package shared;

import com.segurapass.api.ApiClient;

public class TestHelpers {

    public static ApiClient apiClient = new ApiClient("https://api.cijene.dev");

    public static String apiToken() {
        String key = System.getenv("CIJENE_API_TOKEN");
        if (key == null || key.isBlank()) {
            throw new IllegalStateException("CIJENE_API_TOKEN environment variable is missing");
        }
        return key;
    }

}
