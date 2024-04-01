/*!***************************************************
 *  Main
 * ======
 * @author : Randolfo A Goncalves
 * @file   : Main.java 
 * @date   : 01-04-24
 *****************************************************/
import java.util.Scanner;

class Main{
//  Fields
// ========
    //! Read
    private static Scanner read = new Scanner(System.in);    
    
    //! Coulors 
    private static final String 
            rd="\033[31m",
            yl="\033[33m",
            ge="\033[32m",
            df="\033[0m";
    //! Lottery
    private static Lottery lottery =new Lottery(); 

//  Methods
// =========
    
    // Graphic components: 
    private static String title(){ 
        return bar()+"----------------------"+ge+" Zebra de Ouro 2024 "+df+"----------------------- "+line();
    }
    private static String line() { 
        return "\n----------------------------------------------------------------- \n"; 
    }
    private static String bar() { 
        return "\n=====------------------------------------------------------====== \n"; 
    }
    private static String arrow(){ return ge+" └──» "+df; }
    
    //! Clear terminal
    private static void clear(){ System.out.print("\033\143"); }

    //! Check value
    private static boolean check(int n,int[] list){ 
        for(var number:list) if(n==number) return true;  
        return false;
    } 

    //! Cartela
    private static String chart(Ticket tkc){ 
        String image = "";
        int i = 0;
        
        while(++i<100){
            if(check(i,lottery.awarded())&&check(i,tkc.numbers)) image+=yl;
            else if(check(i,lottery.awarded())) image+=ge;
            else if(check(i,tkc.numbers)) image+=rd;
            if(i<10) image+="0";  
            image+= i+" "+df;
            if(i%10==0) image+=" ";
            if(i%20==0) image+="\n";
        }
        image+="00\n\n"+
            ge+" ■ "+df+" - Sorteado "+
            rd+" ■ "+df+" - Marcado "+
            yl+" ■ "+df+" - Acertou "+
            line()+"  Você acertou "+lottery.raffle(tkc)+" numeros.";
        return image;
    }


    //! Fill ticket
    private static Ticket fill(Ticket tkc){
        System.out.print("[Digite 6 numeros]\n"); 
        for(int i=0;i<Ticket.size;i++) tkc.numbers[i]=read.nextInt();
        return tkc;
    } 

    //! Task 01
    private static void job_01(Ticket tkc){
        clear();
        if(tkc==null) tkc=fill(new Empty_tck());  
        System.out.print(
            title()+
            chart(tkc)+
            bar()
        );
        System.out.print(arrow()+"Nova aposta [y/n]? ");
        if(read.next().equals("n")) System.exit(0);;
    } 
    

    //! Banner
    static int Layout(){
        clear();
        System.out.print(
            title()+
            rd+"\n\t\t\t2"+df+" -> Testar um Ticket\n"+
            rd+"\n\t\t\t1"+df+" -> Fazer uma Aposta\n"+
            rd+"\n\t\t\t0"+df+" -> Sair\n"+
            line()+
            bar()+
            arrow() 
        );
        return read.nextInt();
    }
    
    //! Startup
    static void start(boolean test){
        if(!test) return;
        switch(Layout()){
            case 0: return;
            case 1:job_01(null); break;
            case 2:job_01(new Completed_tck()); break; 
        
        }start(true);
    }

    public static void main(String[] args) { start(true); }
}
