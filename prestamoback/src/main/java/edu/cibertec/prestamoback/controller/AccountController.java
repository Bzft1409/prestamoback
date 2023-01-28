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
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountEntity> obtenerContrato(@PathVariable("id") int id){
        var cuenta=this.accountService.obtenerPorId(id);
        cuenta.setClientela(this.clienteService.obtenerPorId(cuenta.getClientela().getId()));
        return ResponseEntity.ok(cuenta);
    }
    @PostMapping
    public void insertarCuenta(@RequestBody AccountEntity cuenta){
        cuenta.setClientela(this.clienteService.obtenerPorId(cuenta.getClientela().getId()));
        this.accountService.insertarCuenta(cuenta);
    }
    @PutMapping("/{id}")
    public void modificarContrato(@PathVariable("id") int id, @RequestBody AccountEntity cuenta){
        cuenta.setId(id);
        cuenta.setClientela(clienteService.obtenerPorId(cuenta.getClientela().getId()));
        this.accountService.modificarCuenta(cuenta);
    }
    @DeleteMapping("/{id}")
    public void borrarCuenta(@PathVariable("id") int id){
        this.accountService.eliminarCuenta(id);
    }
}
