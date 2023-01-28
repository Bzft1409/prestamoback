package edu.cibertec.prestamoback.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @Column(name = "id")
    private int id;
    @JsonIgnore
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AccountEntity> accounts=new ArrayList<AccountEntity>();
    @JsonIgnore
    @OneToMany(mappedBy = "id",cascade=CascadeType.ALL)
    private List<ContratoEntity> contratos;
    @OneToOne
    @JoinColumn(name = "id_documento",referencedColumnName = "id")
    private DocumentoEntity documento;
    @Column(name = "nombre")
    private String nombre;
}
