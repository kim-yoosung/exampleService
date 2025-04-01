package com.example.exampleservice.config;

import javax.sql.rowset.CachedRowSet;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class BlobFileReader {
    public static void main(String[] args) {
        // dat 파일 경로를 절대 경로 또는 상대 경로로 지정
        String filePath = "logs/blob-1743492388089.dat";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            CachedRowSet crs = (CachedRowSet) ois.readObject();

            int columnCount = crs.getMetaData().getColumnCount();

            System.out.println("=== BLOB 파일 내용 ===");
            while (crs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(crs.getMetaData().getColumnLabel(i) + ": " + crs.getString(i) + " | ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("역직렬화 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
