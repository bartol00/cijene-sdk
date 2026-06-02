import org.junit.jupiter.api.Test;
import com.cijene.sdk.models.health.HealthResponse;
import com.cijene.sdk.service.HealthService;
import com.cijene.sdk.service.impl.HealthServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static shared.TestHelpers.*;

class HealthServiceTest {

    @Test
    void getHealthResponseSuccess() {
        // given
        HealthService service = new HealthServiceImpl(apiClient);

        // when
        HealthResponse response = service.getHealthResponse();

        // then
        assertNotNull(response);
        assertEquals("healthy", response.getStatus());
    }

}