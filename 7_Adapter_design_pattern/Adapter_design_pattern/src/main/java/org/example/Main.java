package org.example;

import org.example.addaptee.LegacyPrinter;
import org.example.addapter.PrinterAddapter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LegacyPrinter lp = new LegacyPrinter() ;
        PrinterAddapter printerAddapter = new PrinterAddapter(lp);

        printerAddapter.print("Hello");
    }
}