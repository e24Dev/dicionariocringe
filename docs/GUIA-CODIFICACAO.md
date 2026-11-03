# Guia resumido de codificação

Este roteiro contém apenas os passos para implementar o projeto. Para explicações detalhadas e diagramas, consulte o [README.md](../README.md).

## Passos

1. Crie um projeto no [Spring Initializr](https://start.spring.io) com Gradle-Groovy, Java 17, Spring Boot 4.0.0, grupo `dev.sdras` e artefato `dicionario_cringe`.

2. Adicione as dependências Spring Web, Thymeleaf, Validation e DevTools. Adicione também H2 e MySQL Driver, conforme o `build.gradle` deste projeto.

3. Crie `model/PalavraResponse.java`:

   ```java
   package dev.sdras.dicionario_cringe.model;

   public record PalavraResponse(Long id, String palavra, String descricao) {
   }
   ```

4. Em `controllers/DicionarioController.java`, crie a rota `/dicionario` e passe título e descrição ao template:

   ```java
   @Controller
   @RequestMapping("/dicionario")
   public class DicionarioController {
       @GetMapping
       public String home(Model model) {
           model.addAttribute("titulo", "Dicionário de Cringe");
           model.addAttribute("descricao", "Um dicionário de termos e expressões consideradas \"cringe\" na cultura pop.");
           return "home";
       }
   }
   ```

   Inclua os imports de `Controller`, `Model`, `GetMapping` e `RequestMapping`.

5. Crie `controllers/GlobalModelAttributes.java`. Adicione a lista de verbetes ao Model com `@ModelAttribute("palavras")`, usando os objetos `PalavraResponse`:

   ```java
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
   ```

   Inclua os imports de `ControllerAdvice`, `ModelAttribute`, `List` e `PalavraResponse`. Acrescente os demais verbetes ao `List.of`.

6. Crie `src/main/resources/templates/home.html`, habilite o namespace Thymeleaf no elemento `<html>` e carregue o CSS do Bootstrap 5.3.3.

7. Exiba o título e a descrição com `th:text` e `th:attr`:

   ```html
   <title th:text="${titulo}"></title>
   <meta name="description" th:attr="content=${descricao}">
   ```

8. Dentro de uma tabela Bootstrap responsiva, percorra a lista e mostre cada propriedade:

   ```html
   <tr th:each="p : ${palavras}">
       <th scope="row" th:text="${p.id}"></th>
       <td th:text="${p.palavra}"></td>
       <td th:text="${p.descricao}"></td>
   </tr>
   ```

   Envolva a tabela com `<div class="table-responsive">` e use as classes `table`, `table-striped` e `table-hover`.

9. Execute `DicionarioCringeApplication` e acesse <http://localhost:8080/dicionario>.
