package com.example.study.testDemo.alanpoiExcel;

import com.alanpoi.analysis.excel.imports.ExcelSheetData;
import com.alanpoi.analysis.excel.imports.handle.ExcelConsumeInterface;
import com.alanpoi.analysis.excel.imports.handle.ExcelError;
import com.example.study.facade.Districts;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//不能用，导入不行，网上示例也少
@Component
public class CosumeHandle implements ExcelConsumeInterface {

    @Override
    public void error(ExcelError excelError) {

    }

    @Override
    public void validData(String workbookId, List<ExcelSheetData> sheetDataList, Map<Serializable, Object> excelParam) {

    }

    @Override
    public void end(List<ExcelSheetData> sheetDataList, Map<Serializable, Object> excelParam) {
        for (ExcelSheetData excelSheetData : sheetDataList) {
            System.out.println("==========  sheetDataList  ======== ");
            List<Districts> data = excelSheetData.getData();
            for (Districts datum : data) {
                System.out.println(datum);
            }
        }
    }
}
