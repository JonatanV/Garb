import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

//A Java Program to illustrate Caesar Cipher Technique
class CaesarCipher
{
    // Encrypts text using a shift od s
    public static StringBuffer encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    // Driver code
    public static void main(String[] args) throws InterruptedException {

        Scanner tgb = new Scanner(System.in);

        System.out.println("Skriv din klartext BARA STORA BOKSTÄVER");
        String text = tgb.nextLine();
        System.out.println("Välj shift");

        int s = tgb.nextInt();
            boolean x = true;

        System.out.println("Text  : " + text);
        System.out.println("Shift : " + s);
        long starttime = System.currentTimeMillis();
        System.out.println("Cipher: " + encrypt(text, s));
        long timepassed=System.currentTimeMillis()-starttime;
        System.out.println("Encryption finished in " + timepassed + " Milliseconds");



    }
}
