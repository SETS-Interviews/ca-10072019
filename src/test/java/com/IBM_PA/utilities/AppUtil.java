package com.IBM_PA.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppUtil {

    public static int removeDot(String data){
        return Integer.parseInt(data.substring(0,data.indexOf(".")));
    }

    public static void generateReport() throws IOException, SQLException {

        System.out.println("\n" + "generating the report...");

        ResultSet redFruits = DBHelper.getRedFruits();

        if (redFruits == null){
            throw new SQLException();
        }

        List<String> lines = new ArrayList<>();

        while (redFruits.next()){
            String fruit_name = redFruits.getString("FRUIT_NAME");
            lines.add(fruit_name);
        }

        Path file = Paths.get("TheReport.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

}
