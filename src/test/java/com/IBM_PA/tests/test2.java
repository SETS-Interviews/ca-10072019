package com.IBM_PA.tests;

import com.IBM_PA.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class test2 {
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
        //System.out.println(dataList.get(2).get("FRUIT_NAME"));

    List<String> fn = new ArrayList<>();
    Set<String> st = new HashSet<>();

        for(int i =0; i<rowCount-1;i++){
            fn.add(dataList.get(i).get("FRUIT_NAME"));
            st.add(dataList.get(i).get("FRUIT_NAME"));
        }
        System.out.println(fn+ "  size is : "+  fn.size());
        System.out.println(st+ "  size is : "+  st.size());

       // Assert.assertEquals(fn.size(), st.size(), "fruit name has dublicate");
        Assert.assertFalse(st.contains(null), " table contains null value");
    }
}