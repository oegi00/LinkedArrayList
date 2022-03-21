public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head;
    private boolean isSorted;
    private int size;
    private int indexx;

    // constr.
    public LinkedList() {
        head = null;
        isSorted = true;
        size = 0;
        indexx = -1;
        // at initialization, this is a non headed list
        // the list is empty as the first node is null
        // until something is added to it
    }

    @Override
    public boolean add(T element) {

        boolean boo = false;
        if (element == null) {
            // index > size() ||

            return boo;
            // index is too small or null element means we can't add
        }
        if (head == null) {
            Node<T> newNode = new Node<T>(element);
            newNode.setNext(null);
            head = newNode;
            boo = true;
            return boo;
            // if the list is initially empty
        }

        Node<T> curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        Node<T> newNode = new Node<T>(element);
        newNode.setNext(null);
        if (element.compareTo(curr.getData()) < 0) {
            isSorted = false;
        }
        curr.setNext(newNode);
        boo = true;
        return boo;

    }



    @Override
    public boolean add(int index, T element) {
        // create node with data value T at specified index
        boolean boo = false;
        int nodeIndex = 0;

        if (index < 0 || element == null) {
            // index > size() ||

            return boo;
            // index is too small or null element means we can't add
        } else {
            if (head == null) {
                Node<T> newNode = new Node<T>(element);
                newNode.setNext(null);
                head = newNode;
                boo = true;
                nodeIndex++;
                return boo;
                // if the list is empty, will make the first node in the list have element as data
            } else {
                // trailer
                Node<T> trailer = head;
                Node<T> curr = head.getNext();

                 // keep going until we are at the right index
                while(curr != null){

                    if (nodeIndex == index) {
                        // curr is at index
                        Node<T> newNode = new Node<T>(element);
                        trailer.setNext(newNode);
                        newNode.setNext(curr);
                        if(element.compareTo(curr.getData()) > 0){
                            isSorted = false;
                        }
                        trailer = newNode;

                        curr = curr.getNext();


                        boo = true;

                        return boo;
                    }
                    trailer = curr;
                    curr = curr.getNext();

                    nodeIndex++;

                }
                nodeIndex++;

                if (index == nodeIndex) {
                    Node<T> newNode = new Node<T>(element);
                    // if element is greater than trailer, no longer sorted
                    if(element.compareTo(trailer.getData()) < 0){
                        isSorted = false;
                    }
                    trailer.setNext(newNode);
                    newNode.setNext(curr);
                    trailer = newNode;
                    boo = true;
                    return boo;
                    // this is to add second element in list
                }

            }

            return boo;
        }
    }

    @Override
    public void clear() {
        head = null;
        isSorted = true;

    }

    @Override
    public T get(int index) {
        /*
         * Return the element at given index. If index is
         * out-of-bounds, it will return null.
         *
         * @param index index to obtain from the list.
         * @return the element at the given index.
         */
//  iterate thru list, if curr is
        T returnVal = null;
      int nodeIndex = 0;

      Node<T> curr = head;
      if(index < 0 || index > size()){
          return null;
      } else {
          while(curr != null){
              if(nodeIndex == index){
                  returnVal = curr.getData();
              }
              curr = curr.getNext();
              nodeIndex++;
          }
      }
      return returnVal;
    }

    @Override
    public int indexOf(T element) {
//        Return the first index of element in the list. If element
//   * is null or not found in the list, return -1. If isSorted is
//                * true, uses the ordering of the list to increase the efficiency
//                * of the search.

       int index = 0;
       if (head == null || element == null){
           return -1;
       }

        Node<T> curr = head;
       if(isSorted == true){
           if(curr.getData().compareTo(element) > 0){
               return -1;
           }// this would mean the lowest element is larger than element, so element isn't in the list

       } else {
           while(curr != null){
               if(curr.getData().compareTo(element) == 0){
                   return index;
               }
               curr = curr.getNext();
               index++;
           }
       }
       // if issorted is true, if next element is greater than our element, return -1
        // otherwise, just go through the list and check if element == curr.getdata if so return nodeindex
   return index;
    }

    @Override
    public boolean isEmpty() {
        boolean boo = false;
        if(head == null){
            boo = true;
        }
        return boo;
    }

    @Override
    public int size() {
        int sizeoflist = 0;
        if(head == null){
            sizeoflist = 0;
            return sizeoflist;
        }
        Node<T> curr = head;
        while(curr != null){
            sizeoflist += 1;
            curr = curr.getNext();
        }
        return sizeoflist;
    }

    @Override
    public void sort() {
        // update issorted accordingly

        int counter = 0;
        int index = 0;
        T min = null;
        T value = null;
        Node<T> curr = head;
        Node<T> ptr, trailer;
        Node<T> dummy = new Node<T>(null, head);
        if (head == null || isSorted == true) {
            return;
        } else {
            ptr = head.getNext();
            trailer = head;
            while (curr != null && ptr != null) {
                counter++;
                if (curr.getData().compareTo(ptr.getData()) > 0) {
                    min = ptr.getData();
                    value = curr.getData();
                    curr.setData(min);
                    ptr.setData(value);

                    curr = ptr;
                    ptr = ptr.getNext();


                     } else {
                    trailer = curr;
                    curr = ptr;
                     ptr = ptr.getNext();
                     counter ++;
                     // if its already in the right position just move forward

                }


            }
            // set head equal to something



        isSorted = true;

        }

    }

    @Override
    public T remove(int index) {
        T returnval = null;
        int nodeIndex = 0;
        if (index > size() || index < 0) {
            return null;
        }
        if (head == null) {
            return returnval;
        } else {
            Node<T> curr = head;
            Node<T> temp = head;
            if(nodeIndex == index){
                head = head.getNext();
                // to remove head
            } else {
                while (curr.getNext() != null) {
                    nodeIndex++;
                    if (nodeIndex == index) {
                        returnval = curr.getData();
                        temp.setNext(curr.getNext());


                    } else {
                        temp = curr;
                        curr = curr.getNext();
// to remove anything else
                    }


                }

            }

        }



        return returnval;
    }

    @Override
    public void equalTo(T element) {
        //go thru linked list, if element doesnt equal curr.getdata, curr.getdata is now null
        Node<T> trailer = head;
        Node<T> curr = head;

        if (head == null){
            return;

        } else {
            while(curr != null){ // while we are not off the end of the list
                if(curr.getData() != element){
                    curr.setData(null);
                    trailer = curr;
                    curr = curr.getNext();
                }

                curr = curr.getNext();
            }

        }



    }

    @Override
    public void reverse() {
        // reverse the list in place
        Node<T> dummy = new Node<T>(null, head);
        Node<T> trailer;
        Node<T> ptr;

        if(head == null || dummy.getNext().getNext() == null){
            return;
        }

        trailer = head;
        ptr = trailer.getNext();

        while (ptr != null){
            trailer.setNext(ptr.getNext());
            ptr.setNext(dummy.getNext());
            dummy.setNext(ptr);
            ptr = trailer.getNext();
        }
        head = dummy.getNext();




    }

    @Override
    public void merge(List<T> otherList) {
        LinkedList<T> other = (LinkedList<T>) otherList;
        sort();
        other.sort();

//        Node<T> curr = head.getNext();
//        Node<T> otherCurr = other.head;
//        LinkedList<T> newList = new LinkedList<T>();
//        for(int i = 0; i < other.size()+this.size(); i++){
//            while(curr != null || otherCurr != null) {
//                if (curr.getData().compareTo(otherCurr.getData()) < 0) {
//                    newList.add(curr.getData());
//                    curr = curr.getNext();
//                } else {
//                    newList.add(otherCurr.getData());
//                    otherCurr = otherCurr.getNext();
//
//                }
//            }
//
//        }
//        head = newList.head;
    }

    @Override
    public boolean rotate(int n) {
        boolean boo;
        Node<T> trailer = head;
        Node<T> curr2 = head.getNext();
        Node<T> curr = head;
        int counter = 0;

        if (head == null || n == 0 || n >size()){
            boo = false;
            return boo;

        } else {
            while(curr != null){ // all the elements before the rotation are null
                if(counter < n){
                    curr.setData(null);

                }
                counter++;
                curr = curr.getNext();
            }

        }



        return false;
    }

    @Override
    public boolean isSorted() {
        Node<T> curr = head;
        Node<T> ptr = head.getNext();
        if (curr.getData().compareTo(ptr.getData()) > 0){ // if the very first comparison fails then the list is definitely not sorted
            isSorted = false;
        } else {
            isSorted = true;
        }

        return isSorted;
    }

    @Override
    public int instanceOf(T element) {
        return 0;
    }

    public void removeEvery(int n){
        // remove every nth element
        // go thru the list and count the nodes starting
        // when counter == n,
        // call remove function on index
        // reset counter to 0
        // instead of calling remove function, set trailer = head, curr = head
        // set trailer equal to curr.getnext in this case
        // increment trailer
        //

        Node<T> trailer = head;
        Node<T> curr = head;
        int counter = 1;

        if (head == null || n == 0 || n >size()){
            return;

        } else {
            while(curr != null){ // while we are not off the end of the list
                if(counter == n){
                    trailer.setNext(curr.getNext());
                    trailer = curr;
                    counter = 1;
                    // increment curr?
                }
                counter++;
                curr = curr.getNext();
            }

        }




    }

    public String toString() {
        Node<T> curr = head;
        String output = "";
        // if head is null, print empty list
        if (head == null) {
            return output;
        } else {

            int num = 0;
            while (curr.getNext() != null) {
                num++;
                curr = curr.getNext();
            }
            Node<T> curr2 = head;
            for (int i = 0; i <= num; i++) {
                output += curr2.getData() + "\n";
                curr2 = curr2.getNext();

            }
            return output;
        }
    }
    public static void main(String[] args){


    }
}
