package chap03;
class OperatorEx15 { 
      public static void main(String[] args) { 
            char lowerCase = 'a'; 
            char upperCase = (char)(lowerCase - 32); 
            
            System.out.println((int)'a');
            System.out.println((int)'A');
            
            //'z' -> 'Z'
            
            char z = 'z';
            
            System.out.println(z);
            System.out.println((char)(z-32));

            System.out.println(upperCase); 
      } 
} 
