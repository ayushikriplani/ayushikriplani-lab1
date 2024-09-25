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

        rotorValues input = new rotorValues (); 
        
        //char array at the last index move to the top 
        //loop through and do array[i] = array [i+1]
        //boolean check if it equals the current character 
        //TODO
               
    }
    

    public int indexOf(char c){
        //TODO
    }

    public char charAt(int idx){
        //TODO
    }
}
    
