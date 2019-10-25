package com.IBM_PA.tests;

import com.IBM_PA.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class ReadExcel {

    public static SheetData readMethod(String sheetName){

        System.out.println("\n" + sheetName + " reading...");

        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/ManualLoadData.xlsx", sheetName);

        List<String> columnsNames = excelUtil.getColumnsNames();

        SheetData sheetData = new SheetData(sheetName, columnsNames.get(0),columnsNames.get(1),excelUtil.getDataList());

        return sheetData;

    }

}
