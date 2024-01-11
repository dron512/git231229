public class Ex02 {

    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        System.out.println(args[3]);

        String a = "ABCDE";

        char [] caa = a.toCharArray();

        System.out.println(caa[0]);

        for (int i = 0; i < caa.length; i++) {
            System.out.println(caa[i]);
        }
    }
}
