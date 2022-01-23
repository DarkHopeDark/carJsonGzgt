package com.jsonfile.newformat.outputFormat;

import java.util.ArrayList;
import java.util.List;

public class models {
    String name;
    List <versions> Versions = new ArrayList<>();
    
    public models() {
    }
    
    public models(String name, List<versions> versions) {
        this.name = name;
        Versions = versions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<versions> getVersions() {
        return Versions;
    }

    public void setVersions(versions versionToAdd) {
        Versions.add(versionToAdd);
    }
}
