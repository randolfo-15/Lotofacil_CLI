/*!***************************************************
 *  Ticket
 * ========
 * @author : Randolfo A Goncalves
 * @file   : Ticket.java 
 * @date   : 01-04-24
 *****************************************************/

import java.util.Random;

abstract class Ticket {
//  Field
// =======
    final static int size = 6;      //< N° maximo de apostas. 
    int[] numbers = new int[size];  //< N° da ccartela. 

//  Methods    
// =========
    // Preenche cartela
    abstract void fill();
}

class Empty_tck extends Ticket{
    //! Build
    Empty_tck(){ fill(); }

    @Override
    public void fill(){ for(int i=0;i<size;i++) numbers[i] = 0; }
}

class Completed_tck extends Ticket{
    //! Build
    Completed_tck(){ fill(); }
   
    @Override
    public void fill(){ for(int i=0;i<size;i++) numbers[i] = new Random().nextInt(1,100);}
}
