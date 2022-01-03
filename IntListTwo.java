import java.util.Scanner;
/**
 * Execute a two-way linked list, When every organ in it is from the - 
 * - class IntNodeTwo 
 *
 * @author (Aviran Dabush)
 * @version (05/06/2019)
 */
public class IntListTwo
{
    // instance variables
    private IntNodeTwo _head, _tail;

    //initiliazing constractor
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }
    //setting constractor
    public IntListTwo(IntNodeTwo h, IntNodeTwo t)
    {
        _head = h;
        _tail = t;
    }
    //methods
    /**
     * adding number to the list
     * @param int 
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public void addNumber(int num) 
    {
        IntNodeTwo n = _head;

        if(_head == null)//chek if the list is empty
        {
            _head = new IntNodeTwo(num);
            _tail = _head;
        }
        else
        {
            while(n != null)
            {
                if(num < n.getNum())
                {
                    if(n == _head)
                    {
                        _head = new IntNodeTwo(num, n, n.getPrev());//set num in the head
                        n.setPrev(_head);
                        break;
                    }
                    else//set num in the middle
                    {
                        IntNodeTwo x = new IntNodeTwo(num, n, n.getPrev());
                        n.getPrev().setNext(x);
                        n.setPrev(x);
                        break;
                    }
                }
                if(n == _tail)
                {
                    IntNodeTwo x = new IntNodeTwo(num);
                    x.setPrev(n);
                    n.setNext(x);
                    _tail = x;
                    break;
                }
                n = n.getNext();
            }
        }
    }

    /**
     * removing number from the list
     * @param int
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public void removeNumber(int num)
    {
        IntNodeTwo n = new IntNodeTwo(num);
        n = _head;

        if(n.getNum() != num && n == _tail){}
        else if(_head == null){} //list is empty. do nothing
        else
        {
            while(num >= n.getNum())
            {
                if(n.getNum() == num)
                {
                    if(n == _head)
                    {
                        _head = _head.getNext();//remove the head, set as head the next one
                        break;
                    }
                    else if(n == _tail)
                    {
                        _tail = n.getPrev();//remove the tail, set as tail the prev one
                        _tail.setNext(n.getNext());
                        break;
                    }
                    else if(n.getNum() == num && n != _head)
                    {
                        n.getPrev().setNext(n.getNext());
                        n.getNext().setPrev(n.getPrev());
                        break;
                    }
                }
                n = n.getNext();
            }
        }
    }

    /**
     * getting as input a list of integers up to -9999, and make a list out of them
     * time complexity: O(n^2)
     * space complexity: O(1)
     */
    public void readToList()
    {
        System.out.println("please enter list of integer numbers.");
        System.out.println("(enter -9999 to done");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if(x != -9999)
        {
            addNumber(x);
            readToList();
        }
    }

    /**
     * return the list in string
     * @return list
     * time complexity: O(n);
     * space complexity: O(n);
     */
    public String toString()
    {
        IntNodeTwo x = _head;
        String print = "{";

        if(x == null) //if the list empty
        {
            print += "}";
            return print;
        }

        else 
        {
            while(x != null)
            {
                if(x == _tail)//if we reached to the end
                {
                    print += x.getNum() +  "}";
                    return print;
                }

                else 
                {
                    print += (x.getNum() + ", ");
                }
                x= x.getNext();
            }
        }
        return print;
    }

    /**
     * calculate the length of given list
     * @return int
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int length()
    {
        IntNodeTwo temp = new IntNodeTwo(0);
        temp = _head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    /**
     * calculate the sum of the numbers in a list
     * @return int
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int sum()
    {
        IntNodeTwo temp = new IntNodeTwo(0);
        temp = _head;//start counting
        int sum = 0;//initiliazing
        while(temp != null)
        {
            sum += temp.getNum();
            temp = temp.getNext();
        }
        return sum;
    }

    /**
     * return the longest sublist who her sum is even number
     * @return int
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int maxLength()
    {
        if(sum() % 2 == 0)
        {
            return length();
        }
        else
        {
            IntNodeTwo head = new IntNodeTwo(0);
            IntNodeTwo tail = new IntNodeTwo(0);
            head = _head;
            tail = _tail;
            int i = 1;
            int j = 1;
            for(; head.getNum() % 2 == 0; i++)
            {
                head = head.getNext();
            }
            for(; head.getNum() % 2 == 0; j++)
            {
                tail = tail.getNext();
            }
            return length() - Math.min(i,j);
        }
    }

    /**
     * the method get a num and return true if there is a list whit num as her average 
     * and return false otherwise
     * @param int
     * @boolean
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public boolean isAverage(double num)
    {
        int sum = sum();
        int length = length();
        IntNodeTwo head = _head;
        IntNodeTwo tail = _tail;
        final double REAL_NUM = 1.0;//to make the calculation in double number
        if(length == 0)
            return false;
        while(length > 0)
        {
            if(sum * REAL_NUM / length < num)
            {
                sum -= head.getNum();
                head = head.getNext();
                length--;
            }
            if(length != 0 && sum * REAL_NUM / length > num)
            {
                sum -= tail.getNum();
                tail = tail.getPrev();
                length--;
            }
            if(length != 0 && sum * REAL_NUM /  length == num)
            {
                return true;
            }
        }
        return false;
    }
}












