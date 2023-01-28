package edu.cibertec.prestamoback.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class AccountEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "numero")
    private String number;
    @Column(name = "monto")
    private Double amount;
    @Column(name = "divisa")
    private String currency;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity clientela;

}
