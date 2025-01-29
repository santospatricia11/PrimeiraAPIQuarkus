package acc.br.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Fruta extends PanacheEntity {

	
    @NotNull
    @Size(min = 1, max = 255)
    public String nome;

    @NotNull
    public int qtd;
}
