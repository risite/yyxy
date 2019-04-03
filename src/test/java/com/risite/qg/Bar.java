package com.risite.qg;

import com.google.common.collect.Lists;

import java.util.List;

public class Bar{
    private String name;
    private Integer count;
    private Double totalTypeValue;
    private List<Baz> bazList;

    public Bar() {
        this.name = null;
        this.count = 0;
        this.totalTypeValue = 0.0;
        this.bazList = Lists.newArrayList();
    }

    public Bar sum(Foo foo){
        if(name == null){
            this.name = foo.getName();
        }
        this.count += foo.getCount();
        this.totalTypeValue += foo.getTypeValue();
        this.bazList.add(new Baz(foo.getType(),foo.getTypeValue()));
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name:").append(this.name).append(System.lineSeparator());
        sb.append("count:").append(this.count).append(System.lineSeparator());
        sb.append("totalTypeValue:").append(this.totalTypeValue).append(System.lineSeparator());
        sb.append("bazList:").append(System.lineSeparator());
        this.bazList.forEach(baz->{
            sb.append("\t").append("type:").append(baz.getType()).append(System.lineSeparator());
            sb.append("\t").append("typeValue:").append(baz.getTypeValue()).append(System.lineSeparator());
        });
        return sb.toString();
    }
}
