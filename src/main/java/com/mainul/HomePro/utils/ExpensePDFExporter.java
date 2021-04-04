package com.mainul.HomePro.utils;

import com.mainul.HomePro.models.Expense;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.util.List;

public class ExpensePDFExporter {
    private List<Expense> listExpenses;

    public ExpensePDFExporter(List<Expense> listExpenses) {
        this.listExpenses = listExpenses;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Expense Type", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Expense Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Expense Amount", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Expense Description", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) throws ParseException, FileNotFoundException {
        for (Expense expense : listExpenses) {
            table.addCell(String.valueOf(expense.getExpenseType().getExpenseTypeName()));
            Date date = expense.getExpenseDate();
            String s;
            Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            s = formatter.format(date);
            table.addCell(s);
            table.addCell(String.valueOf(expense.getExpenseAmount()));
            table.addCell(expense.getDescription());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException, ParseException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Expenses", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }

}
