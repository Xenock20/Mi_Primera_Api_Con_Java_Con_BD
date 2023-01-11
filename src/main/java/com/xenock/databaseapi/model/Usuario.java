
package com.xenock.databaseapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    private String usuario;
    private String passwords;
}
