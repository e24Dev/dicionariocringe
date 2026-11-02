package dev.sdras.dicionario_cringe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
