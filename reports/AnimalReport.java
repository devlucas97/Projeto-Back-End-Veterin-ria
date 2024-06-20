package com.projeto.veterinaria.reports;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.projeto.veterinaria.dtos.AnimalDTO;

public class AnimalReport {
	
	private List<AnimalDTO> lista;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public AnimalReport(List<AnimalDTO> lista) {
		this.lista = lista;
	}
	
	public byte[] createPDF() {
		
		try {
			
			
			Document documento = new Document(PageSize.A4);
			
			//left, right, top, bottom
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			
			/* Image logo = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/tigre.png")));
			
			
			documento.add(logo); 
			
			*/
			
			
			Paragraph titulo = new Paragraph();
			Phrase phrase = new Phrase("Relatório de Animais", FONT_TITULO);
			titulo.add(phrase);
			titulo.setAlignment(Element.ALIGN_CENTER);
			titulo.setSpacingAfter(20);
			
			documento.add(titulo);
			
			for(AnimalDTO animalDTO: lista) {
				Paragraph dados = new Paragraph();
				dados.add("Código: "+animalDTO.getIdAnimal() + "\n");
				dados.add("Nome: "+animalDTO.getNomeAnimal() + "\n");
				dados.add("Espécie: "+animalDTO.getEspecieAnimal() + "\n");
				dados.setSpacingAfter(5);
				documento.add(dados);
				
			}
			
			documento.close();
			
			return stream.toByteArray();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
























