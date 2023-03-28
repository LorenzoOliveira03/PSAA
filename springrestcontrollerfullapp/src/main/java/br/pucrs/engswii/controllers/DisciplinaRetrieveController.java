package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.Disciplina;
import br.pucrs.engswii.beans.DisciplinaRegistro;

@RestController
public class DisciplinaRetrieveController {
    @GetMapping("/disciplina/all")
	public List<Disciplina> getAllDisciplinas() {
		return DisciplinaRegistro.getInstance().getDisciplinas();
	}
}
