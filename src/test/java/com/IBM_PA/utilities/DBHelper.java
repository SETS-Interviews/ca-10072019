package com.IBM_PA.utilities;

import com.IBM_PA.tests.SheetData;

import java.sql.*;
import java.util.ArrayList;

import static com.IBM_PA.utilities.AppConstants.*;

public class DBHelper {

    public static void insertSheetsData(SheetData sheetData) throws SQLException {

        System.out.println("\n" + sheetData.getSheetName() + " table is inserting...");

        PreparedStatement statement = null;

        try {
            Connection conn = DriverManager.getConnection(oracleDbUrl,oracleDbUserName,oracleDbPassword);

            String SQL = "INSERT INTO "
                    +sheetData.getSheetName()
                    +"("+sheetData.getCol1Name()
                    +","+sheetData.getCol2Name()
                    +") "
                    + "VALUES(?,?)";

            statement = conn.prepareStatement(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<String> tempList = new ArrayList<>();

        for(int i=0;i<sheetData.getData().size();i++) {

            int col1 = AppUtil.removeDot(sheetData.getData().get(i).get(sheetData.getCol1Name()));
            String col2 = sheetData.getData().get(i).get(sheetData.getCol2Name());

            if(sheetData.getCol2Name().equalsIgnoreCase("COLOR_ID")){
                col2 = String.valueOf(AppUtil.removeDot(col2));
            } else {
                if(col2 == null)
                    continue;

                if (tempList.contains(col2))
                    continue;

                tempList.add(col2);
            }

            System.out.println(col1 + " - " + col2);

            statement.setInt(1, col1);
            statement.setString(2, col2);

            statement.addBatch();

            statement.executeBatch();

        }

    }

    public static void truncateTables() {

        System.out.println("\n" + "tables are truncating...");

        try {
            Connection conn = DriverManager.getConnection(oracleDbUrl,oracleDbUserName,oracleDbPassword);

            Statement statement = conn.createStatement();

            String SQL1 = "truncate table FRUIT";
            String SQL2 = "truncate table COLOR";
            String SQL3 = "truncate table FRUITXREFCOLOR";

            statement.addBatch(SQL1);
            statement.addBatch(SQL2);
            statement.addBatch(SQL3);

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n" + "truncate failed");
        }

    }

    public static ResultSet getRedFruits(){

        try {
            Connection conn = DriverManager.getConnection(oracleDbUrl,oracleDbUserName,oracleDbPassword);

            Statement statement = conn.createStatement();

            String SQL =
                    "SELECT fruit_name, color_name\n" +
                    "        from fruit f join FRUITXREFCOLOR x\n" +
                    "        on\n" +
                    "        f.fruit_id=x.fruit_id\n" +
                    "        join color c\n" +
                    "        on\n" +
                    "        c.color_id=x.color_id\n" +
                    "        where color_name='Red'";

            ResultSet set = statement.executeQuery(SQL);

            return set;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
