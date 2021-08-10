public class ClassParticipation {
   

   private class Node
   {
       String value;
       int count;
       Node next;

       Node(String val, Node n)
       {
           value=val;
           next=n;
       }

    

       Node(String val)
       {
           value=val;
           next=null;
       }
   }

   private Node first; 
   private Node last; 



   public ClassParticipation()
   {
       first = null;
       last = null;
   }

 

   public boolean isEmpty()
   {
       return size()==0;
   }

 

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


   public void add(int index, String e)
   {

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

   
}
