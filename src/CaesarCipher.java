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
        long starttime;
        long timepassed=0;
        for (int n = 8; n <=100 ; n+=1) {
                String input = RandomString.getAlphaNumericString(n);

                starttime = System.nanoTime();
                for (int i = 0; i < 4; i++) {
                    encrypt(input, s);
                }
                timepassed = (System.nanoTime() - starttime)/5;
                System.out.println(input.length() + "\t" + timepassed);
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
                    "abcdefghijklmnopqrstuvxyz"+"0123456789";

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

