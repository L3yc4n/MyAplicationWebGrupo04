package MyAplicationWebGrupo04.modelo.repository;


import MyAplicationWebGrupo04.modelo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // JpaRepository ya incluye métodos CRUD básicos
}
