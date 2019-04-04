package com.risite.qg.entity;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="xx_role")
public class Role extends BaseEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"name\":"+name+"}";
    }
}
