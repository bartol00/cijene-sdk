import org.junit.jupiter.api.Test;
import com.cijene.sdk.models.stores.request.StoreSearchRequest;
import com.cijene.sdk.models.stores.response.Chains;
import com.cijene.sdk.models.stores.response.Stores;
import com.cijene.sdk.service.StoresService;
import com.cijene.sdk.service.impl.StoresServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static shared.TestHelpers.*;

public class StoresServiceTest {

    @Test
    void getChainObjectSuccess() {
        // given
        StoresService service = new StoresServiceImpl(apiClient, apiToken());

        // when
        Chains chains = service.getChainObject();

        // then
        assertNotNull(chains);
        assertNotEquals(0, chains.getChains().size());
    }

    @Test
    void getStoresByChainSuccess() {
        // given
        StoresService service = new StoresServiceImpl(apiClient, apiToken());

        // when
        Stores stores = service.getStoresByChain("konzum");

        // then
        assertNotNull(stores);
        assertNotEquals(0, stores.getStores().size());
    }

    @Test
    void getStoresBySearchRequestFailsNullRequest() {
        // given
        StoresService service = new StoresServiceImpl(apiClient, apiToken());

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getStoresBySearchRequest(null)
        );

        // then
        assertEquals("Store Search Request cannot be null", ex.getMessage());
    }

    @Test
    void getStoresBySearchRequestFailsOnlyLatitudePresent() {
        // given
        StoresService service = new StoresServiceImpl(apiClient, apiToken());
        StoreSearchRequest request = new StoreSearchRequest();
        request.setLatitude(45.85);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getStoresBySearchRequest(request)
        );

        // then
        assertEquals("Latitude and longitude must be provided together", ex.getMessage());
    }

    @Test
    void getStoresBySearchRequestFailsOnlyLongitudePresent() {
        // given
        StoresService service = new StoresServiceImpl(apiClient, apiToken());
        StoreSearchRequest request = new StoreSearchRequest();
        request.setLongitude(11.55);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getStoresBySearchRequest(request)
        );

        // then
        assertEquals("Latitude and longitude must be provided together", ex.getMessage());
    }

    @Test
    void getStoresBySearchRequestSuccess() {
        // given
        StoresService service = new StoresServiceImpl(apiClient, apiToken());
        StoreSearchRequest request = new StoreSearchRequest();
        request.setChains(List.of("konzum"));

        // when
        Stores stores = service.getStoresBySearchRequest(request);

        // then
        assertNotNull(stores);
        assertNotEquals(0, stores.getStores().size());
    }

}
