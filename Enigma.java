public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        char [] convert = message.toCharArray(); 
        char [] decryptArray = new char[message.length()]; 
        for(int i = 0; i<convert.length; i++){
            int step1 = rotors[2].indexOf(convert[i]); 
            char step2 = rotors[1].charAt(step1); 
            int step3 = rotors[2].indexOf(step2); 
            char step4 = rotors[0].charAt(step3); 
            decryptArray[i]= step4; 
            rotate();
       }
       String decryptString = decryptArray.toString(); 
       return decryptString; 

    }


    
    public String encrypt(String message){
       char [] convert = message.toCharArray(); 
       char [] encryptArray = new char[message.length()]; 
       for(int i = 0; i<convert.length; i++){
            int step1 = rotors[0].indexOf(convert[i]); 
            char step2 = rotors[2].charAt(step1); 
            int step3 = rotors[1].indexOf(step2); 
            char step4 = rotors[2].charAt(step3); 
            encryptArray[i]= step4; 
            rotate();
       }
       String encryptString = encryptArray.toString(); 
       return encryptString; 

        //get message at index 0 
        // find message in inner ring 
        //same index at outer router 
        //find outer router letter 
        //find same letter in middle row
        //same index on outer ring 

    }
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
}
