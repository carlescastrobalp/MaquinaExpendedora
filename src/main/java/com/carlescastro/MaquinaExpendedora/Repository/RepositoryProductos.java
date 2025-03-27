package com.carlescastro.MaquinaExpendedora.Repository;

import com.carlescastro.MaquinaExpendedora.Model.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProductos extends JpaRepository<ProductoDTO, String> {

    ProductoDTO findByCodigo (String codigo);
}
