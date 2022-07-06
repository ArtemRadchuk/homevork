package repository;

import model.XlsxModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {

    public void write(List<XlsxModel> modelList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        Cell seriesCell = row.createCell(0);
        seriesCell.setCellValue("Серия");
        Cell typeCell = row.createCell(1);
        typeCell.setCellValue("Тип");
        Cell articleCell = row.createCell(2);
        articleCell.setCellValue("Артикул");
        Cell nameCell = row.createCell(3);
        nameCell.setCellValue("Наименование");
        Cell executionCell = row.createCell(4);
        executionCell.setCellValue("Исполнения");
        Cell lengthCell = row.createCell(5);
        lengthCell.setCellValue("Длина");
        Cell widthCell = row.createCell(6);
        widthCell.setCellValue("Ширина");
        Cell heightCell = row.createCell(7);
        heightCell.setCellValue("Высота");
        Cell thicknessCell = row.createCell(8);
        thicknessCell.setCellValue("Толщина");
        Cell weightCell = row.createCell(9);
        weightCell.setCellValue("Масса");
        Cell perforationCell = row.createCell(10);
        perforationCell.setCellValue("Шаг перфорации");
        Cell stepCell = row.createCell(11);
        stepCell.setCellValue("Шаг монтажа");
        int i = 1;
        for (XlsxModel model : modelList) {
                row = sheet.createRow(i);
                Cell series = row.createCell(0);
                if (model.getCommentSeries() != null) {
                    addComment(workbook, sheet, series.getRowIndex(), series.getColumnIndex(), model.getCommentSeries());
                }
                series.setCellValue(model.getSeries());

                Cell type = row.createCell(1);
                type.setCellValue(model.getType());
                if (model.getCommentType() != null) {
                    addComment(workbook, sheet, type.getRowIndex(), type.getColumnIndex(), model.getCommentType());
                }

                Cell article = row.createCell(2);
                article.setCellValue(model.getArticle());
                if (model.getCommentArticle() != null) {
                    addComment(workbook, sheet, article.getRowIndex(), article.getColumnIndex(), model.getCommentArticle());
                } else if (model.getArticle() == null) {
                    addComment(workbook, sheet, article.getRowIndex(), article.getColumnIndex(), "Поле \"Артикул\" не может быть пустым");
                }

                Cell name = row.createCell(3);
                name.setCellValue(model.getName());
                if (model.getCommentName() != null) {
                    addComment(workbook, sheet, name.getRowIndex(), name.getColumnIndex(), model.getCommentName());
                }

                Cell execution = row.createCell(4);
                execution.setCellValue(model.getExecution());
                if (model.getCommentExecution() != null) {
                    addComment(workbook, sheet, execution.getRowIndex(), execution.getColumnIndex(), model.getCommentExecution());
                }

                Cell length = row.createCell(5);
                length.setCellValue(model.getLength());

                Cell width = row.createCell(6);
                width.setCellValue(model.getWidth());

                Cell height = row.createCell(7);
                height.setCellValue(model.getHeight());

                Cell thickness = row.createCell(8);
                thickness.setCellValue(model.getThickness());

                Cell weight = row.createCell(9);
                weight.setCellValue(model.getWeight());
                if (model.getCommentWeight() != null) {
                    addComment(workbook, sheet, weight.getRowIndex(), weight.getColumnIndex(), model.getCommentWeight());
                }

                Cell perforation = row.createCell(10);
                perforation.setCellValue(model.getPerforation());

                Cell step = row.createCell(11);
                step.setCellValue(model.getStep());
                i++;

        }
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(1);
        workbook.write(new FileOutputStream("C:\\Users\\User\\IdeaProjects\\homework\\LoadAndCheck\\src\\main\\resources\\KTI2.xlsx"));
        workbook.close();
    }

    public Cell getOrCreateCell(Sheet sheet, int rowIdx, int colIdx) {
        Row row = sheet.getRow(rowIdx);
        if (row == null) {
            row = sheet.createRow(rowIdx);
        }

        Cell cell = row.getCell(colIdx);
        if (cell == null) {
            cell = row.createCell(colIdx);
        }

        return cell;
    }

    public void addComment(Workbook workbook, Sheet sheet, int rowIdx, int colIdx, String commentText) {
        CreationHelper factory = workbook.getCreationHelper();
        Cell cell = getOrCreateCell(sheet, rowIdx, colIdx);

        ClientAnchor anchor = factory.createClientAnchor();
        anchor.setCol1(cell.getColumnIndex() + 1);
        anchor.setCol2(cell.getColumnIndex() + 3);
        anchor.setRow1(rowIdx + 1);
        anchor.setRow2(rowIdx + 5);

        Drawing drawing = sheet.createDrawingPatriarch();
        Comment comment = drawing.createCellComment(anchor);
        comment.setString(factory.createRichTextString(commentText));

        cell.setCellComment(comment);
    }
}
