package MyAplicationWebGrupo04.modelo.service;

import MyAplicationWebGrupo04.modelo.dto.ClienteLonginSolicitudDTO;
import MyAplicationWebGrupo04.modelo.dto.ClienteLoginRespuestaDTO;
import MyAplicationWebGrupo04.modelo.entity.Cliente;
import MyAplicationWebGrupo04.modelo.repository.ClienteRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminar(int id) {
        clienteRepository.deleteById(id);
    }

    // Esta es una consulta que no modifica datos
    @Transactional(readOnly = true)
    public ClienteLoginRespuestaDTO validarLogin(ClienteLonginSolicitudDTO loginRequest) {

        // Usa parte de ClienteRepository
        Optional<Cliente> clienteOpt = clienteRepository.findByUsuaClieAndContClie(
                loginRequest.getUsuaClie(),
                loginRequest.getContClie()
        );

        if (clienteOpt.isPresent()) {
            // Si el cliente existe, va a DTO respuesta
            Cliente cliente = clienteOpt.get(); //
            return new ClienteLoginRespuestaDTO(
                    cliente.getCodiClie(),
                    cliente.getUsuaClie(),
                    cliente.getNombClie(),
                    cliente.getApePaClie(),
                    cliente.getApeMaClie()
            );
        }

        // Por si no hay nada
        return null;
    }
}
