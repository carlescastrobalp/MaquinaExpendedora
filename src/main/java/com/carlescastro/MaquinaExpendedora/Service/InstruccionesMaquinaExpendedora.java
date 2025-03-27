package com.carlescastro.MaquinaExpendedora.Service;

import com.carlescastro.MaquinaExpendedora.Model.ProductoDTO;
import com.carlescastro.MaquinaExpendedora.Repository.RepositoryProductos;

import java.util.List;

public class InstruccionesMaquinaExpendedora {

    private final RepositoryProductos repositoryProductos;

    //Gestion de injeccion del Repositorio, ya que el repositorio se encarga de acceder a base de datos
    public InstruccionesMaquinaExpendedora(RepositoryProductos repositoryProductos) {
        this.repositoryProductos = repositoryProductos;
    }

    /**
     * Inserta uno o más productos en la base de datos.
     * Este método será utilizado por el personal encargado de reponer los productos.
     *
     * @param productos Lista de productos a insertar o reponer.
     * @return Lista de productos que se han guardado.
     */
    public List<ProductoDTO> insertarProductos(List<ProductoDTO> productos) {
        // Se pueden agregar validaciones adicionales si es necesario,
        // como formatear el código para que tenga siempre 2 dígitos.
        return repositoryProductos.saveAll(productos);
    }

    /**
     * Consume un producto según el código numérico de 2 dígitos.
     * Se busca el producto por su código (ej. "02" para el producto con código lógico numérico 2)
     * y se decrementa el campo cantidad en 1, simulando el consumo.
     *
     * @param codigo Código numérico en formato de dos dígitos.
     * @return Mensaje indicando el resultado de la operación.
     * @throws IllegalArgumentException Si el código no tiene exactamente 2 dígitos.
     */
    public String consumirProducto(String codigo) {
        // Validar que el código tenga exactamente 2 dígitos
        if (codigo == null || codigo.trim().length() != 2) {
            throw new IllegalArgumentException("Codigo de producto incorrecto");
        }

        // Buscar el producto por su código.
        // Se asume que el repositorio tiene el método findByCodigo.
        ProductoDTO producto = repositoryProductos.findByCodigo(codigo);
        if (producto == null) {
            return "No se encontró un producto con el código: " + codigo;
        }

        // Verificar que haya stock disponible para consumir.
        if (producto.getCantidad() <= 0) {
            return "El producto con código " + codigo + " no tiene stock disponible.";
        }

        // Decrementar la cantidad en 1 para consumir el producto.
        producto.setCantidad(producto.getCantidad() - 1);
        repositoryProductos.save(producto);

        return "Producto '" + producto.getNombre() + "' consumido exitosamente. Cantidad restante: " + producto.getCantidad();
    }
}
