package edu.cibertec.prestamoback.controller;

import edu.cibertec.prestamoback.model.dao.ClienteEntity;
import edu.cibertec.prestamoback.service.ClienteService;
import edu.cibertec.prestamoback.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final DocumentoService documentoService;
    @Autowired
    public ClienteController(ClienteService clienteService,DocumentoService documentoService) {
        this.clienteService = clienteService;
        this.documentoService=documentoService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteEntity>> obtenerClientes(){
        var lista=clienteService.listarCliente();
        for(ClienteEntity cliente:lista){
            cliente.setDocumento(this.documentoService.obtenerDocumento(cliente.getDocumento().getId()));
        }
        return ResponseEntity.ok(lista);
    }
    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteEntity> obtenerCliente(@RequestParam("id") int id ){
        var cliente=this.clienteService.obtenerPorId(id);
        cliente.setDocumento(documentoService.obtenerDocumento(cliente.getDocumento().getId()));
        return ResponseEntity.ok(cliente);
    }
    @PostMapping
    public void insertarCliente(@RequestBody ClienteEntity cliente){
        this.clienteService.insertarCliente(cliente);
    }
    @PutMapping("/{id}")
    public void modificarCliente(@PathVariable("id") int id, @RequestBody ClienteEntity cliente){
        cliente.setId(id);
        cliente.setDocumento(this.documentoService.obtenerDocumento(cliente.getDocumento().getId()));
        this.clienteService.modificarCliente(cliente);
    }
    @DeleteMapping("/{id}")
    public void borrarCliente(@RequestParam("id") int id){
        this.clienteService.borrarCliente(id);
    }
}
