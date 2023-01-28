package edu.cibertec.prestamoback.controller;

import ch.qos.logback.core.net.server.Client;
import edu.cibertec.prestamoback.model.dao.ClienteEntity;
import edu.cibertec.prestamoback.model.dao.ContratoEntity;
import edu.cibertec.prestamoback.service.ClienteService;
import edu.cibertec.prestamoback.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<ClienteEntity> obtenerCliente(@PathVariable("id") int id ){
        var cliente=this.clienteService.obtenerPorId(id);
        return ResponseEntity.ok().body(cliente);
    }
    @PostMapping
    public void insertarCliente(@RequestBody ClienteEntity cliente){
        documentoService.insertarDocumento(cliente.getDocumento());
        cliente.setDocumento(documentoService.obtenerDocumentoByNumber(cliente.getDocumento().getNumero()));
        this.clienteService.insertarCliente(cliente);
    }
    @PutMapping("/{id}")
    public void modificarCliente(@PathVariable("id") int id, @RequestBody ClienteEntity cliente){
        cliente.setId(id);
        cliente.setDocumento(clienteService.obtenerPorId(id).getDocumento());
        /*cliente.setAccounts(clienteService.obtenerPorId(id).getAccounts());
        cliente.setContratos(clienteService.obtenerPorId(id).getContratos());*/
        this.clienteService.modificarCliente(cliente);
    }
    @DeleteMapping("/{id}")
    public void borrarCliente(@PathVariable("id") int id){
        this.clienteService.borrarCliente(id);
    }
    @GetMapping("/paginado10/{pagina}")
    public ResponseEntity<List<ClienteEntity>> listarDiez(@PathVariable("pagina") int pagina){
        return ResponseEntity.ok().body(this.clienteService.paginadoDiez(pagina));
    }
    @GetMapping("/pagar/{id_cuenta}/{id_contrato}")
    public ResponseEntity<ContratoEntity> pagoPrestamo(@PathVariable Map<String,Integer> pathMapVar){
        int cuenta= pathMapVar.get("id_cuenta");
        int contrato= pathMapVar.get("id_contrato");
        return ResponseEntity.ok().body(this.clienteService.pagarPrestamo(contrato,cuenta));

    }
}
