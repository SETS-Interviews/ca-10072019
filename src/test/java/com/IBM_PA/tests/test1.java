package com.IBM_PA.tests;

import com.IBM_PA.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class test1 {


    @Test
    public void test() {
        // this utility open the excel based on given path and creates object which is used to work with the given sheet
        ExcelUtil qa3Sheet = new ExcelUtil("src/test/resources/ManualLoadData.xlsx", "FRUIT");

        // 1 based , not 0 based
        int rowCount = qa3Sheet.rowCount();
        // 1 based, not 0 based
        int colCount = qa3Sheet.columnCount();
        System.out.println("rowCount = " + rowCount);
        System.out.println("colCount = " + colCount);

        List<String> columnsNames = qa3Sheet.getColumnsNames();
        System.out.println("columnsNames = " + columnsNames);
        // 0 based, get specific cell value based on index
        String cellData = qa3Sheet.getCellData(2, 1);
        System.out.println("cellData = " + cellData);

        // get all table values in a list
        List<Map<String, String>> dataList = qa3Sheet.getDataList();

        System.out.println(dataList.get(2).get("FRUIT_NAME"));

       //String[][] dataArray = qa3Sheet.getDataArray();

       // System.out.println(dataArray[1][1]);

    }
}