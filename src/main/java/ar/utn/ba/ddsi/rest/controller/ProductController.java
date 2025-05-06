package ar.utn.ba.ddsi.rest.controller;

import ar.utn.ba.ddsi.rest.models.dtos.external.DummyJsonProductDTO;
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
    public Mono<List<DummyJsonProductDTO>> getAllProducts() {
        return dummyJsonService.getAllProducts();
    }

    @GetMapping("/sync")
    public List<DummyJsonProductDTO> getProducts() {
        return this.dummyJsonService.getAllProducts().block();
    }

    @GetMapping("/filtered")
    public Mono<List<DummyJsonProductDTO>> getProductsWithParams(
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer skip,
            @RequestParam(required = false) String select) {
        return dummyJsonService.getProductsWithParams(limit, skip, select);
    }

    @GetMapping("/{id}")
    public Mono<DummyJsonProductDTO> getProductById(@PathVariable Long id) {
        return dummyJsonService.getProductById(id);
    }
} 