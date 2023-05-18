package com.example.projetomvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor//é do lombok. cria um construtor vazio
@AllArgsConstructor//é do lombok. cria um construtor cheio.
@Data //é do lombok. Indica que os métodos básicos de uma classe(GETTERS, SETTERS,etc) deve ser feitos
@Entity //é do JPA. indica ao framework de persistencia (hibernate) que essa classe deve ser mapeada como uma tabela no BD.
public class Sala {
    @Id //é do jpa. define a primary key de uma classe de entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)//especifica que os valores da chave primária serão gerados automaticamente pelo banco de dados usando um mecanismo de autoincremento. 
    Integer id;
    Integer numero;
    @NotBlank//Garante que o valor não esteja vazio e não contenha apenas espaços em branco
    String nome;
    Integer capacidade;
    //@Enumerated(EnumType.STRING) //especifica como os valores de um enum devem ser mapeados pro BD.nesse caso String
    @NotBlank
    String statusSala;
}
