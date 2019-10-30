package com.IBM_PA.tests;

import com.IBM_PA.utilities.AppUtil;
import com.IBM_PA.utilities.DBHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("starting...");

        SheetData fruitSheetData = ReadExcel.readMethod("fruit");
        SheetData colorSheetData = ReadExcel.readMethod("color");
        SheetData fruitXrefColorSheetData = ReadExcel.readMethod("fruitxrefcolor");

        try {
            DBHelper.insertSheetsData(fruitSheetData);
            DBHelper.insertSheetsData(colorSheetData);
            DBHelper.insertSheetsData(fruitXrefColorSheetData);

            System.out.println("\n" + "all sheets inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n" + "insert failed");
        }

        try {
            AppUtil.generateReport();
            System.out.println("\n" + "report generated");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\n" + "report failed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n" + "report failed : no red fruits");
        }

        DBHelper.truncateTables();

        System.out.println("\n" + "program ended");

    }

}
