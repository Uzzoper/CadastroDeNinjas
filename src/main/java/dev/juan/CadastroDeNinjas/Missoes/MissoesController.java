package dev.juan.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public String criarMissão() {
        return "Missão criada";
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
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
