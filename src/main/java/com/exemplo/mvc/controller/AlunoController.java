package com.exemplo.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exemplo.mvc.model.Aluno;

@Controller
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();

    @GetMapping("/alunos")
    public String formulario() {
        return "alunos-form";
    }

    @PostMapping("/alunos")
    public String cadastrar(
            @RequestParam String nome,
            @RequestParam String matricula,
            Model model
    ) {
        alunos.add(new Aluno(nome, matricula));
        model.addAttribute("alunos", alunos);
        return "alunos-lista";
    }
}