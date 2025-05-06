package ar.utn.ba.ddsi.rest.services;

import ar.utn.ba.ddsi.rest.models.dtos.external.DummyJsonProductDTO;
import ar.utn.ba.ddsi.rest.models.dtos.external.DummyJsonProductsReponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DummyJsonService {
    private WebClient webClient;

    public DummyJsonService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://dummyjson.com").build();
    }

    public Mono<List<DummyJsonProductDTO>> getAllProducts() {
        return webClient
                .get()
                .uri("/products")
                .retrieve()
                .bodyToMono(DummyJsonProductsReponseDTO.class)
                .map(DummyJsonProductsReponseDTO::getProducts);
    }

    public Mono<List<DummyJsonProductDTO>> getProductsWithParams(Integer limit, Integer skip, String select) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/products")
                        .queryParam("limit", limit)
                        .queryParam("skip", skip)
                        .queryParam("select", select)
                        .build())
                .retrieve()
                .bodyToMono(DummyJsonProductsReponseDTO.class)
                .map(DummyJsonProductsReponseDTO::getProducts);
    }

    public Mono<DummyJsonProductDTO> getProductById(Long id) {
        return webClient
                .get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(DummyJsonProductDTO.class);
    }
} 