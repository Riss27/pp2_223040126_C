/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Mahasiswa;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author thega
 */
public class MahasiswaPdf {

    public void exportPdf(List<Mahasiswa> mahasiswas) {
        System.out.println(mahasiswas.size());
        Document document = new Document();
        
        try {
            // Mengatur lokasi output PDF
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(System.getProperty("user.dir") + File.separator + "mahasiswa.pdf"));
            
            document.open();
            
            // Menentukan lebar kolom untuk tabel
            float[] columnDefinitionSize = {25F, 25F, 25F, 25F};
            
            PdfPTable table = new PdfPTable(columnDefinitionSize);
            table.getDefaultCell().setBorder(1);
            table.setHorizontalAlignment(0);
            table.setTotalWidth(document.getPageSize().getWidth() - 72);
            table.setLockedWidth(true);
            
            // Menambahkan header tabel
            table.addCell(new Phrase("No"));
            table.addCell(new Phrase("Nama"));
            table.addCell(new Phrase("NIM"));
            table.addCell(new Phrase("Jurusan"));
            table.addCell(new Phrase("Email"));
            
            // Menambahkan data mahasiswa ke dalam tabel
            int no = 1;
            for (Mahasiswa mahasiswa : mahasiswas) {
                table.addCell(new Phrase(String.valueOf(no++)));
                table.addCell(new Phrase(mahasiswa.getNama()));
                table.addCell(new Phrase(mahasiswa.getNim()));
                table.addCell(new Phrase(mahasiswa.getJurusan()));
                table.addCell(new Phrase(mahasiswa.getEmail()));
            }
            
            // Menambahkan tabel ke dalam dokumen PDF
            document.add(table);
        } catch (DocumentException | IOException ex) {
            System.err.println(ex.getMessage());
        }

        // Menutup dokumen setelah selesai
        document.close();
    }
}