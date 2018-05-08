package com.jvirriel.testrestful.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="usuarios")
@NamedQuery(name="Users.findAll", query="SELECT u from usuarios u")
public class Users implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name= "name")
    private String name;

    @Column(name = "claseentidad")
    private String claseentidad;

    @Column(name= "lastname")
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "datedb")
    private Date datedb;

    @Column(name= "comment")
    private String comment;

    @Column(name= "email")
    private String email;

    public Users(){}

    public Users(String name, String codigo) {
        this.codigo = codigo;
        this.name = name;
    }

    public Users(
            String codigo,
            String name,
            String claseentidad,
            String lastName,
            Date datedb,
            String comment,
            String email
    ){
        this.codigo = codigo;
        this.name = name;
        this.claseentidad = claseentidad;
        this.lastName = lastName;
        this.datedb = datedb;
        this.comment = comment;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDatedb() {
        return datedb;
    }

    public void setDatedb(Date datedb) {
        this.datedb = datedb;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClaseentidad() {
        return claseentidad;
    }

    public void setClaseentidad(String claseentidad) {
        this.claseentidad = claseentidad;
    }

    @Override
    public String toString(){
        return "Users{"+
                "id=" + id +", " +
                "name=\"" + name + "\"," +
                "codigo=\"" + codigo + "\"" +
                "}";
    }
}
