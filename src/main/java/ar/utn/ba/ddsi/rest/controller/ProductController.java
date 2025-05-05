package ar.utn.ba.ddsi.rest.controller;

import ar.utn.ba.ddsi.rest.models.external.Product;
import ar.utn.ba.ddsi.rest.services.DummyJsonService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final DummyJsonService dummyJsonService;

    public ProductController(DummyJsonService dummyJsonService) {
        this.dummyJsonService = dummyJsonService;
    }

    @GetMapping
    public Mono<List<Product>> getAllProducts() {
        return dummyJsonService.getAllProducts();
    }

    @GetMapping("/filtered")
    public Mono<List<Product>> getProductsWithParams(
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer skip,
            @RequestParam(required = false) String select) {
        return dummyJsonService.getProductsWithParams(limit, skip, select);
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Long id) {
        return dummyJsonService.getProductById(id);
    }
} 