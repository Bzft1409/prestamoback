package edu.cibertec.prestamoback.controller;

import edu.cibertec.prestamoback.model.dao.ContratoEntity;
import edu.cibertec.prestamoback.service.ClienteService;
import edu.cibertec.prestamoback.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    private final ContratoService contratoService;
    private final ClienteService clienteService;
    @Autowired
    public ContratoController(ContratoService contratoService,ClienteService clienteService) {
        this.contratoService = contratoService;
        this.clienteService=clienteService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContratoEntity>> listarContratos(){
        List<ContratoEntity> lista=contratoService.listarContratos();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContratoEntity> obtenerContrato(@PathVariable("id") int id){
       var contrato=this.contratoService.obtenerPorId(id);
       contrato.setClientela(this.clienteService.obtenerPorId(contrato.getClientela().getId()));
       return ResponseEntity.ok(contrato);
    }
    @PostMapping
    public void insertarContrato(@RequestBody ContratoEntity contrato){
        contrato.setClientela(this.clienteService.obtenerPorId(contrato.getClientela().getId()));
        this.contratoService.insertarContrato(contrato);
    }
    @PutMapping("/{id}")
    public void modificarContrato(@PathVariable("id") int id, @RequestBody ContratoEntity contrato){
        contrato.setId(id);
        contrato.setClientela(clienteService.obtenerPorId(contrato.getClientela().getId()));
        this.contratoService.modificarContrato(contrato);
    }
    @DeleteMapping("/{id}")
    public void borrarContrato(@PathVariable("id") int id){
        this.contratoService.borrarContrato(id);
    }
}
