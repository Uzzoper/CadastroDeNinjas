package dev.juan.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.juan.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;

    @JsonIgnore
    private List<NinjaModel> ninja;
}
