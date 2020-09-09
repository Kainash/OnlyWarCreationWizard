

//class for regiments

public class Regiment {
      private int[] typemod, hwmod, docmod1, docmod2;
      private int allowance, commandercost, typecost, doccost1, doccost2, dbbonus;
      private String homeworld, homeworldtype, regimenttype, regimentname, commandername, commandertype, doctrine1, doctrine2, drawback; 
      
   
   public Regiment () {
      
      //regiment creation points
      allowance = 12;//Starting regiment creation points  
      commandercost = 0;//cost for regimental commander
      typecost =  0;//cost for regiment type
      doccost1 = 0;//cost for first doctrine
      doccost2 = 0;//cost for second doctrine
      
      //Names and other strings
      homeworld = "";//homeworld name
      homeworldtype = "";//Type of homeworld
      regimentname = "";//Name of regiment
      regimenttype= "";//Type of regiment 
      commandertype = "";//Type of commander
      commandername = "";//Name of commander
      doctrine1 = "";//Type of first doctrine
      doctrine2 = "";//Type of second doctrine
      drawback = "";//Name of drawback
      
      //characteristic modifiers from regiment
      typemod = new int[9];
      hwmod = new int[9];
      docmod1 = new int[9];
      docmod2 = new int[9];
         for (int i = 0; i < 9; i++) {
            typemod[i] = 0;
            hwmod[i] = 0;
            docmod1[i] = 0;
            docmod2[i] = 0;
         }
   }//End of Regiment
}//End of Class