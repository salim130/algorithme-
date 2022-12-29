/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp.pkg2.acc;

import java.util.ArrayList;

public class Tp2Acc {

    public static void main(String[] args) {
        MonObjet O = new MonObjet(1,2,7);
        MonObjet O1 = new MonObjet(2,4,10);
        MonObjet O2 = new MonObjet(3,5,12);
        MonObjet O3 = new MonObjet(4,3,8);
       ArrayList<MonObjet> t1 = new ArrayList ();
        t1.add(O);
        t1.add(O1);
        t1.add(O2);
        t1.add(O3);
        int R=SAD_Naif(5, t1, 0);
        System.out.println(R);
        
       
       for(int n=4;n<100;n++){
           ArrayList<MonObjet> t3 = new ArrayList <MonObjet> ();
          for(int j=0;j<n;j++)
          {
          t3.add(new MonObjet(j,(int)(Math.random()*10),(int)(Math.random()*10)));
          }
        
         long time =System.nanoTime();
           SAD_Naif(1000, t3, 0);
           time= System.nanoTime() -time ;
           System.out.println("n="+n +"temp="+time);
    
    }}
    
    
    public static int SAD_Naif(int c, ArrayList<MonObjet> t,int i ){
        
        if (i>=t.size()) return 0;
        int sol1=0,sol2;
        if (t.get(i).poids<=c){
        sol1=t.get(i).gain+SAD_Naif(c-t.get(i).poids, t, i+1);
        }
        
        sol2=SAD_Naif(c, t, i+1);
        
        return Math.max(sol1,sol2);
    
    }
    
    public static ArrayList<MonObjet> SAD_Naif2(int c, ArrayList<MonObjet> s,int i ){
        
        if (i>=s.size()) new ArrayList ();
        ArrayList<MonObjet> sol1 =new ArrayList ();
        ArrayList<MonObjet> sol2 =new ArrayList ();
        if (s.get(i).poids<=c){
        sol1.add(s.get(i));   
        sol1.addAll(SAD_Naif2(c-s.get(i).poids, s,i+1));
        }
        
        sol2.addAll(SAD_Naif2(c, s, i+1));
        
        int gain1=0,gain2=0;
        for (int j=0;j<sol1.size();j++){
        gain1+=sol1.get(j).gain;
       }
       for (int j=0;j<sol2.size();j++){
        gain2+=sol2.get(j).gain;
     
    }
       
       if(gain1>gain2) return sol1;
       else return sol2;
    
        }


 class MonObjet{
     
     public int num;
     public int poids;
     public int gain;
     
    public MonObjet(int num ,int poids, int gain){
    this.num=num;
    this.poids=poids;
    this.gain=gain;
    } 
 }



}