package MyAplicationWebGrupo04.modelo.service;

import MyAplicationWebGrupo04.modelo.entity.Producto;
import MyAplicationWebGrupo04.modelo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // 🧾 Listar todos
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    // 🔍 Buscar por ID
    public Producto buscarPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    // ➕ Guardar nuevo producto
    @Transactional
    public Producto guardar(Producto producto) {
        producto.setVersion(0); // Nueva entidad comienza en versión 0
        return productoRepository.save(producto);
    }

    // ✏️ Actualizar con control de concurrencia
    @Transactional
    public Producto actualizar(int id, Producto productoActualizado) {
        Optional<Producto> optExistente = productoRepository.findById(id);
        if (optExistente.isEmpty()) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        Producto existente = optExistente.get();
        if (existente.getVersion() != productoActualizado.getVersion()) {
            throw new OptimisticLockingFailureException(
                    "El producto fue modificado por otro usuario (concurrencia detectada)");
        }
        existente.setNombProd(productoActualizado.getNombProd());
        existente.setPrecProd(productoActualizado.getPrecProd());
        existente.setStocProd(productoActualizado.getStocProd());
        return productoRepository.save(existente);
    }

    @Transactional
    public Producto actualizarStockSeguro(int id, Producto productoActualizado) {
        Optional<Producto> optExistente = productoRepository.findById(id);
        if (optExistente.isEmpty()) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }

        Producto existente = optExistente.get();

        // ✅ Control de concurrencia optimista SOLO si cambia el stock
        if (productoActualizado.getStocProd() != existente.getStocProd()) {
            if (existente.getVersion() != productoActualizado.getVersion()) {
                throw new OptimisticLockingFailureException(
                        "El stock fue modificado por otro usuario (concurrencia detectada)");
            }
            existente.setStocProd(productoActualizado.getStocProd());
        }

        // ✅ Actualizaciones sin control de concurrencia (no críticas)
        existente.setNombProd(productoActualizado.getNombProd());
        existente.setPrecProd(productoActualizado.getPrecProd());

        return productoRepository.save(existente);
    }

    // 🗑️ Eliminar producto
    @Transactional
    public boolean eliminar(int id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
