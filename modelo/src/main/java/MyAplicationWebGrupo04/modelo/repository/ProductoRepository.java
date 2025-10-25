package MyAplicationWebGrupo04.modelo.repository;

import MyAplicationWebGrupo04.modelo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}

