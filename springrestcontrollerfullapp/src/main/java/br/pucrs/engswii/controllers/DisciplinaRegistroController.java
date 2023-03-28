package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.Disciplina;
import br.pucrs.engswii.beans.DisciplinaRegistrationReply;
import br.pucrs.engswii.beans.DisciplinaRegistro;

@RestController
public class DisciplinaRegistroController {

    @PostMapping("/disciplina/add")
	public Disciplina registerDisciplina(@RequestBody Disciplina d) {
		System.out.println("In registerDisciplina");        
		List<Disciplina> disciplinas = DisciplinaRegistro.getInstance().getDisciplinas();
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getCodigo() == d.getCodigo()) {
				System.out.println("Disciplina already exists");
				throw new RuntimeException("Disciplina already exists");
			}
		}
		DisciplinaRegistro.getInstance().addDisciplinas(d);
		DisciplinaRegistrationReply stdregreply = new DisciplinaRegistrationReply();

		
		//We are setting the below value just to reply a message back to the caller
		stdregreply.setCodigo(d.getCodigo());
		stdregreply.setDescricao(d.getDescricao());
		stdregreply.setCodigoTurma(d.getCodigoTurma());
		stdregreply.setRegistrationStatus("Successful");
		

		return d;
	}
    
}
