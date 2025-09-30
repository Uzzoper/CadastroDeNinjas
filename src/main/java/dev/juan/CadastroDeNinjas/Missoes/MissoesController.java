package dev.juan.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Cria uma nova missão", description = "Rota cria uma nova missão e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missões", description = "Retorna uma lista com todas as missões cadastradas no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> listaDeMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(listaDeMissoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missão pelo id", description = "Rota lista uma missão pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listarMissoesPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id) {
        MissoesDTO missoesPorId = missoesService.listarMissoesPorId(id);
        if (missoesPorId != null) {
            return ResponseEntity.ok(missoesPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera a missão pelo id", description = "Recebe o id da missão na URL e um objeto MissoesDTO com os novos dados no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possível alterar")
    })
    public ResponseEntity<?> alterarMissaoPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.atualizarMissaoPorid(id, missaoAtualizada);
        if (missao != null ) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta missões pelo id", description = "Recebe o id da missão a ser apagada na URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<String> deletarMissaoPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão com o ID: " + id + " deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }
}
