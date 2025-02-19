// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet;

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;

    /** Private offset that tracks how many positions to shift the index for
    * This cipher */
    private int offset;

    /** Constructor that should define the instance variables, including
     * populating the alphabet
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    CaesarCipher(int offset){
        // Fill in here
        this.offset = offset;
        alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);  //code from source: https://stackoverflow.com/a/27735081/29704452
        }
    }

public char get(int i){
        int len = alphabet.length;
        if (i < 0 || i >= len) {
            throw new ArrayIndexOutOfBoundsException(i);
        }else{
            return alphabet[(i-offset+26)%26];
        }
    }

    /** Implementation of linear search that looks through the alphabet
     * array to identify the position of the passed value
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(char val){
        // This is a stub -- fill in the code and return the
        // value you calculate
        int len = alphabet.length;
        for(int i = 0; i < len; i++){
            if(alphabet[i] == val){
                return i;
            }
        }
        return -1;
    }

    /** Encode a message using the cipher
     * @param T message to encode
    //  * @return encoded message */  
    public String encode(String message){
        // Fill in here and update return statement based on your code
        offset = offset % 26;
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i); // Get character at index i
            //to do: add char case conversion
            if (Character.isLowerCase(c)){ 
                char encodedChar = (char) ((c - 'a' - offset + 26) % 26 + 'a'); //code from source: https://stackoverflow.com/a/20793545/29704452
                encoded.append(encodedChar);
            } else {
                encoded.append(c);
            }
        }
        return encoded.toString(); 
    }

    /** Decode a message using the cipher 
     * @param String message to decode
     * @param int key to use in decoding
     * @return decoded message
    */
    public String decode(String message){
        // Fill in here and update return statement based on your code
        int key = offset % 26;
        StringBuilder decoded = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i); // Get character at index i
            //to do: add char case conversion
            if (Character.isLowerCase(c)){ 
                char decodedChar = (char) ((c - 'a' + key + 26) % 26 + 'a'); //code from source: https://stackoverflow.com/a/20793545/29704452
                decoded.append(decodedChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString(); 
    }

    public static void main(String[] args) {
    }
    
}
