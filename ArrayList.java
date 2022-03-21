public class ArrayList<T extends Comparable<T>> implements List<T>{
    private T[] a;
    private T element;
    private int index;
    private int size;
    private boolean isSorted;


    public ArrayList(){
        this.size = 2;
        a = (T[]) new Comparable[size];

    }
    @Override
    public boolean add(T element) {
        // loop through to get size of array
        // set size variable to that
        // create new array with size+1 elements
        // newdata[size+1} = element
        // a = newdata
        // update issorted
        boolean boo = false;
        if (element == null) {
            return boo;
        } else {
            // case if first add

            int i = 0;
            if (a[i] == null || a[i + 1] == null) {
                if (a[i] == null) {
                    a[i] = element;
                    boo = true;
                    return boo;

                } else {
                    a[i + 1] = element;
                    boo = true;
                    return boo;
                }
            }
            T[] newData = (T[]) new Comparable[a.length + 1];
            for(int y = 0; y <= a.length-1; y++){
                newData[y] = a[y];
            }
            newData[a.length] = element;
            a = newData;
            boo = true;

        }
        if(a[a.length-1] != null){
        if (element != null) {
            if (element.compareTo(a[a.length - 1]) < 0) { // compare element to the one before it to see if its sorted
                isSorted = false;
            } else {
                isSorted = true;
            }
        }
        }
        return boo;
    }




    @Override
    public boolean add(int index, T element) {

        boolean boo = false;
        int i;
        if (element == null || index < 0 || index > a.length) {
            // invalid
            return boo;
        } else {
            if (index == a.length - 1) { // if the index is the last in the list, call other add
                add(element);
                boo = true;
                return boo;
            } else {

                T[] newData = (T[]) new Comparable[a.length + 1]; // new array with one bigger
                for (i = 0; i < index; i++) {
                        newData[i] = a[i];
                    }
                newData[index] = element;
                if(element.compareTo(newData[i]) < 0){ // compare element with one before it to see if its sorted
                    isSorted = false;
                }
                for(int j = index+1; j < a.length+1; j++){
                    newData[j] = a[j-1];
                }

                boo = true;
                a = newData;


            }


            }
            return boo;
        }

    @Override
    public void clear() {
        isSorted = true;
        T[] clearedArr = (T[]) new Comparable[2];
        a = clearedArr;
    // same conditions as constructor
    }

    @Override
    public T get(int index) {
        // Return the element at given index. If index is
        //          out-of-bounds, it will return null.
        // for loop iterate thru a, if i == index, return a[i]
        T returnVal = null;
        if (index < 0 || index > a.length) {
            return null;
            // invalid checks
        } else {

            for (int j = 0; j < a.length; j++) {
                if(j == index){
                    returnVal = a[j]; // get element at index j
                    if(returnVal == null){
                        return null;
                    } else {

                    } return returnVal;

                }
            }
            return returnVal;
        }
    }

    @Override
    public int indexOf(T element) {
    //    Return the first index of element in the list. If element
 //  * is null or not found in the list, return -1. If isSorted is
  //              * true, uses the ordering of the list to increase the efficiency
   //             * of the search.
        // if isSorted = true, if a[i] compareto element > 0, (if a[i] > element) then the element is not in list, return -1
        // iterate through a.length
        // check to see if a[i] == element
        // return i
        int returnidx = -1;
        if(element == null){
            return returnidx;
        } else {
            if(isSorted == true){
                for(int x = 0; x < a.length; x++){
                    if (a[x] != null) {
                        if (a[x].compareTo(element) > 0) {
                            //element isn't in list because the lists element is bigger than the one we want
                            return returnidx;

                    } else {
                        if(a[x] == element){
                            returnidx = x;
                            return returnidx;
                        }
                    }
                }
                }

            } else {
                for(int x = 0; x < a.length; x++) {
                    if (a[x] == element) {
                        returnidx = x;
                        return returnidx;
                    }
                }

            }
        }


        return returnidx;
    }

    @Override
    public boolean isEmpty() {
        // if all elements null or if a has size 2 and null elements?
        if(a.length == 2 && a[a.length-2] == null && a[a.length-1] == null){
             return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        //iterate thru a.length, if a[i] != null, num++
        int num = 0;
        for (int i = 0; i < a.length; i++){
            if(a[i] != null){
                num++;
            }
        }
        return num;
    }

    @Override
    public void sort() {
    int i, j, minIndex;
    int counter = 0;
    T temp;
    for(i = 0; i < a.length -1; i ++){
        minIndex = i;
        for(j = i+1; j < a.length; j++){
            counter++;
            if(a[j].compareTo(a[minIndex]) < 0){
                minIndex = j;

            }
            temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;

        }



    }
    reverse();
    isSorted = true;

    }

    @Override
    public T remove(int index) {
        // iterate through array, check if i = index then  returnval = a[i]
        //
        // create new array with size-1 elements
        // for loop through array, if a[i] = returnval, do nothing, otherwise newdata[i] = a[i]
        T returnEle = null;
        for(int i = 0; i < a.length; i++){
            if(i == index){
                returnEle = a[i];

            }
        }
        T[] newArr = (T[]) new Comparable[a.length-1]; // make a new array of one size smaller
        for(int j = 0; j < index; j++){
            newArr[j] = a[j];
        }
        for(int k = index; k < a.length-1; k++){
            newArr[k] = a[k+1];
        }

        a = newArr;
        // is a sorted?
        return returnEle;
    }

    @Override
    public void equalTo(T element) {
        // for a[i] != element
        // remove a[i]
        // update is sorted
        // if the list is sorted, once you get to an element that is greater than your element, remove all
        // otherwise, go through each element and see if it's not equal to our element then remove
        if (element == null){
            //do nothing
            return;
        }

        if(isSorted == true) {
            for(int i = 0; i < a.length; i++){
                if(a[i].compareTo(element) > 0){
                    if(a[i] != element){
                        a[i] = null;
                        return;
                    }
                }
            }

        } else {
            for(int i = 0; i < a.length; i++){
                    if(a[i] != element) {
                        a[i] = null;
                    }
                }
            }

                }


    @Override
    public void reverse() {
        if(a == null || a.length <= 1){
            return;
        }
        for(int i = 0; i < a.length/2; i++){
            T temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
            // each half of the list swaps the length -1 - i element which keeps going
            // down until we get to the middle of the array. then everything is swapped front to back

        }

    }

    @Override
    public void merge(List<T> otherList) {
        // error checks

        ArrayList<T> other = (ArrayList<T>) otherList; // takes list from arg and casts it to an arraylist
        if(other == null){
            //do nothing
            return;
        }
        sort();
        other.sort();

        T[] mergedArray = (T[]) new Comparable[(other.size()+this.size())];
        int i = 0;
        // if our array is less than the other array
        // take one from each at each iteration
        for(int z = 0; z < mergedArray.length; z++){
        if(a[i].compareTo(other.a[i]) < 0){
            mergedArray[z] = a[z];
        } else {
            mergedArray[z] = other.a[z];
        }

        }

        a = mergedArray;

        // set a = new array

    }

    @Override
    public boolean rotate(int n) {
       // If n is less than or equal to 0 OR the list length is less than or equal to 1, return false without rotating.
        // update issorted

        if(n <= 0 || a.length <= 1){
            return false;
            // check for invalid cases
        }

        int num = 0;
        int i = 0;
        int g = 0;
        int z;

        for(z = n; z < a.length; z++){
            a[z] = a[num];
            num++;
        } // moving the elements after n over
        while(i < n){
            a[i] = null;
            i++;
        } // setting the first n elements to null


        return true;
    }

    public String toString(){
        String output = "";
        for(int i = 0; i < a.length; i++){
            output += a[i] + "\n";
        }
        return output;

    }

    @Override
    public boolean isSorted() {
        int i = 0;
        if(a[i].compareTo(a[i+1]) > 0){
            isSorted = false;
        } else {
            isSorted = true;
        }
        return isSorted;
    }

public int instanceOf(T element){
        //returns an int representing how many times element appears in the list
    int num = 0;
    for(int q = 0; q < a.length; q++){
        if(a[q].equals(element)){
            num++;

        }
    }
    return num;
}

    public void removeEvery(int n) {

    }
}
