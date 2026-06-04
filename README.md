# Cijene SDK

Java SDK for the Cijene API.

The SDK provides a simple, type-safe interface for interacting with the Cijene API, including:

- Product search
- Product lookup by EAN
- Product price retrieval
- Store discovery
- Store chain information
- ZIP archive listing
- Health checks

The SDK handles:

- Authentication
- Request validation
- HTTP communication
- JSON serialization and deserialization
- Error propagation through a unified exception model

---

## Installation

### Maven

```xml
<dependency>
    <groupId>io.github.bartol00</groupId>
    <artifactId>cijene-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

## Quick Start

```java
String apiToken = System.getenv("CIJENE_API_TOKEN");

CijeneClient client = new CijeneClient(apiToken);

ProductSearchRequest request = new ProductSearchRequest();
request.setQuery("Coca Cola");

Products products =
        client.products()
              .getProductBySearchRequest(request);

System.out.println(products.getProducts().size());
```

---

## Authentication

Most endpoints require a valid Cijene API token.

```java
CijeneClient client = new CijeneClient("your-api-token");
```

The SDK automatically adds the required Authorization header to protected requests.

---

## Available Services

| Service | Description |
|----------|-------------|
| HealthService | API health status |
| ProductsService | Product search and lookup |
| PricesService | Product price retrieval |
| StoresService | Store and chain discovery |
| ZipArchivesService | ZIP archive listing |

---

## Product Search

Search products by name or keyword.

```java
ProductSearchRequest request = new ProductSearchRequest();

request.setQuery("Nutella");
request.setLimit(10);

Products products =
        client.products()
              .getProductBySearchRequest(request);
```

---

## Product Lookup by EAN

Retrieve detailed product information using an EAN code.

```java
ProductEanRequest request = new ProductEanRequest();

request.setProductEan("1234567890123");

Product product =
        client.products()
              .getProductByEan(request);
```

---

## Price Search

Retrieve prices for one or more products.

```java
PriceSearchRequest request = new PriceSearchRequest();

request.setEanList(
        List.of("1234567890123")
);

Prices prices =
        client.prices()
              .getPricesByPriceSearchRequest(request);
```

Optional filters:

- chains
- city
- address
- latitude / longitude
- search radius

---

## Store Search

Search stores by chain or location.

```java
StoreSearchRequest request = new StoreSearchRequest();

request.setCity("Zagreb");

Stores stores =
        client.stores()
              .getStoresBySearchRequest(request);
```

---

## Chain Information

Retrieve supported store chains.

```java
Chains chains =
        client.stores()
              .getChains();
```

---

## ZIP Archives

Retrieve available ZIP archives containing raw price datasets.

```java
ZipArchives archives =
        client.archives()
              .getZipArchives();
```

---

## Health Check

Verify API availability.

```java
HealthResponse health =
        client.health()
              .getHealthResponse();

System.out.println(health.getStatus());
```

---

## Error Handling

The SDK throws:

```java
com.segurapass.exception.ApiException
```

for API and communication errors.

Example:

```java
try {
    Products products =
            client.products()
                  .getProductBySearchRequest(request);
}
catch (ApiException ex) {
    System.out.println(ex.getMessage());
}
```

Input validation errors are reported through:

```java
IllegalArgumentException
```

before any request is sent to the API.

---

## Requirements

- Java 21+
- Valid Cijene API token for protected endpoints

---

## License

Apache License 2.0
