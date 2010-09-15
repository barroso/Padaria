package br.com.padaria.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente
{

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, Sexo sexo, String dataNascimento) throws ParseException {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = DateFormat.getDateInstance().parse(dataNascimento);
	}

	public enum Sexo {
		MASCULINO, FEMININO
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLIENTE")
	private Long codigo;

	@Column(name = "NM_CLIENTE")
	private String nome;

	@Column(name = "NM_CPF_CLIENTE")
	private String cpf;

	@Enumerated
	@Column(name = "CD_SEXO_CLIENTE")
	private Sexo sexo;

	@Column(name = "DT_NASC_CLIENTE")
	private Date dataNascimento;

	public Long getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Long codigo)
	{
		this.codigo = codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public Sexo getSexo()
	{
		return sexo;
	}

	public void setSexo(Sexo sexo)
	{
		this.sexo = sexo;
	}

	public Date getDataNascimento()
	{
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString()
	{
		return "Cliente[" + this.nome + "," + this.cpf + "," + this.sexo + "," + DateFormat.getDateInstance().format(dataNascimento) + "]";
	}

}
