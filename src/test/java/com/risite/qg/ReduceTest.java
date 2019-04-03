package com.risite.qg;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;


public class ReduceTest {
    
    public static void main(String[] args) throws Exception{
        List<Foo> fooList = Lists.newArrayList(
            new Foo("A","san",1.0,2),
            new Foo("A","nas",13.0,1),
            new Foo("B","san",112.0,3),
            new Foo("C","san",43.0,5),
            new Foo("B","nas",77.0,7)
        );
        List<Bar> barList = Lists.newArrayList();
        fooList
            .stream()
            .collect(Collectors.groupingBy(Foo::getName,Collectors.toList()))
            .forEach((name,fooListByName)->{
                Bar bar = new Bar();
                bar = fooListByName
                        .stream()
                        .reduce(bar,(u,t)->u.sum(t),(u,t)->u);
                System.out.println(bar.toString());
                barList.add(bar);
            });
    }
    /*
    ������
    name:A
    count:3
    totalTypeValue:14.0
    bazList:
        type:san
        typeValue:1.0
        type:nas
        typeValue:13.0
    
    name:B
    count:10
    totalTypeValue:189.0
    bazList:
        type:san
        typeValue:112.0
        type:nas
        typeValue:77.0
    
    name:C
    count:5
    totalTypeValue:43.0
    bazList:
        type:san
        typeValue:43.0
    */
}
