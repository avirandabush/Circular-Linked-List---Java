
/**
 * Represents an organ in a linked, two-way list containing integers
 *
 * @author (Aviran Dabush)
 * @version (05/06/2019)
 */
public class IntNodeTwo
{
    //instance variables
    private int _num;
    private IntNodeTwo _next, _prev; 
    
    //initiliazing constractor
    public IntNodeTwo(int n)
    {
        _num = n;
        _next = null;
        _prev = null;
    }
    //setting constractor
    public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p)
    {
        _num = num;
        _next = n;
        _prev = p;
    }
    //basics methods
    //***
    /**
     * get the value of the node
     * @return int
     */
    public int getNum()
    {
        return _num;
    }
    /**
     * get the value of next node
     * @return int
     */
    public IntNodeTwo getNext()
    {
        return _next;
    }
    /**
     * get the value of previous node
     * @return int
     */
    public IntNodeTwo getPrev()
    {
        return _prev;
    }
    /**
     * set the value of the node
     * @param int
     */
    public void setNum(int n)
    {
        _num = n;
    }
    /**
     * set the value of the next node
     * @param IntNodeTwo
     */
    public void setNext(IntNodeTwo node)
    {
        _next = node;
    }
    /**
     * set the value of the previous node
     * @param IntNodeTwo
     */
    public void setPrev(IntNodeTwo node)
    {
        _prev = node;
    }
}
