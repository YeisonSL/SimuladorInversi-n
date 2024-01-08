package tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utilities.constants.Constants.*;

@AllArgsConstructor
public class CreateExcelReport implements Task {

    private String investment;
    private String profits;
    private String days;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Hoja de reporte");

        Map<String, Object[]> datos = new TreeMap<>();
        datos.put("1", new Object[]{HEADER_INVESTMENT, HEADER_PROFITS, HEADER_DAYS});
        datos.put("2", new Object[]{investment, profits, days});

        Set<String> keyset = datos.keySet();
        int rowNumber = ZERO;
        for (String key : keyset) {
            Row row = sheet.createRow(rowNumber++);
            Object[] arregloObjetos = datos.get(key);
            int cellNumber = ZERO;
            for (Object obj : arregloObjetos) {
                Cell cell = row.createCell(cellNumber++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File(String.format("src/test/resources/report/simulador%s.xls", investment)));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static CreateExcelReport withData(String investment, String profits, String days) {
        return instrumented(CreateExcelReport.class, investment, profits, days);
    }

}