package org.example.addapter;

import org.example.addaptee.LegacyPrinter;
import org.example.target.Printer;

public class PrinterAddapter implements Printer {

    LegacyPrinter legacyPrinter ;
    public PrinterAddapter(LegacyPrinter lp){
        this.legacyPrinter = lp ;
    }
    @Override
    public void print(String str){
        legacyPrinter.printText(str);
    }
}
