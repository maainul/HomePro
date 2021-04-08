package com.mainul.HomePro.utils;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.models.Rent;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RentMonthWisePDFExporter {
    private List<Rent> listRents;

    public RentMonthWisePDFExporter(List<Rent> listRents) {
        this.listRents = listRents;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Date", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Room Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Room Rent", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Gas Bill", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Internet Bill", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Electricity Bill", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) throws ParseException, FileNotFoundException {
        for (Rent rent : listRents) {
            Date date = rent.getRentMonth();
            Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            table.addCell(formatter.format(date));
            table.addCell(rent.getRoom().getRoomName());
            table.addCell(String.valueOf(rent.getRoomRent()));
            table.addCell(String.valueOf(rent.getGasBill()));
            table.addCell(String.valueOf(rent.getInternetBill()));
            table.addCell(String.valueOf(rent.getElectricityBill()));

        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException, ParseException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Rents", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 3.0f,2.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
