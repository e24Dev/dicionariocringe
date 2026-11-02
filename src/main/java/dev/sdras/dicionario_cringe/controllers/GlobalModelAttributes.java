package dev.sdras.dicionario_cringe.controllers;

import dev.sdras.dicionario_cringe.model.PalavraResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute("palavras")
    public List<PalavraResponse> listarPalavras() {
        return List.of(
                new PalavraResponse(1L, "Cringe", "Algo que causa vergonha alheia."),
                new PalavraResponse(2L, "FOMO", "Fear of Missing Out - medo de perder algo."),
                new PalavraResponse(3L, "Ghosting", "Quando alguém desaparece sem explicação."),
                new PalavraResponse(4L, "Flex", "Exibir algo de forma ostentosa."),
                new PalavraResponse(5L, "Salty", "Estar irritado ou ressentido."),
                new PalavraResponse(6L, "Stan", "Ser um fã muito dedicado de alguém ou algo."),
                new PalavraResponse(7L, "Tea", "Fofoca ou informação interessante."),
                new PalavraResponse(8L, "Woke", "Estar consciente de questões sociais e políticas."),
                new PalavraResponse(9L, "Yeet", "Expressão de entusiasmo ou para lançar algo com força."),
                new PalavraResponse(10L, "Zonked", "Estar extremamente cansado ou exausto."),
                new PalavraResponse(11L, "Bae", "Termo carinhoso para se referir a alguém especial."),
                new PalavraResponse(12L, "Lit", "Algo muito bom, divertido ou emocionante"),
                new PalavraResponse(13L, "Savage", "Alguém que age de forma ousada ou sem remorso."),
                new PalavraResponse(14L, "Slay", "Arrasar, se destacar ou ter sucesso em algo."),
                new PalavraResponse(15L, "Thirsty", "Estar desesperado por atenção ou aprovação."),
                new PalavraResponse(16L, "Vibe", "A atmosfera ou sentimento de um lugar, situação ou pessoa."),
                new PalavraResponse(17L, "Clout", "Influência ou poder, especialmente nas redes sociais."),
                new PalavraResponse(18L, "Cancel", "Boicotar ou rejeitar alguém devido a ações ou opiniões consideradas inaceitáveis."),
                new PalavraResponse(19L, "Receipts", "Provas ou evidências que confirmam algo, geralmente usado em discussões ou fofocas."),
                new PalavraResponse(20L, "Shook", "Estar surpreso, chocado ou abalado por algo inesperado.")
        );
    }
}
