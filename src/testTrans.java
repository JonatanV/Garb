import java.util.*;

class testTrans {

    private static class RandomString {
        public static Random r;
        public int n;

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
    public static void main(String args[]) {
        String pl;
        long starttime;
        long timepassed;
        for (int i = 8; i <= 100; i++) {
            pl = RandomString.getAlphaNumericString(i);
            starttime = System.nanoTime();
            for (int o = 0; o < 4; o++) {

                String demo = "";
                String s = "";
                int start = 0;

                for (int q = 0; q < pl.length(); q++) {
                    if (pl.charAt(q) == ' ') {
                        s = s + pl.substring(start, q);
                        start = q + 1;
                    }
                }

                s = s + pl.substring(start);

                int k = s.length();
                int l = 0;
                int col = 4;
                int row = s.length() / col;
                char ch[][] = new char[row][col];



                starttime = System.nanoTime();
                for (int w = 0; w < row; w++) {
                    for (int j = 0; j < col; j++) {
                        if (l < k) {
                            ch[w][j] = s.charAt(l);
                            l++;
                        } else {
                            ch[w][j] = '#';
                        }
                    }
                }

                char trans[][] = new char[col][row];
                for (int e = 0; e < row; e++) {
                    for (int j = 0; j < col; j++) {
                        trans[j][e] = ch[e][j];
                    }
                }

//                for (int t = 0; t < col; t++) {
//                    for (int y = 0; y < row; y++) {
//                    }
//                }
            }
            timepassed = (System.nanoTime() - starttime)/5;
            System.out.println(pl.length() + "\t" + timepassed);
        }
    }
}
