package com.example.study.testDemo.controller;

import com.alanpoi.analysis.common.enums.ExcelType;
import com.alanpoi.analysis.common.utils.ExcelExportUtil;
import com.alanpoi.analysis.common.utils.ExcelImportUtil;
import com.alanpoi.analysis.excel.imports.ExcelImportRes;
import com.example.study.facade.Districts;
import com.example.study.service.IDistrictsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class TestExcelCntroller {
    @Autowired
    private IDistrictsService districtsService;

    @GetMapping("/export")
    public String exportExcel(@RequestParam(value = "str") String str,HttpServletRequest request,HttpServletResponse response){
       /* 方式一. 直接导出到浏览器

        ExcelExportUtil.export(Colletion<?>,Class,HttpServletRequest,HttpServletResponse,fileName);
        方式二. 调用getWorkbook获取工作表，自行处理workbook

        ExcelExportUtil.getWorkbook(Collection<?> singleSheetData, Class<?> c)
*/
        List<Districts> districts = districtsService.selectDistrictsList(new Districts());

        ExcelExportUtil.export(ExcelType.EXCEL_2003,districts,Districts.class,request,response,"hello.xlsx");

        return "收到:";
    }

    @PostMapping("/import")
    public String importExcel(@RequestParam("file") MultipartFile multipartFile){
       /* 方式一. 直接导出到浏览器

        ExcelExportUtil.export(Colletion<?>,Class,HttpServletRequest,HttpServletResponse,fileName);
        方式二. 调用getWorkbook获取工作表，自行处理workbook

        ExcelExportUtil.getWorkbook(Collection<?> singleSheetData, Class<?> c)
*/

        try {
            InputStream inputStream = multipartFile.getInputStream();
            String originalFilename = multipartFile.getOriginalFilename();
            ExcelImportRes account = ExcelImportUtil.customImportData("ACCOUNT",inputStream , originalFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "收到:";
    }

}
