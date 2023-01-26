package edu.cibertec.prestamoback.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "documento")
public class DocumentoEntity {
    @Id
    @Column(name="id")
    private int id;
    @Column(name = "tipo")
    private String tipo;
    @Column(name="numero")
    private String numero;
}
