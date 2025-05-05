package ar.utn.ba.ddsi.rest.models.external;

import lombok.Data;
import java.util.List;

@Data
public class ProductResponse {
    private List<Product> products;
} 