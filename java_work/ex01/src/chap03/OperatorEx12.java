package chap03;

// 예제 보고 이해하고..
// 안보고 써보면 된다..
class OperatorEx12 { 
      public static void main(String[] args) { 
            char c1 = 'a';         
            char c2 = c1;          
            char c3 =' ';          

            int i = c1 + 1;       

            c3 = (char)(c1 + 1); 
            c2++; // c2 = c2+1; c2 = 97+1; -> c2= 98 
            c2++; // c2 = c2+1;   c2 = 98+1 -> c2= 99

            System.out.println("i=" + i); 
            System.out.println("c2=" + c2); 
            System.out.println("c3=" + c3); 
      } 
} 
