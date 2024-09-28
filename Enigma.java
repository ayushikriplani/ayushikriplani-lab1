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
        //initialize empty string     
        String decryptedString = new String ("");  
        //loop through the message 
        for (int i = 0; i< message.length(); i++){
            //find the same letter in the outer rotor 
            int step1 = rotors[2].indexOf(message.charAt(i)); 
            //find the corresponding letter in the middle rotor at the same index
            char step2 = rotors[1].charAt(step1); 
            //find the index of that letter in the outer rotor 
            int step3 = rotors[2].indexOf(step2); 
            //find the corresponding letter in the inner rotor at the same index
            char step4 = rotors[0].charAt(step3);
            //append the letter to the String to create decrypted string 
            decryptedString = decryptedString + step4; 
            //rotate the rotor 
            rotate(); 
        }
        return decryptedString; 
    }


    
    public String encrypt(String message){
        //initialize empty string 
        String encryptedString = new String ("");
        //loop through messsage 
        for (int i = 0; i< message.length(); i++){
            //find same letter in inner rotor as message
            int step1 = rotors[0].indexOf(message.charAt(i)); 
            //find corresponding letter in outer rotor at same index
            char step2 = rotors[2].charAt(step1); 
            //find the index of that letter in middle rotor 
            int step3 = rotors[1].indexOf(step2); 
            //find the corresponding letter in the outer rotor at the same index
            char step4 = rotors[2].charAt(step3);
            //append the letter to the String to create encrypted string 
            encryptedString = encryptedString + step4; 
            //rotate the rotor 
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
