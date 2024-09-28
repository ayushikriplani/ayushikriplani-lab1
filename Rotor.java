public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        char endChar = rotorValues.charAt(rotorValues.length()-1); 
        rotorValues = endChar + rotorValues.substring(0, rotorValues.length()-1);
        if (rotorValues.charAt(0)==startChar){
            return true; 
        }   
        return false;     
    }
    

    public int indexOf(char c){
        char [] convert = rotorValues.toCharArray(); 
        for (int i = 0; i<convert.length; i++){
            if (convert[i] == c){
                return i; 
            }
        }
        return -1;
    }

    public char charAt(int idx){
        char [] convert = rotorValues.toCharArray(); 
        return convert[idx]; 
    }
}
    
