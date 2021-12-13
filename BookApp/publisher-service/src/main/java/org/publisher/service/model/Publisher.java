package org.publisher.service.model;

import java.util.List;

public class Publisher {

   private String name;
   private List<Book> b;
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public List<Book> getB() {
    return b;
}
public void setB(List<Book> b) {
    this.b = b;
}
public Publisher(String name, List<Book> b) {
    this.name = name;
    this.b = b;
}
@Override
public String toString() {
    return "Publisher [b=" + b + ", name=" + name + "]";
}

   
    
}
