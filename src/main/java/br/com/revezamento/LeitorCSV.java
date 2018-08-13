package br.com.revezamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LeitorCSV {

	private String caminhoDoArquivo = "./entrada/cartoes_desbloqueados.csv";
	
	public List<String[]> lerArquivoInteiro() throws IOException {
		List<String[]> lista = new ArrayList<String[]>();
		Reader reader = new BufferedReader(new FileReader(caminhoDoArquivo));
		CSVParser csvParser = CSVFormat
				.DEFAULT.withDelimiter(';')
				.withFirstRecordAsHeader()
				.parse(reader);
		List<CSVRecord> records = csvParser.getRecords();
		for (CSVRecord record : records) {
			String[] s = new String[record.size()];
			s[0] = record.get("CPF");
			s[1] = record.get("DATA_NASC");
			s[2] = record.get("NUM_CARTAO");
			s[3] = record.get("SENHA_CARTAO");
			lista.add(s);
		}
		csvParser.close();
		return lista;
	}
}
