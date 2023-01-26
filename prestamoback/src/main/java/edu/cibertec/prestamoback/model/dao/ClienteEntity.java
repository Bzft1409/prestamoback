package edu.cibertec.prestamoback.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AccountEntity> accounts;
    @OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<ContratoEntity> contratos;
    @OneToOne
    @JoinColumn(name = "id_documento",referencedColumnName = "id")
    private DocumentoEntity documento;
    @Column(name = "nombre")
    private String nombre;
}
