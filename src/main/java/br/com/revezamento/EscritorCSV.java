package br.com.revezamento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class EscritorCSV {

	private String caminhoDoArquivo = "./saida/ibpf_senha_cadastrada.csv";
	
	public void escreverCabecalho() throws IOException {
		PrintWriter writer = 
				new PrintWriter(
						new BufferedWriter(
								new FileWriter(caminhoDoArquivo)));
		writer.println("CPF;DATA_NASC;NUM_CARTAO;SENHA_CARTAO;SENHA_IBPF");
		writer.flush();
		writer.close();
	}

	public void escreverLinha(Object[] s) throws IOException {
		Writer writer = 
				new BufferedWriter(
						new PrintWriter(
								new FileWriter(caminhoDoArquivo, true)));
		CSVPrinter printer = new CSVPrinter(writer, CSVFormat.RFC4180.withDelimiter(';'));
		printer.printRecord(s);
		printer.flush();
		printer.close();
	}
}
