package org.example;

import org.example.commonInterface.FileSystemComponent;
import org.example.composite.Folder;
import org.example.leaf.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root") ;
        Folder f1 = new Folder("Docs") ;
        Folder f2 = new Folder("images") ;

        File file1 = new File("resume.dox") ;
        File file2 = new File("oop.txt") ;

        File img = new File("image.png") ;

        f1.add(file1) ;
        f1.add(file2) ;
        f2.add(img) ;

        root.add(f1) ;
        root.add(f2) ;
        root.ls() ;
        System.out.println("==============================");
        root.openAll();
    }
}