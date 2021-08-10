public class ClassParticipation {
   /**
   The Node class stores a list element and a reference to the next node.
   */

   private class Node
   {
       String value;
       int count;
       Node next;

       /**
           Constructor.
   @param val element to store in the node.
   @param n reference to the successor node.
       */
   // constructor with attributes given as arguments
       Node(String val, Node n)
       {
           value=val;
           next=n;
       }

       /**
       Constructor.
       @param val element to store in the node.
       */

       Node(String val)
       {
           value=val;
           next=null;
       }
   }

   private Node first; // list head
   private Node last; // last element in list

   /**
   Constructor.
   */

   public ClassParticipation()
   {
       first = null;
       last = null;
   }

   /**
       The isEmpty method checks to see
   if the list is empty.
   @return true if list is empty,
   false otherwise.
   */

   public boolean isEmpty()
   {
       return size()==0;
   }

   /**
   The size method returns the length of the list.
   @return The number of elements in the list.
   */

   public int size()
   {
       int count = 0;
       Node x = first;
       while (x != null)
       {
           count ++;
           x = x.next;
       }
       return count;
   }

   /**
   The add method adds an element to
   the end of the list.
   @param e The value to add to the
   end of the list.
   */

   public void add(String e)
   {
       Node newNode=new Node(e);
       newNode.count=1;
       if (isEmpty())
       {
           first = newNode;
           last = first;
       }
       else
       {
           if(isInTheList(e))
           {
               return;
           }
           // Add to end of existing list
           else
           {
               last.next = newNode;
               last = last.next;
           }
       }
   }

   /**
   The add method adds an element at a position.
   @param e The element to add to the list.
   @param index The position at which to add
   the element.
   @exception IndexOutOfBoundsException When
   index is out of bounds.
   */

   public void add(int index, String e)
   {
   //*** Task #4: fill in the body of this method, following instructions given by comments
   /*
   Directions :
   * check that index is in the correct range, and throw IndexOutOfBoundsException if not
   * consider index is 0, and place the new element in the beginning of the list
   * set a reference pred to point to the node that will be the predecessor of the new node
   * Splice in a node containing the new element
   * check if there is a new last element, and set up last
   */
       if(index<0 || index>size())
           throw new IndexOutOfBoundsException("Index out of bound.");
       if(isInTheList(e))
           return;
      
       Node newNode=new Node(e);
       newNode.count=1;
       if(index==0)
       {
           newNode.next=first;
           first=newNode;
           return;
       }
      
       if(index==size())
       {
           last.next=newNode;
           last=newNode;
           return;
       }
       Node current = first;
       Node prev=first;
       for(int i=0;i!=index;i++)
       {
           prev=current;
           current=current.next;
       }
       prev.next=newNode;
       newNode.next=current;
   }
   private boolean isInTheList(String e)
   {
       Node x = first;
       while (x != null)
       {
           if(x.value.equals(e))
           {
               x.count++;
               return true;
           }
           x=x.next;
       }
       return false;
   }
   /**
   The toString method computes the string
   representation of the list.
   @return The string form of the list.
   */

   public String toString()
   {
       StringBuilder strBuilder = new StringBuilder();

       //Use p to walk down the linked list
       Node x = first;
       while (x != null)
       {
           strBuilder.append(x.value + " has count "+x.count+"\n");
           x = x.next;
       }
       return strBuilder.toString();
   }

   /**
   The remove method removes the element at an index.
   @param index The index of the element to remove.
   @return The element removed.
   @exception IndexOutOfBoundsException When index is
   out of bounds.
   */
}