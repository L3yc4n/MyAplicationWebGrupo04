package MyAplicationWebGrupo04.modelo.controller;

import MyAplicationWebGrupo04.modelo.dto.ClienteLonginSolicitudDTO;
import MyAplicationWebGrupo04.modelo.dto.ClienteLoginRespuestaDTO;
import MyAplicationWebGrupo04.modelo.entity.Cliente;
import MyAplicationWebGrupo04.modelo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET /api/cliente
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listar();
    }

    // GET /api/cliente/{id}
    @GetMapping("/{id}")
    public Cliente obtenerCliente(@PathVariable int id) {
        return clienteService.buscarPorId(id);
    }

    // POST /api/cliente
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    // PUT /api/cliente/{id}
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        cliente.setCodiClie(id);
        return clienteService.guardar(cliente);
    }

    // DELETE /api/cliente/{id}
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id) {
        clienteService.eliminar(id);
    }

    // POST /api/cliente/login
    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody ClienteLonginSolicitudDTO loginRequest) {

        ClienteLoginRespuestaDTO response = clienteService.validarLogin(loginRequest);

        if (response != null) {
            // Login exitoso, devuelve los datos del usuario ()
            return ResponseEntity.ok(response);
        } else {
            // Credenciales incorrectas, no da la autorización
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Error: El usuario o contraseña es incorrecto");
        }
    }
}
