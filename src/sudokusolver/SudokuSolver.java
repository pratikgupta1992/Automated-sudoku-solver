package sudokusolver;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import javax.swing.*;

public class SudokuSolver implements ActionListener,KeyListener {
    
    JFrame jf = new JFrame();
    static JTextField [][]jtf=new JTextField[9][9];
    JButton b=new JButton("Solve");
    static int[][][] x=new int[9][9][10];
    static int checky=1;
    public SudokuSolver()
    {
        jf.setSize(459, 600);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setResizable(false);
        jf.setLocation(450, 100);
        jf.setTitle("SUDOKO SOLVER");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(b);
        b.setBounds(180, 500, 100, 30);
        b.addActionListener(this);
        for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            
        jtf[i][j]=new JTextField();
        
        
        
        jtf[i][j].setFont(new Font("Arial",Font.BOLD,30));
        jf.add(jtf[i][j]);
        jtf[i][j].setBounds(i*50,j* 50, 50, 50);
        jtf[i][j].setText("");
        
//        jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue.brighter()));
        int r=i,c=j;
                        
                         if(r>=0 && r<=2 && c>=0 && c<=2){
                          jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue.brighter()));
                        }
                        else if(r>=3 && r<=5 && c>=0 && c<=2){
                            jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red.darker()));
                        }
                        else if(r>=6 && r<=8 && c>=0 && c<=2){
                            jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue.brighter()));
                        }
                        else if(r>=0 && r<=2 && c>=3 && c<=5){
                           jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red.darker()));
                        }
                        else if(r>=3 && r<=5 && c>=3 && c<=5){
                            jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue.brighter()));
                        }
                        else if(r>=6 && r<=8 && c>=3 && c<=5){
                            jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red.darker()));
                        }
                        else if(r>=0 && r<=2 && c>=6 && c<=8){
                            jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue.brighter()));
                        }
                        
                        else if(r>=3 && r<=5 && c>=6 && c<=8){
                            
                                    jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red.darker()));
                                
                        }
                        else if(r>=6 && r<=8 && c>=6 && c<=8){
                           
                               jtf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue.brighter()));
                        }
                       
                    
                    
        
        jtf[i][j].addKeyListener(this);
         }
        
        }
        
        jf.getContentPane().setBackground(Color.WHITE);
    }
    
    public void input(int[][][] x){
        x[0][0][0]=1;
        x[0][2][0]=3;
        x[0][4][0]=4;
        x[0][6][0]=8;
        x[0][8][0]=5;
        x[1][0][0]=7;
        x[1][4][0]=9;
        x[1][7][0]=2;
        x[1][8][0]=1;
        x[2][2][0]=6;
        x[2][4][0]=2;
        x[2][5][0]=5;
        x[2][6][0]=4;
        x[3][1][0]=6;
        x[3][3][0]=9;
        x[3][8][0]=8;
        x[4][2][0]=2;
        x[4][6][0]=9;
        x[5][0][0]=8;
        x[5][5][0]=4;
        x[5][7][0]=5;
        x[6][2][0]=4;
        x[6][3][0]=5;
        x[6][4][0]=8;
        x[6][6][0]=2;
        x[7][0][0]=2;
        x[7][1][0]=7;
        x[7][4][0]=1;
        x[7][8][0]=3;
        x[8][0][0]=5;
        x[8][2][0]=9;
        x[8][4][0]=6;
        x[8][6][0]=1;
        x[8][8][0]=4;
        
//        x[0][0][0]=5;
//        x[0][4][0]=8;
//        x[0][7][0]=4;
//        x[0][8][0]=6;
//        x[1][5][0]=4;
//        x[1][8][0]=2;
//        x[2][2][0]=6;
//        x[2][3][0]=1;
//        x[2][4][0]=9;
//        x[3][2][0]=5;
//        x[3][5][0]=2;
//        x[3][7][0]=8;
//        x[4][0][0]=9;
//        x[4][2][0]=1;
//        x[4][6][0]=2;
//        x[4][8][0]=3;
//        x[5][1][0]=8;
//        x[5][3][0]=4;
//        x[5][6][0]=6;
//        x[6][4][0]=2;
//        x[6][5][0]=3;
//        x[6][6][0]=8;
//        x[7][0][0]=6;
//        x[7][3][0]=9;
//        x[8][0][0]=2;
//        x[8][1][0]=7;
//        x[8][4][0]=5;
//        x[8][8][0]=9;
////            /*x[0][1][0]=1;
////            x[0][2][0]=7;
////            x[0][3][0]=3;
////            x[0][4][0]=8;
////            x[0][6][0]=2;
////            x[1][0][0]=9;
////            x[1][5][0]=7;
////            x[1][6][0]=8;
////            x[1][7][0]=3;
////            x[1][8][0]=5;
////            x[2][0][0]=3;
////            x[2][1][0]=8;
////            x[2][3][0]=5;
////            x[2][5][0]=9;
////            x[2][7][0]=7;
////            x[3][0][0]=8;
////            x[3][2][0]=4;
////            x[3][5][0]=1;
////            x[3][7][0]=9;
////            x[3][8][0]=2;
////            x[4][0][0]=6;
////            x[4][3][0]=2;
////            x[4][4][0]=9;
////            x[4][6][0]=3;
////            x[4][7][0]=4;
////            x[5][0][0]=2;
////            x[5][2][0]=9;
////            x[5][4][0]=4;
////            x[5][5][0]=3;
////            x[5][8][0]=6;
////            x[6][1][0]=6;
////            x[6][2][0]=3;
////            x[6][3][0]=9;
////            x[6][6][0]=1;
////            x[6][8][0]=4;
////            x[7][1][0]=9;
////            x[7][3][0]=4;
////            x[7][4][0]=3;
////            x[7][6][0]=6;
////            x[7][7][0]=2;
////            x[7][8][0]=7;
//            x[8][1][0]=2;
//            x[8][2][0]=8;
//            x[8][4][0]=7;
//            x[8][5][0]=6;
//       
//      */
        
//       String str;
//           for(int i=0;i<9;i++)
//            {
//                for(int j=0;j<9;j++)
//                {
//                    str=jtf[j][i].getText();
//                    if(str.equals(""))
//                    {
//                        x[i][j][0]=0;
//                    }
//                    else
//                    {
//                        x[i][j][0]=Integer.parseInt(str);
//                    }
//                }
//            }
           for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    for (int k = 1; k < 10; k++) {
                        if(x[i][j][0]==0)
                        x[i][j][k]=k;
                        else
                            x[i][j][k]=-1;
                    }
                    
                }
                
            }
       
    }
     public static void displayOps(int[][][] x){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println("i,j:"+i+j);
                System.out.print("K:");
                for (int k = 1; k < 10; k++) {
                    if(x[i][j][k]!=-1)
                    System.out.print(" "+x[i][j][k]);
                    
                }
                System.out.println("");
                
    }
        }
     }
    
    public static void display(int[][][] x){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(x[i][j][0]+"\t");
                
                 jtf[j][i].setText("  "+String.valueOf(x[i][j][0]));
            }
                    System.out.println("");
                   
        }
        
    }
    
    public static int finalCheck(int[][][] x){
        try{
            System.out.println("final check start");
            SudokuSolver.displayOps(x);
            checkOptionsRow(x);
            checkOptionsColumn(x);
            checkOptionsGrid(x);
            checkList(x);
            singleOpt(x);
        int f=0;
        for (int i = 0; i < 9; i++) {
            if(f==1)
                break;
            for (int j = 0; j < 9; j++) {
                if(f==1)
                break;
                for (int k = 1; k < 10; k++) {
                    if(x[i][j][k]!=-1){
                    f=1;
                    break;
                    }
                }
                
            }
            
        }
        if(f==1)
        return 1;
        else
            return 0;
        }
        catch(Exception e){
            System.out.println("ERROR in final check");
            return 1;
        }
    }
    
    public static void checkOptionsRow(int[][][] x){
        try{
        System.out.println("check option row start"); 
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(x[i][j][0]!=0){
                        int ka=x[i][j][0];
                        for (int ja = 0; ja < 9; ja++) {
                            x[i][ja][ka]=-1;
                        }
                    }
                    
                }
                
            }
     
        }
        catch(Exception e){
            System.out.println("ERROR in check options"+e+"message"+e.getMessage());
        }
    }
    public static void checkOptionsColumn(int[][][] x){
        try{
        System.out.println("check option column start"); 
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(x[i][j][0]!=0){
                        int ka=x[i][j][0];
                        for (int ia = 0; ia < 9; ia++) {
                            x[ia][j][ka]=-1;
                        }
                    }
                    
                }
                
            }
     
        }
        catch(Exception e){
            System.out.println("ERROR in check options"+e+"message"+e.getMessage());
        }
    }
    public static void checkOptionsGrid(int[][][] x){
        try{
        System.out.println("check option grid start"); 
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(x[i][j][0]!=0){
                        int ka=x[i][j][0];
                        int r=i,c=j;
                        if(r>=0 && r<=2 && c>=0 && c<=2){
                            for (int m = 0; m < 3; m++) {
                                for (int n = 0; n < 3; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else if(r>=3 && r<=5 && c>=0 && c<=2){
                            for (int m = 3; m < 6; m++) {
                                for (int n = 0; n < 3; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else if(r>=6 && r<=8 && c>=0 && c<=2){
                            for (int m = 6; m < 9; m++) {
                                for (int n = 0; n < 3; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else if(r>=0 && r<=2 && c>=3 && c<=5){
                            for (int m = 0; m < 3; m++) {
                                for (int n = 3; n < 6; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else if(r>=3 && r<=5 && c>=3 && c<=5){
                            for (int m = 3; m < 6; m++) {
                                for (int n = 3; n < 6; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else if(r>=6 && r<=8 && c>=3 && c<=5){
                            for (int m = 6; m < 9; m++) {
                                for (int n = 3; n < 6; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else if(r>=0 && r<=2 && c>=6 && c<=8){
                            for (int m = 0; m < 3; m++) {
                                for (int n = 6; n < 9; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        
                        else if(r>=3 && r<=5 && c>=6 && c<=8){
                            for (int m = 3; m < 6; m++) {
                                for (int n = 6; n < 9; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else if(r>=6 && r<=8 && c>=6 && c<=8){
                            for (int m = 6; m < 9; m++) {
                                for (int n = 6; n < 9; n++) {
                                    x[m][n][ka]=-1;
                                }
                                
                            }
                        }
                        else{
                            System.out.println("galti krdi kahi");
                        }
                    }
                    
                }
                
            }
     
        }
        catch(Exception e){
            System.out.println("ERROR in check options"+e+"message"+e.getMessage());
        }
    }
    
    public static void checkList(int[][][] x){  //for checking list of available digits
        try{
        System.out.println("check list start");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int count=0,dig=0;
                if(x[i][j][0]!=0){continue;}
                for (int k = 1; k < 10; k++) {
                    if(x[i][j][k]!=-1){
                        count++;    //counts the number of choices available for spot x[i][j]
                        dig=x[i][j][k];
                    }
                }
                if(count==1 && x[i][j][0]==0){   //if only a single choice is available for a spot then fill the space
                    x[i][j][0]=dig;
                    x[i][j][dig]=-1;
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    display(x);
                    if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                }
                else if(count==1 && x[i][j][0]!=0){
                    System.out.println("overwrite requested for i,j,ele:"+i+j+x[i][j][0]);
                }
            }
            
        }
        }
        catch(Exception e){
            System.out.println("ERROR in check list"+e.getMessage());
            e.printStackTrace();
        }
    }
    public static void checkListLevelOne(int[][][] y){  //for checking list of available digits
        try{
            LinkedList<Integer> lst=new LinkedList<>();
            LinkedList<Integer> lsti=new LinkedList<>();
            LinkedList<Integer> lstj=new LinkedList<>();
        System.out.println("check list level start-----------------------------------------------");
        int f=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(y[i][j][0]==0){
                int count=0;
                for (int k = 1; k < 10; k++) {
                    if(y[i][j][k]!=-1){
                        count++;    //counts the number of choices available for spot x[i][j]
                        lst.add(y[i][j][k]);
                        lsti.add(i);
                        lstj.add(j);
                    }
                }
                if(count==2){   // and the trial starts here
                    int [][][] z=new int[9][9][10];
                    z=copy(y);
                    y[lsti.getFirst()][lstj.getFirst()][0]=lst.getFirst();
                    y[lsti.getFirst()][lstj.getFirst()][lst.getFirst()]=-1;
                    int cntry=0,checkz=1,cntrz=0;
                    checky=1;
                    display(y);
                    
                    if(finalCheck(y)==0){
                        display(y);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                    while(checky==1){
                        cntry++;
                        System.out.println("------------------------------------------cntry:"+cntry);
                        if(cntry<100){
                        checky=finalCheck(y);
                        System.out.println("----------------------------checky-cntry:"+checky);
                        }
                        else
                            break;
                        
                    }
                    cntry=0;
                    if(checky!=1){System.out.println("i think solved y");display(y);
                    if(finalCheck(y)==0){
                        display(y);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                    f=1; break;}
//                    else{
//                        while(checky==1){
//                        cntry++;
//                        System.out.println("------------------------------------------cntrly:"+cntry);
//                        if(cntry<100){
//                            
//                            checky=finalCheck(y);
//                            System.out.println("----------------------------checky-cntrly:"+checky);
//                        }
//                            else
//                            break;
//                        
//                    }
//                        
//                        
//                    }
                    z[lsti.getLast()][lstj.getLast()][0]=lst.getLast();
                    z[lsti.getLast()][lstj.getLast()][lst.getLast()]=-1;
                    while(checky==1){
                        cntrz++;
                        System.out.println("------------------------------------------cntrlz:"+cntrz);
                        if(cntrz<100){
                            checky=finalCheck(z);
                            System.out.println("----------------------------checkz-cntrlz:"+checky);
                        }
                            else
                            break;
                        
                    }
                    cntrz=0;
                    if(checky!=1){ cntrz=0;System.out.println("i think solved z");display(z);
                    if(finalCheck(z)==0){
                        display(z);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                    f=1; break;}
//                    else{
//                        while(checkz==1){
//                        cntrz++;
//                        System.out.println("------------------------------------------cntrlz:"+cntrz);
//                        if(cntrz<100){
//                            
//                            checkz=finalCheck(z);
//                            System.out.println("----------------------------checkz-cntrlz:"+checkz);
//                        }
//                            else
//                            break;
//                        
//                    }
//                        
//                        
//                    }
                }
            } 
            }
            if(f==1)
                break;
                
            
        }
        }
        catch(Exception e){
            System.out.println("ERROR in check list");
        }
    }
    public static void checkListLevelTwo(int[][][] y){  //for checking list of available digits
        try{
            LinkedList<Integer> lst=new LinkedList<>();
            LinkedList<Integer> lsti=new LinkedList<>();
            LinkedList<Integer> lstj=new LinkedList<>();
        System.out.println("check list level start-----------------------------------------------");
        for (int i = 0; i < 9; i++) {
            int f=0;
            for (int j = 0; j < 9; j++) {
                if(y[i][j][0]==0){
                int count=0;
                for (int k = 1; k < 10; k++) {
                    if(y[i][j][k]!=-1){
                        count++;    //counts the number of choices available for spot x[i][j]
                        lst.add(y[i][j][k]);
                        lsti.add(i);
                        lstj.add(j);
                    }
                }
                if(count==3){   // and the trial starts here
                    int [][][] z=new int[9][9][10];
                    z=copy(y);
                    int [][][] t=new int[9][9][10];
                    t=copy(y);
                    y[lsti.getFirst()][lstj.getFirst()][0]=lst.getFirst();
                    y[lsti.getFirst()][lstj.getFirst()][lst.getFirst()]=-1;
                    int cntry=0,checkz=1,cntrz=0,checkt=1,cntrt=0;
                    checky=1;
                    display(y);
                    while(checky==1){
                        cntry++;
                        System.out.println("------------------------------------------cntry:"+cntry);
                        if(cntry<100){
                        checkListLevelOne(y);
                        System.out.println("----------------------------checky-cntry:"+checky);
                        }
                        else
                            break;
                        
                    }
                    if(checky!=1){System.out.println("i think solved y");display(y);f=1; break;}
                    z[lsti.getLast()][lstj.getLast()][0]=lst.getLast();
                    z[lsti.getLast()][lstj.getLast()][lst.getLast()]=-1;
                    while(checky==1){
                        cntrz++;
                        System.out.println("------------------------------------------cntrlz:"+cntrz);
                        if(cntrz<100){
                            checkListLevelOne(z);
                            System.out.println("----------------------------checkz-cntrlz:"+checky);
                        }
                            else
                            break;
                        
                    }
                    if(checky!=1){ System.out.println("i think solved z");display(z);f=1; break;}
                    t[lsti.get(1)][lstj.get(1)][0]=lst.get(1);
                    t[lsti.get(1)][lstj.get(1)][lst.get(1)]=-1;
                    while(checky==1){
                        cntrt++;
                        System.out.println("------------------------------------------cntrlt:"+cntrt);
                        if(cntrt<100){
                        checkListLevelOne(t);
                            System.out.println("----------------------------checkt-cntrl:"+checkt);
                        }
                            else
                            break;
                        
                    }
                    if(checky!=1){ System.out.println("i think solved t");display(t);f=1; break;}
                }
            } 
            }
            if(f==1)
                break;
            
        }
        }
        catch(Exception e){
            System.out.println("ERROR in check list");
        }
    }
    public static void checkListLevelThree(int[][][] y){  //for checking list of available digits
        try{
            LinkedList<Integer> lst=new LinkedList<>();
            LinkedList<Integer> lsti=new LinkedList<>();
            LinkedList<Integer> lstj=new LinkedList<>();
        System.out.println("check list level start-----------------------------------------------");
        for (int i = 0; i < 9; i++) {
            int f=0;
            for (int j = 0; j < 9; j++) {
                if(y[i][j][0]==0){
                int count=0;
                for (int k = 1; k < 10; k++) {
                    if(y[i][j][k]!=-1){
                        count++;    //counts the number of choices available for spot x[i][j]
                        lst.add(y[i][j][k]);
                        lsti.add(i);
                        lstj.add(j);
                    }
                }
                if(count==4){   // and the trial starts here
                    int [][][] z=new int[9][9][10];
                    z=copy(y);
                    int [][][] t=new int[9][9][10];
                    t=copy(y);
                    int [][][] v=new int[9][9][10];
                    v=copy(y);
                    y[lsti.getFirst()][lstj.getFirst()][0]=lst.getFirst();
                    y[lsti.getFirst()][lstj.getFirst()][lst.getFirst()]=-1;
                    int cntry=0,checkz=1,cntrz=0,checkt=1,cntrt=0,checkv=1,cntrv=0;
                    checky=1;
                    display(y);
                    while(checky==1){
                        cntry++;
                        System.out.println("------------------------------------------cntry:"+cntry);
                        if(cntry<100){
                        checkListLevelTwo(y);
                        System.out.println("----------------------------checky-cntry:"+checky);
                        }
                        else
                            break;
                        
                    }
                    if(checky!=1){System.out.println("i think solved y");display(y);f=1; break;}
                    z[lsti.getLast()][lstj.getLast()][0]=lst.getLast();
                    z[lsti.getLast()][lstj.getLast()][lst.getLast()]=-1;
                    while(checky==1){
                        cntrz++;
                        System.out.println("------------------------------------------cntrlz:"+cntrz);
                        if(cntrz<100){
                            checkListLevelTwo(z);
                            System.out.println("----------------------------checkz-cntrlz:"+checky);
                        }
                            else
                            break;
                        
                    }
                    if(checky!=1){ System.out.println("i think solved z");display(z);f=1; break;}
                    t[lsti.get(1)][lstj.get(1)][0]=lst.get(1);
                    t[lsti.get(1)][lstj.get(1)][lst.get(1)]=-1;
                    while(checky==1){
                        cntrt++;
                        System.out.println("------------------------------------------cntrlt:"+cntrt);
                        if(cntrt<100){
                        checkListLevelTwo(t);
                            System.out.println("----------------------------checkt-cntrl:"+checky);
                        }
                            else
                            break;
                        
                    }
                    if(checky!=1){ System.out.println("i think solved t");display(t);f=1; break;}
                    v[lsti.get(2)][lstj.get(2)][0]=lst.get(2);
                    v[lsti.get(2)][lstj.get(2)][lst.get(2)]=-1;
                    while(checky==1){
                        cntrv++;
                        System.out.println("------------------------------------------cntrlz:"+cntrv);
                        if(cntrv<100){
                            checkListLevelTwo(v);
                            System.out.println("----------------------------checkz-cntrlz:"+checky);
                        }
                            else
                            break;
                        
                    }
                    if(checky!=1){ System.out.println("i think solved v");display(v);f=1; break;}
                }
            } 
            }
            if(f==1)
                break;
            
        }
        }
        catch(Exception e){
            System.out.println("ERROR in check list");
        }
    }
    public static void singleOpt(int x[][][]){
        try{
        System.out.println("check single option grid start"); 
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(x[i][j][0]==0){
                        int r=i,c=j,countUnique=0;
                        if(r>=0 && r<=2 && c>=0 && c<=2){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 0; m < 3; m++) {
                                for (int n = 0; n < 3; n++) {
                                        if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            
                            
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                            }
                        }
                        else if(r>=3 && r<=5 && c>=0 && c<=2){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 3; m < 6; m++) {
                                for (int n = 0; n < 3; n++) {
                                    if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                }
                        else if(r>=6 && r<=8 && c>=0 && c<=2){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 6; m < 9; m++) {
                                for (int n = 0; n < 3; n++) {
                                    if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                
                            }
                        else if(r>=0 && r<=2 && c>=3 && c<=5){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 0; m < 3; m++) {
                                for (int n = 3; n < 6; n++) {
                                    if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                
                            }
                        else if(r>=3 && r<=5 && c>=3 && c<=5){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 3; m < 6; m++) {
                                for (int n = 3; n < 6; n++) {
                                       if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                
                            }
                        else if(r>=6 && r<=8 && c>=3 && c<=5){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 6; m < 9; m++) {
                                for (int n = 3; n < 6; n++) {
                                    if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                
                            }
                        else if(r>=0 && r<=2 && c>=6 && c<=8){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 0; m < 3; m++) {
                                for (int n = 6; n < 9; n++) {
                                        if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                
                            }
                        
                        else if(r>=3 && r<=5 && c>=6 && c<=8){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 3; m < 6; m++) {
                                for (int n = 6; n < 9; n++) {
                                    if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                
                            }
                        else if(r>=6 && r<=8 && c>=6 && c<=8){
                            for (int k = 1; k < 10; k++) {
                                if(x[i][j][k]==-1){continue;}
                            for (int m = 6; m < 9; m++) {
                                for (int n = 6; n < 9; n++) {
                                        if(x[i][j][k]==x[m][n][k] && (i!=m ||j!=n))
                                        countUnique++;
                                }
                                
                            }
                            if(countUnique==0 && x[i][j][0]==0){
                                x[i][j][0]=k;
                                x[i][j][k]=-1;
                                                                System.out.println("##################################################################");
                                display(x);
                                if(finalCheck(x)==0){
                        display(x);
            JOptionPane.showMessageDialog(null, "Title", "Solved", 1);
        }
                                break;
                            }
                            else
                                countUnique=0;
                                }
                                
                            }
                        else{
                            System.out.println("galti krdi kahi");
                        }
                    }
                    
                }
                
            }
     
        }
        catch(Exception e){
            System.out.println("ERROR in check single opt"+e+"message"+e.getMessage());
        }
    }
    public static int[][][] copy(int x[][][]){
        int [][][] y=new int[9][9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 10; k++) {
                    y[i][j][k]=x[i][j][k];
                }
                
            }
            
        }
        return y;
    }
    
    public static void main(String[] args) {
    
        SudokuSolver s=new SudokuSolver();
    }
      
    
    public void actionPerformed(ActionEvent ae) {
        System.out.println("\t\tSODUKO SOLVER");
        try{
          
            
            input(x);
            SudokuSolver.display(x);
            int check=1,counter=0;
            while(check==1){
                counter++;
                
                
                if(counter<100){
                check=SudokuSolver.finalCheck(x);
                }
                else if(counter<200){
                    int [][][] y=new int[9][9][10];
                    y=SudokuSolver.copy(x);
                    SudokuSolver.checkListLevelOne(y);
                    
                }
                else if(counter<300){
                    int [][][] y=new int[9][9][10];
                    y=SudokuSolver.copy(x);
                    SudokuSolver.checkListLevelTwo(y);
                    
                }
                else if(counter<300){
                    int [][][] y=new int[9][9][10];
                    y=SudokuSolver.copy(x);
                    SudokuSolver.checkListLevelThree(y);
                    
                }
                else
                    break;
            }
                SudokuSolver.display(x);
        }
        
        catch(Exception e){
           e.printStackTrace();
        }  
    }

    public void keyTyped(KeyEvent ke) 
    {
        
        
        
    }

    public void keyPressed(KeyEvent ke) {
//        JOptionPane.showMessageDialog(null, ke.getKeyCode());
//        if(ke.getKeyCode()==37)
//        {
//            jtf[i-1][j].requestFocus();
//        }   
    }

    public void keyReleased(KeyEvent ke) {
       
    }

   
}