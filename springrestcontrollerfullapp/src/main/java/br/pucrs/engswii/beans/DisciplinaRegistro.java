package br.pucrs.engswii.beans;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaRegistro {
    List<Disciplina> disciplinas;

    private static DisciplinaRegistro stdregd = null;

    public DisciplinaRegistro() {
        this.disciplinas = new ArrayList<>();
    }

    public static DisciplinaRegistro getInstance() {

		if(stdregd == null) {
			stdregd = new DisciplinaRegistro();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplinas(Disciplina disciplina) {
        disciplinas.forEach(d -> {
            if (d.getCodigo() == disciplina.getCodigo()) {
                throw new RuntimeException("Disciplina já cadastrada");
            }
        });
        this.disciplinas.add(disciplina);
    }
    
}
