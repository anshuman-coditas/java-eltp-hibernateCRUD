package com;

import Dao.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i,ch = 0;
        Student s;
        List<Student> l;

        do{
            System.out.println("1) Insert\n2) Update\n3) Delete\n4) Exit");
            ch=Integer.parseInt(br.readLine());
            switch (ch){
                case 1:
                    System.out.println("Enter Student Details: ");
                    s=new Student();
                    s.setName(br.readLine());
                    s.setMarks(Float.parseFloat(br.readLine()));
                    i= StudentDao.insert(s);
                    if(i>0)
                        System.out.println("Success");
                    else
                        System.out.println("Again");
                    break;
                case 2:
                    System.out.println("Enter name to update");
                    s=new Student();
                    String n=br.readLine();
                    Float m=Float.parseFloat(br.readLine());
                    i=StudentDao.updateStu(n,m);
                    if(i>0)
                        System.out.println("Success Updated");
                    else
                        System.out.println("Again");
                    break;
                case 3:
                    System.out.println("Enter name to delete");
                    s=new Student();
                    String name=br.readLine();
                    i=StudentDao.deleteStu(name);
                    if(i>0)
                        System.out.println("Success Deleted");
                    else
                        System.out.println("Try");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid");
            }

        }while(true);
    }
}
