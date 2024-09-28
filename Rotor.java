public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //String to char array 
        char [] convert = rotorValues.toCharArray(); 
        char save = convert [convert.length]; 
        convert[0] = convert [convert.length]; 
        for(int i = 1; i< convert.length -1; i++){
            convert[i] = convert [i+1]; 
        }
        rotorValues .equals(convert.toString()); 
        if(save == convert [0]){
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
        char [] convert = rotorValues. toCharArray(); 
        return convert[idx]; 
    }
}
    
