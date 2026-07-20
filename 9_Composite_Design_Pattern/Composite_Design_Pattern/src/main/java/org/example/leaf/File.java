package org.example.leaf;

import org.example.commonInterface.FileSystemComponent;

public class File implements FileSystemComponent {

    private String name ;
    public File(String name){
        this.name = name ;
    }
    @Override
    public String ls() {
        return this.name ;
    }

    @Override
    public void openAll() {
        System.out.println(this.name);
    }
    @Override
    public  String getName(){
        return this.name ;
    }
}
