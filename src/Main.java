import java.util.Scanner;

/*!***************************************************
 *  Main
 * ======
 * @author : Randolfo A Goncalves
 * @file   : Main.java 
 * @date   : 01-04-24
 *****************************************************/
class Main{
//  Fields
// ========
    //! Coulors 
    private static Scanner read = new Scanner(System.in);    
    private static final String 
            rd="\033[31m",
            yl="\033[32m",
            ge="\033[33m",
            df="\033[0m";

//  Methods
// =========
    static int Layout(){
        System.out.println(
            " ---"+yl+" Zebra de Ouro 2024 "+df+"--- \n"+
            " -------------------------- \n"+
            "\n\n"+
            rd+" 1"+df+" -> Fazer uma Aposta\n"+
            rd+" 0"+df+" -> Sair\n"+
            " -------------------------- \n"+
            yl+"--> "+df
        );
        return read.nextInt();
    }
    
    static void start(){
        switch(Layout()){
            case 0: return;
            case 1: {} break;
        
        }start();
    }

    public static void main(String[] args) {
        start();
    }
}
