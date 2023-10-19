package com.sistemaescolar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sistemaescolar.model.Aluno;
import com.sistemaescolar.model.Endereco;
import com.sistemaescolar.model.Escola;
import com.sistemaescolar.model.Nota;
import com.sistemaescolar.model.Professor;
import com.sistemaescolar.model.Turma;
import com.sistemaescolar.model.enums.Bimestre;
import com.sistemaescolar.model.enums.MateriaEscolar;
import com.sistemaescolar.repository.EscolaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private EscolaRepository escolaRepository;
	
	private Escola escola = new Escola();

	private Endereco endereco = new Endereco();
	
	private Turma turma = new Turma();
	
	private Professor professor = new Professor();
	
	private Aluno aluno = new Aluno();
	
	private Nota nota = new Nota();
	
	@Override
	public void run(String... args) throws Exception {
		
		//Declarando os atributos da escola
		escola.setName("Primária da Liberdade");
		escola.setTelefone("31999999999");
		escola.setEmail("escola01@gmail.com");
		escola.setEndereco(endereco);
		escola.getTurmas().add(turma);
		escola.getProfessores().add(professor);
		escola.getAlunos().add(aluno);
		
		
		//Declarando os atributos do endereco
		endereco.setEstado("MG");
		endereco.setCidade("Belo Horizonte");
		endereco.setBairro("Boa Viagem");
		endereco.setRua("Avenida Afonso Pena");
		endereco.setNumero("50");
		endereco.setEscola(escola);
		
		//Declarando os atributos da turma
		turma.setNumeroDaTurma("101");
		turma.setNumeroDaSala("01");
		turma.setAnoEscolar("1º Ano");
		turma.setEscola(escola);
		turma.getProfessores().add(professor);
		turma.getAlunos().add(aluno);
		
		//Declarando os atributos do professor
		professor.setName("José");
		professor.setEmail("jose@gmail.com");
		professor.setTelefone("31984105555");
		professor.setMateriaEscolar(MateriaEscolar.HISTORIA);
		professor.setEscola(escola);
		professor.getTurmas().add(turma);
		professor.getNotas().add(nota);
		
		//Declarando os atributos do aluno
		aluno.setName("Tiago");
		aluno.setTelefone("31930304040");
		aluno.setEmail("tiago@gmail.com");
		aluno.setTurma(turma);
		aluno.setEscola(escola);
		
		//Declarando os atributos da nota
		nota.setAluno(aluno);
		nota.setProfessor(professor);
		nota.setBimestre(Bimestre.PRIMEIRO);
		nota.setValorNota(10.0);
		nota.setMateriaEscolar(nota.getProfessor().getMateriaEscolar());
		nota.setNumeroDaTurma(aluno.getNumeroDaTurma());
		
		escolaRepository.save(escola);

	}

}
