/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.stage.FileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author THEOLDISBACK
 */
public class Pdfgenerator {
      public void generatePdfe() {
          
          
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf")
        );
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();

                PdfPTable table = new PdfPTable(9); // 3 columns
                table.setWidthPercentage(100); // set table width to 100% of page
FactureService s = new FactureService();
                // Add table headers
          
                      addTableCell(table, "id_facture ");
                      addTableCell(table, "numero ");
                      addTableCell(table, "nom ");
                      addTableCell(table, "prix ");
                      addTableCell(table, "date ");
                      addTableCell(table, "etat ");
                      addTableCell(table, "description ");
                      addTableCell(table, "image ");
                      addTableCell(table, "id_utilisateur  ");
          
             
              

                // Add table rows
                for (int i = 0; i < s.afficherFacture().size(); i++) {
                    addTableCell(table, ""+s.afficherFacture().get(i).getId_facture());
                    addTableCell(table, ""+s.afficherFacture().get(i).getNumero());
                                        addTableCell(table, ""+s.afficherFacture().get(i).getNom());

                    addTableCell(table, ""+s.afficherFacture().get(i).getPrix());
                    addTableCell(table, ""+s.afficherFacture().get(i).getDate());
                    addTableCell(table, ""+s.afficherFacture().get(i).getEtat());
                    addTableCell(table, ""+s.afficherFacture().get(i).getDescription());
                    addTableCell(table, ""+s.afficherFacture().get(i).getImage());
                    addTableCell(table, ""+s.afficherFacture().get(i).getId_utilisateur());
                }

                document.add(table);
                document.close();
                System.out.println("PDF generated successfully.");
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addTableCell(PdfPTable table, String text) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new com.itextpdf.text.Paragraph(text));
        table.addCell(cell);
    }
 public void generateExcel() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Excel");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel Files", "*.xlsx")
        );
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // Add header row
            Row headerRow = sheet.createRow(0);
            Cell headerCell1 = headerRow.createCell(0);
            headerCell1.setCellValue("id_facture ");
            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("numero ");
            Cell headerCell3 = headerRow.createCell(2);
            headerCell3.setCellValue("nom ");

              Cell headerCell4 = headerRow.createCell(3);
            headerCell4.setCellValue("prix ");
              Cell headerCell5 = headerRow.createCell(4);
            headerCell5.setCellValue("date ");
              Cell headerCell6 = headerRow.createCell(5);
            headerCell6.setCellValue("etat ");
              Cell headerCell7 = headerRow.createCell(6);
            headerCell7.setCellValue("description ");
              Cell headerCell8 = headerRow.createCell(7);
            headerCell8.setCellValue("image ");
              Cell headerCell9 = headerRow.createCell(8);
            headerCell9.setCellValue("id_utilisateur ");
            
            FactureService f = new FactureService();
        
            // Add data rows
            for (int i = 0; i <f.afficherFacture().size(); i++) {
                Row row = sheet.createRow(i);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(f.afficherFacture().get(i).getId_facture());
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(f.afficherFacture().get(i).getNumero());
                                Cell cell3 = row.createCell(2);

                cell3.setCellValue(f.afficherFacture().get(i).getNom());
                          Cell cell4 = row.createCell(3);

                cell4.setCellValue(f.afficherFacture().get(i).getPrix());
                            Cell cell5 = row.createCell(4);

                cell5.setCellValue(f.afficherFacture().get(i).getDate());
                                            Cell cell6 = row.createCell(5);

                cell6.setCellValue(f.afficherFacture().get(i).getEtat());
                                            Cell cell7 = row.createCell(6);

                cell7.setCellValue(f.afficherFacture().get(i).getDescription());
                                            Cell cell8 = row.createCell(7);

                cell8.setCellValue(f.afficherFacture().get(i).getImage());
                                            Cell cell9 = row.createCell(8);

                cell9.setCellValue(f.afficherFacture().get(i).getId_utilisateur());
                                                           Cell cell22 = row.createCell(9);

            }

            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                workbook.write(fileOut);
                workbook.close();
                System.out.println("Excel generated successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
