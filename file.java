import java.util.*;
public class Main {
     static class stack{
        int[] arr = new int [5];
        int idx=-1;
        
        void push(int val){
            idx++;
           if(idx==5)
           throw new ArithmeticException("Stack overflow");
           System.out.println(val+" at "+idx);
            arr[idx] = val;
        }

        void pop()
        {
            if(idx==-1)
            throw new ArithmeticException("Stack underflow");
            arr[idx]=0;
            idx--;
        }

        void peek()
        {
            if(arr.length==0)
            throw new ArithmeticException("Stack empty");
            System.out.println("peek -> "+arr[idx]);
        }

        
    }

    static class dynamicStack extends stack{
        int[] a = new int[3];
        int maxSize=3;
        int top = -1;
        void pushin(int val){
            if (!isFull()) 
            { 
            top++;
            a[top] = val;
            System.out.println(val+" in dynamic at "+top);
            } 
            else 
            {
            resize(maxSize * 2);
            pushin(val);
            }
        }
        boolean isFull() {
        return (top + 1 == maxSize);
     }

     void resize(int newSize) {
         int[] transferArray = new int[newSize];

         for (int i = 0; i < a.length; i++) {
             transferArray[i] = a[i];
             a = transferArray;
         }
         maxSize = newSize;
    }
    }
    public static void main(String args[]) {
        stack s = new stack();
        dynamicStack ds = new dynamicStack();
        try
        {s.push(1);
        // s.push(2);
        // s.peek();
        // s.pop();
        // s.pop();
        // s.push(3);
        // s.peek();
        ds.pushin(10);
        ds.pushin(11);
        ds.pushin(12);
        ds.pushin(13);
        }
        catch( ArithmeticException e)
        {
            System.out.print("Exception : "+e.getMessage());
        }

        
        

    }
}
