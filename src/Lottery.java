/*!***************************************************
 *  Lottery
 * =========
 * @author : Randolfo A Goncalves
 * @file   : Lottery.java 
 * @date   : 01-04-24
 *****************************************************/

class Lottery{
//  Field
// =======
   private Ticket awarded = new Completed_tck();  

//  Methods
// =========

   //! Comaparar bilhetes 
   private int compare(Ticket tkc){ 
      int hit=0;
         for(var right: awarded.numbers)
            for(var number: tkc.numbers) 
               if(number==right) hit++;
      return hit;
   }

   //! Obter tickt
   static Empty_tck buy_tickt(){ return new Empty_tck(); } 

   //! Preencher bilhete
   static Ticket fill(Empty_tck tck){ return tck; }

   //! Novo jogo
   void new_game(){ awarded = new Completed_tck(); }

   //! Awarded ticket
   int[] awarded(){
      Ticket tkc = new Empty_tck();
      for(int i=0;i<Ticket.size;i++) tkc.numbers[i]=awarded.numbers[i];
      return tkc.numbers;
   }

   /*! Sortear
    * =========
    * @param  : Ticket vazio
    * @return : N° de acertos
   */
   int raffle(Ticket tck){ return compare(tck); }
}









