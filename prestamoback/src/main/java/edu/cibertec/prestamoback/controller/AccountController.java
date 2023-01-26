package edu.cibertec.prestamoback.controller;

import edu.cibertec.prestamoback.model.dao.AccountEntity;
import edu.cibertec.prestamoback.model.dao.ContratoEntity;
import edu.cibertec.prestamoback.service.AccountService;
import edu.cibertec.prestamoback.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
    private final AccountService accountService;
    private final ClienteService clienteService;
    @Autowired
    public AccountController(AccountService accountService,ClienteService clienteService) {
        this.accountService = accountService;
        this.clienteService=clienteService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountEntity>> listarCuentas(){
        var lista=accountService.obtenerCuentas();
        for(AccountEntity cuenta:lista){
            cuenta.setCliente(this.clienteService.obtenerPorId(cuenta.getId()));
        }
        return ResponseEntity.ok(lista);
    }
    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountEntity> obtenerContrato(@PathVariable("id") int id){
        var cuenta=this.accountService.obtenerPorId(id);
        cuenta.setCliente(this.clienteService.obtenerPorId(cuenta.getCliente().getId()));
        return ResponseEntity.ok(cuenta);
    }
    @PostMapping
    public void insertarCuenta(@RequestBody AccountEntity cuenta){
        cuenta.setCliente(this.clienteService.obtenerPorId(cuenta.getCliente().getId()));
        this.accountService.insertarCuenta(cuenta);
    }
    @PutMapping("/{id}")
    public void modificarContrato(@PathVariable("id") int id, @RequestBody AccountEntity cuenta){
        cuenta.setId(id);
        cuenta.setCliente(clienteService.obtenerPorId(cuenta.getCliente().getId()));
        this.accountService.modificarCuenta(cuenta);
    }
    @DeleteMapping("/{id}")
    public void borrarCuenta(@PathVariable("id") int id){
        this.accountService.eliminarCuenta(id);
    }
}
