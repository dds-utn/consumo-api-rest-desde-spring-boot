package ar.utn.ba.ddsi.rest.models.dtos.external;

import lombok.Data;
import java.util.List;

@Data
public class DummyJsonProductsReponseDTO {
    private List<DummyJsonProductDTO> products;
} 