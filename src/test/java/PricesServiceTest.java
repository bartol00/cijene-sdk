import org.junit.jupiter.api.Test;
import com.cijene.sdk.models.prices.request.PriceSearchRequest;
import com.cijene.sdk.models.prices.response.Prices;
import com.cijene.sdk.service.PricesService;
import com.cijene.sdk.service.impl.PricesServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static shared.TestHelpers.*;

public class PricesServiceTest {

    @Test
    void getPricesByPriceSearchRequestFailsNullRequest() {
        // given
        PricesService service =  new PricesServiceImpl(apiClient, apiToken());

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getPricesByPriceSearchRequest(null)
        );

        // then
        assertEquals("Price Search Request cannot be null", ex.getMessage());
    }

    @Test
    void getPricesByPriceSearchRequestFailsNullEanList() {
        // given
        PricesService service =  new PricesServiceImpl(apiClient, apiToken());
        PriceSearchRequest request = new PriceSearchRequest();
        request.setEanList(null);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getPricesByPriceSearchRequest(request)
        );

        // then
        assertEquals("EAN list cannot be null or empty", ex.getMessage());
    }

    @Test
    void getPricesByPriceSearchRequestFailsEmptyEanList() {
        // given
        PricesService service =  new PricesServiceImpl(apiClient, apiToken());
        PriceSearchRequest request = new PriceSearchRequest();
        request.setEanList(List.of());

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getPricesByPriceSearchRequest(request)
        );

        // then
        assertEquals("EAN list cannot be null or empty", ex.getMessage());
    }

    @Test
    void getPricesByPriceSearchRequestFailsOnlyLatitudePresent() {
        // given
        PricesService service =  new PricesServiceImpl(apiClient, apiToken());
        PriceSearchRequest request = new PriceSearchRequest();
        request.setEanList(List.of("3600541253704"));
        request.setLatitude(45.85);
        request.setLongitude(null);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getPricesByPriceSearchRequest(request)
        );

        // then
        assertEquals("Latitude and longitude must be provided together", ex.getMessage());
    }

    @Test
    void getPricesByPriceSearchRequestFailsOnlyLongitudePresent() {
        // given
        PricesService service =  new PricesServiceImpl(apiClient, apiToken());
        PriceSearchRequest request = new PriceSearchRequest();
        request.setEanList(List.of("3600541253704"));
        request.setLatitude(null);
        request.setLongitude(11.55);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getPricesByPriceSearchRequest(request)
        );

        // then
        assertEquals("Latitude and longitude must be provided together", ex.getMessage());
    }

    @Test
    void getPricesByPriceSearchRequestFailsNegativeRadius() {
        // given
        PricesService service =  new PricesServiceImpl(apiClient, apiToken());
        PriceSearchRequest request = new PriceSearchRequest();
        request.setEanList(List.of("3600541253704"));
        request.setLatitude(45.85);
        request.setLongitude(11.55);
        request.setRadius(-1.00);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getPricesByPriceSearchRequest(request)
        );

        // then
        assertEquals("Radius cannot be negative", ex.getMessage());
    }

    @Test
    void getPricesByPriceSearchRequestSuccess() {
        // given
        PricesService service =  new PricesServiceImpl(apiClient, apiToken());
        PriceSearchRequest request = new PriceSearchRequest();
        request.setEanList(List.of("3600541253704"));
        request.setChains(List.of("spar"));

        // when
        Prices prices = service.getPricesByPriceSearchRequest(request);

        // then
        assertNotNull(prices);
        assertNotEquals(0, prices.getPrices().size());
    }

}
