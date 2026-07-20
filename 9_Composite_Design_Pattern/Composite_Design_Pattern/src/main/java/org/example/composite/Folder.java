package org.example.composite;

import org.example.commonInterface.FileSystemComponent;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {

    List<FileSystemComponent>components = new ArrayList<>() ;
    private String name ;
    public  Folder(String  name){
        this.name = name ;
    }
   public void add(FileSystemComponent component){
        components.add(component) ;
    }

    public void remove(FileSystemComponent component){
       components.remove(component) ;
    }
    @Override
    public String ls() {
       components.forEach(component -> {
           System.out.println(component.getName());

       });
       return "" ;
    }

    @Override
    public void openAll() {
        System.out.println(this.name);
        components.forEach(component -> {
//            System.out.println(component.getName());
            component.openAll();
        });
    }
    public  String getName(){
        return this.name ;
    }
}
