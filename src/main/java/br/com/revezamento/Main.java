package br.com.revezamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
    public static void main( String[] args ) {
    	List<String[]> lista = null;
    	List<String[]> novaLista = new ArrayList<String[]>();
    	LeitorCSV leitor = new LeitorCSV();
    	EscritorCSV escritor = new EscritorCSV();
        try {
			lista = leitor.lerArquivoInteiro();
			escritor.escreverCabecalho();
		} catch (IOException e) {
			e.printStackTrace();
		}
        for (String[] s : lista) {
        	String[] s2 = new String[s.length + 1];
        	int i;
        	for (i = 0; i < s.length; i++) {
        		System.out.print(s[i] + " ");
        		s2[i] = s[i];
        	}
        	s2[i] = "S";
        	System.out.println();
        	novaLista.add(s2);
        	try {
				escritor.escreverLinha(s2);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
}
