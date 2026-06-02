import org.junit.jupiter.api.Test;
import com.cijene.sdk.models.products.request.ProductEanRequest;
import com.cijene.sdk.models.products.request.ProductSearchRequest;
import com.cijene.sdk.models.products.response.Product;
import com.cijene.sdk.models.products.response.Products;
import com.cijene.sdk.service.ProductsService;
import com.cijene.sdk.service.impl.ProductsServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static shared.TestHelpers.*;

public class ProductsServiceTest {

    @Test
    void getProductByEanFailsNullRequest() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getProductByEan(null)
        );

        // then
        assertEquals("Product EAN Request cannot be null", ex.getMessage());
    }

    @Test
    void getProductByEanFailsRequestEanNull() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());
        ProductEanRequest request = new ProductEanRequest();
        request.setProductEan(null);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getProductByEan(request)
        );

        // then
        assertEquals("EAN cannot be null", ex.getMessage());
    }

    @Test
    void getProductByEanFailsRequestEanBlank() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());
        ProductEanRequest request = new ProductEanRequest();
        request.setProductEan("");

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getProductByEan(request)
        );

        // then
        assertEquals("EAN cannot be null", ex.getMessage());
    }

    @Test
    void getProductByEanSuccess() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());
        ProductEanRequest request = new ProductEanRequest();
        request.setProductEan("3600541253704");
        request.setChains(List.of("lidl", "spar", "konzum"));

        // when
        Product product = service.getProductByEan(request);

        // then
        assertNotNull(product);
        assertNotEquals(0, product.getChains().size());
    }

    @Test
    void getProductBySearchRequestFailsNullRequest() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getProductBySearchRequest(null)
        );

        // then
        assertEquals("Product Search Request cannot be null", ex.getMessage());
    }

    @Test
    void getProductBySearchRequestFailsRequestQueryNull() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());
        ProductSearchRequest request = new ProductSearchRequest();
        request.setQuery(null);

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getProductBySearchRequest(request)
        );

        // then
        assertEquals("Query cannot be null", ex.getMessage());
    }

    @Test
    void getProductBySearchRequestFailsRequestQueryBlank() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());
        ProductSearchRequest request = new ProductSearchRequest();
        request.setQuery("");

        // when
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.getProductBySearchRequest(request)
        );

        // then
        assertEquals("Query cannot be null", ex.getMessage());
    }

    @Test
    void getProductBySearchRequestSuccess() {
        // given
        ProductsService service = new ProductsServiceImpl(apiClient, apiToken());
        ProductSearchRequest request = new ProductSearchRequest();
        request.setQuery("deodorant");
        request.setChains(List.of("konzum"));

        // when
        Products products = service.getProductBySearchRequest(request);

        // then
        assertNotNull(products);
        assertNotEquals(0, products.getProducts().size());
    }

}
