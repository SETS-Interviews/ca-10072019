package com.IBM_PA.tests;

import java.util.List;
import java.util.Map;

public class SheetData {

    private String sheetName;
    private String col1Name;
    private String col2Name;
    private List<Map<String, String>> data;

    public SheetData(String sheetName, String col1Name,String col2Name,List<Map<String, String>> data){
        this.sheetName = sheetName;
        this.col1Name = col1Name;
        this.col2Name = col2Name;
        this.data = data;
    }

    public String getSheetName() {
        return sheetName;
    }

    public String getCol1Name() {
        return col1Name;
    }

    public String getCol2Name() {
        return col2Name;
    }

    public List<Map<String, String>> getData() {
        return data;
    }

}
