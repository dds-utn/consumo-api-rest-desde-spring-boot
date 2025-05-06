package ar.utn.ba.ddsi.rest.models.dtos.external;

import lombok.Data;

@Data
public class DummyJsonProductDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Double discountPercentage;
    private Double rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
    private String[] images;
} 