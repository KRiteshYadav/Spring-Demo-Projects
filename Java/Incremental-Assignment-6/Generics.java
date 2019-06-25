class SList<T>
{
  class Node<T>
  {
    T data;
    Node<T> next;
    Node(T data)
    {
      this.data = data;
    }
  }
  Node<T> head;
  class SListIterator
  {
    Node<T> curr;
    Node<T> prev;
    SListIterator()
    {
      curr = head;
      prev = head;
    }

    void add(T data)
    {
      Node<T> node = new Node<T>(data);
      if(head==null)
      {
        head = node;
        curr = head;
        prev = head;
      }
      else
      {
        node.next = curr.next;
        curr.next = node;
      }
    }

    void remove(T data)
    {
      if(head==null)
          return;
      else
        {
          prev.next=curr.next;
          curr=curr.next;
        }
    }

    boolean hasNext()
    {
      return curr!=null && curr.next!=null;
    }

    T next()
    {
      prev = curr;
      curr = curr.next;
      return prev.data;
    }
  }
  public SListIterator iterator()
  {
    return new SListIterator();
  }
  public String toString()
  {
    String result = "null-->";
    SListIterator it = new SListIterator();
    while(it.hasNext())
      result+=it.next()+"-->";
    result+=it.next();
    return result+"-->null";
  }
}

class Generics
{
  public static void main(String args[])
  {
    SList<Integer> lis = new SList<>();
    SList<Integer>.SListIterator iter = lis.iterator();
    iter.add(10);
    iter.add(20);
    iter.next();
    iter.add(30);
    System.out.println(lis);
  }
}
