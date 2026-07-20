package org.example;

public abstract class ReportGenerator {

    public final void generateReport(){
        fetchData() ;
        processData() ;
        exportReport() ;
    }

    public void fetchData(){
        System.out.println("Fetching Data ....");
    }

    public void processData(){
        System.out.println("processing Data ....");
    }

    public abstract void exportReport() ;
}
