package study;

import java.util.HashMap;
class Student{
    String name;
    Integer age;
    Student next;
    public Student(String name,Integer age){
        this.name=name;
        this.age=age;
        next=null;
    }
}
class LinkedList{
    Student head;
    Student tail;
    public LinkedList(){
        head=null;
        tail=null;
    }
    public void add(Student s){
        if(head==null){
            head=tail=s;
            return;
        }
        tail.next=s;
        tail=s;
    }
    public void printAll(){
        Student cur=head;
        while(cur!=null){
            System.out.println(cur.name+" "+cur.age);
            cur=cur.next;
        }
    }
}
public class StringClass {

    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();

        map.put("John",21);
        map.put("Kim",26);
        map.put("James",29);
        LinkedList linkedList=new LinkedList();
        map.forEach((key,value)->{
            Student s = new Student(key,value);
            linkedList.add(s);
            }
        );
        linkedList.printAll();
    }
}
