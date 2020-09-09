//Character class, stores values for characters


public class Character {
   private int [] characteristics;
   private int cwounds, twounds, cfate, tfate, cexperience, texperience, aprarm, aplarm, aprleg, aplleg, aphead, apbody, tbrarm, tblarm, tbrleg, tblleg, tbhead, tbbody, skrarm, sklarm, skrleg, sklleg, skhead, skbody;
   private String appearance, aptitudes, charclass, cybernetics, demeanor, homeworld, kit, regiment, skills, special, talents, traits, notes, awrarm, awlarm, awrleg, awlleg, awhead, awbody;
   private Regiment yourRegiment;
   
   public Character() {
      
      //character's regiment
      yourRegiment = new Regiment();
      
      //characteristics
      characteristics = new int[9];
      for (int i : characteristics) {
         i = 0;
      }
      
      //fate points
      cfate = 0;//current fate points
      tfate = 0;//total fate points
      
      //wounds
      cwounds = 0;//current wounds
      twounds = 0;//total wounds
      
      //experience
      cexperience = 0;
      texperience = 0;
      
      //armor values 
      aprarm = 0;//right arm
      aplarm = 0;//left arm
      aprleg = 0;//right leg
      aplleg = 0;//left leg
      aphead = 0;//head
      apbody = 0;//body
      
      //toughness bonus values
      tbrarm = (characteristics[3] / 10);//right arm
      tblarm = (characteristics[3] / 10);//left arm
      tbrleg = (characteristics[3] / 10);//right leg
      tblleg = (characteristics[3] / 10);//left leg
      tbhead = (characteristics[3] / 10);//head
      tbbody = (characteristics[3] / 10);//body
      
      //soak values
      skrarm = aprarm + tbrarm;//right arm
      sklarm = aplarm + tblarm;//left arm
      skrleg = aprleg + tbrleg;//right leg
      sklleg = aplleg + tblleg;//left leg
      skhead = aphead + tbhead;//head
      skbody = apbody + tbbody;//body
      
      //armor worn
      awrarm = "";//right arm
      awlarm = "";//left arm
      awrleg = "";//right leg
      awlleg = "";//left leg
      awhead = "";//head
      awbody = "";//body
      
      //other stuff, self explanatory
      appearance = "";
      aptitudes = ""; 
      charclass = "";
      cybernetics = "";
      demeanor = "";
      homeworld = "";
      kit = "";
      talents = "";
      traits = "";
      skills = "";
      special = "";
      notes = "";
      
   }//end of Character      
}//end of Character class