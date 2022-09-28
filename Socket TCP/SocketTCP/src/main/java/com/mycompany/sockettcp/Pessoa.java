package com.mycompany.sockettcp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pedro
 */
public class Pessoa implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String document;
    private Date birthDate;

    public Pessoa(Long id, String name, String surname, String document, Date birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", document=" + document + ", birthDate=" + birthDate + '}';
    }
    
    
}
