package com.jsonfile.newformat.outputFormat;

import java.util.ArrayList;
import java.util.List;

public class brands {
    String name;
    List<models> Models = new ArrayList<>();
    
    public brands() {
    }

    public brands(String name, List<models> models) {
        this.name = name;
        Models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<models> getModels() {
        return Models;
    }

    public void setModels(models modelToAdd) {
        Models.add(modelToAdd);
    }    
}
