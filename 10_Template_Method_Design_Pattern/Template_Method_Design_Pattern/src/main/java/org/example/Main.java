package org.example;


public class Main {
    public static void main(String[] args) {
        PDFReportGenerator pdf = new PDFReportGenerator();
        pdf.generateReport();

        ExcelReportGenerator excel  = new ExcelReportGenerator() ;
        excel.generateReport();
    }
}