public class Recursion{
    public int fact(int n){
        if (n < 0){
            throw new IllegalArgumentException();
        }
        return factHelper(n, 1);
    }
    
    public int factHelper(int n, int c){
        if (n == 0){
            return c;
        }
        return factHelper(n - 1, c * n);
        
    }
    
    public int fib(int n){
        if (n < 0){
            throw new IllegalArgumentException();
        }
        return fibHelper(n, 1, 0);
    }
    
    public int fibHelper(int n, int o, int p){
        if( n == 0){
            return p;
        }
        return fibHelper(n - 1, o + p, o);
        
    }
    
    
    public double sqrt(double n){
        if (n < 0){
            throw new IllegalArgumentException();
        }
        if (n == 0){
            return 0;
        }
        return sqrtHelper(n, 1);
           
    }
    
    public double sqrtHelper(double n, double guess){
        if ( (Math.abs((guess * guess) - n)) / guess < .00001){
            return guess;
        } 
        return sqrtHelper(n, ((n / guess) + guess) / 2);
    }
    
    public static void main(String[] args){
        
    }

        
    
}