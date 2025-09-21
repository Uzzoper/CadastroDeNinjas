package dev.juan.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissão() {
        return "Missão criada";
    }

    @GetMapping("/todas")
    public String mostrarTodasAsMissoes() {
        return "Mostrar todas as missões";
    }

    @GetMapping("/todasID")
    public String mostrarMissaoPorId() {
        return "Mostrar missão por id";
    }

    @PutMapping("/alterarID")
    public String alterarMissaoPorId() {
        return "Alterar missão por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId() {
        return "Deletar missão por id";
    }
}
