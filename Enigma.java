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
        String decryptedString = new String ("");  
        for (int i = 0; i< message.length(); i++){
            int step1 = rotors[2].indexOf(message.charAt(i)); 
            char step2 = rotors[1].charAt(step1); 
            int step3 = rotors[2].indexOf(step2); 
            char step4 = rotors[0].charAt(step3);
            decryptedString = decryptedString + step4; 
            rotate(); 
        }
        return decryptedString; 
    }


    
    public String encrypt(String message){
        String encryptedString = new String ("");
        for (int i = 0; i< message.length(); i++){
            int step1 = rotors[0].indexOf(message.charAt(i)); 
            char step2 = rotors[2].charAt(step1); 
            int step3 = rotors[1].indexOf(step2); 
            char step4 = rotors[2].charAt(step3);
            encryptedString = encryptedString + step4; 
            rotate(); 
        }
        return encryptedString; 
    }
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
