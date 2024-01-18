package ex13;


import java.util.Scanner;
public class backjoon {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int hour = sc.nextInt();
            int min = sc.nextInt();

            if(min < 45) {
                hour --;                              // 45보다 작을시 시간을 -1
                min = 60-(45-min);

                if(hour < 0) {
                    hour = 23;                        // 0 보다 작을시 23시로
                }
                System.out.println(hour + " " + min);
            } else {
                System.out.println(hour + " " + (min - 45));
            }

        }
    }

