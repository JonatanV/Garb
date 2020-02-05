import java.util.Random;

//A Java Program to illustrate Caesar Cipher Technique
class CaesarCipher {
    // Encrypts text using a shift od s
    public static StringBuffer encrypt(String text, int s) {

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }


        // Driver code
    public static void main(String[] args){
        int s = 4;
        boolean x = true;
            for (int n = 8; n <=100 ; n++) {
                String input = RandomString.getAlphaNumericString(n);
                System.out.println("Text:  " + input);
                System.out.println("Shift : " + s);
                long starttime = System.nanoTime();
                System.out.println("Cipher: " + encrypt(input, s));
                long timepassed = System.nanoTime() - starttime;
                System.out.println("Input length: "+input.length());
                System.out.println("Encryption finished in " + timepassed + " Nanoseconds"+"\n");
            }
       }
    public static class RandomString {
        public static Random r;
        int n;

        // function to generate a random string of length n
        public static String getAlphaNumericString(int n) {
            r = new Random();
            // chose a Character random from this String
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvxyz";

            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {

                // generate a random number between
                // 0 to AlphaNumericString variable length
                int index = (int) (AlphaNumericString.length() * r.nextDouble());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }

            return sb.toString();
        }


    }
}

