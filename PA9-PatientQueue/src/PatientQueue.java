/*
 * Author: Derek Tominaga
 * File: PatientQueue.java
 * Description: This program represent a priority queue of patients. It backed by a
 * binary min heap data structure. The constructor is a zero arugument constructor that
 * will create a default array of size 10. The array holds Patient objects, each Patient 
 * object contains a field for name and field for its priority value in the queue. This can add 
 * patients to the queue by inputing their name and prirority, or just inputs a Patient Object.
 * It can dequeue elements from the list, by removing the first element at (index 1) and shuffling
 * the queue so it is in binary min heap sorted order. Methods to tell you the number of elements in the
 * queueu, if the queue is empty, peek at the frist patient to be servered, and peek at the frist
 * patients priority. A method to clear the whole queue, and a method to change the priority
 * of a patient already in the queue then reorganize it. It finally contains a mehtods to print out
 * the elements from the array in a toString method.*/
public class PatientQueue {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int FIRST_INDEX = 1;

    private Patient[] theQueue;
    private int numPatients;
    // private int patientIndex;

    /*
     * Constructor:
     * creates a new instance of PatientQueue
     * creates and empty Patient array, and sets the number of patients
     * zero
     * priorityQueue: a patient array
     * size: int value of the number of patients in the queue
     **/
    public PatientQueue() {
        theQueue = new Patient[DEFAULT_CAPACITY];
        numPatients = 0;
        // patientIndex = 1;
    }

    /*
     * This method takes no parameters to grow the size of the array
     * when more than the default size of 10 elements is needed. This
     * is done by creating a new array that id double the size of the current
     * array, and copying the elements in order from the original array. Then
     * assigns
     * the new array to priorityQueue.
     */
    private void growArray() {
        Patient[] newArray = new Patient[2 * theQueue.length];
        for (int patient = 1; patient <= numPatients; patient++) {
            newArray[patient] = theQueue[patient];
        }
        theQueue = newArray;
    }

    /*
     * This method takes two parameters to add a patient to the array.
     * It creates a new patient object with the name and priority input, then
     * adds
     * thats elements to the queue, but putting it add the end of the array and
     * bubbling up, so that the element are in appropriate order. Then increase
     * numPatients by 1.
     * name: is the name of the patient
     * priority: is an int value that represents the urgency value for the
     * patient.
     */
    public void enqueue(String name, int priority) {
        Patient newPatient = new Patient(name, priority);
        this.enqueue(newPatient);
        // if (numPatients >= priorityQueue.length - 1) {
        // growArray();
        // }
        // if (numPatients == 0) {
        // priorityQueue[FIRST_INDEX] = newPatient;
        // numPatients++;
        // } else {
        // numPatients++;
        // priorityQueue[numPatients] = newPatient;
        // bubbleUp(numPatients);
        // }
    }

    /*
     * This function takes one parameter to add it to the array.
     * This is done by adding it as the last element of the array
     * and then bubbling down, and increase the numPatients field by 1.
     * patient: is a Patient object that is being added to the queue.
     * 
     */
    public void enqueue(Patient patient) {
        try {
            if (numPatients == theQueue.length - 1) {
                growArray();
            }
            if (numPatients == 0) {
                theQueue[FIRST_INDEX] = patient;
                numPatients++;
            } else {
                numPatients++;
                theQueue[numPatients] = patient;
                bubbleUp(numPatients);
            }
        } catch (Exception e) {
            throw new NullPointerException("Invalid Patient Entry");
        }

    }

    /*
     * This function takes no parameters to remove the first patient in the
     * queue.
     * and return the name of the patient. Then reorganize the queue by moving
     * last element to front and bubbling down so that the queue is in proper
     * order
     * of a
     * priority queue.
     * Return: a string that is the name of the patient to be seen.
     * exception error if empty.
     */
    public String dequeue() {
        try {
            Patient toBeHelped = theQueue[FIRST_INDEX];
            theQueue[FIRST_INDEX] = theQueue[numPatients];
            theQueue[numPatients] = null;
            numPatients--;
            if (numPatients > 0) {
                bubbleDown(FIRST_INDEX);
            }
            return toBeHelped.name;
        } catch (Exception e) {
            throw new NullPointerException("There are no patients to be seen.");
        }
    }

    /*
     * This function takes no parament to look at the name of the paitent who is
     * first in the queue. It will look return the name but no remove it from
     * the queue.
     * Return: String name of the person who is frist in the queue.
     * exception error if empty
     */
    public String peek() {
        if (numPatients <= 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "There are no patients in the queue");
        } else {
            return theQueue[FIRST_INDEX].name;
        }
        // try {
        // return theQueue[FIRST_INDEX].name;
        // }
        // catch (NullPointerException e) {
        // throw new NullPointerException("There are no patients to be seen.");
        // }
    }

    /*
     * This function takes no parament to look at the priority of the patient
     * who is
     * first in the queue. It will look but no remove it from the queue.
     * Return: int value of the priority of the person who is first in the
     * queue.
     * exception error if empty
     */
    public int peekPriority() {
        if (numPatients <= 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "There are no patients in the queue");
        } else {
            return theQueue[FIRST_INDEX].priority;
        }
        // try {
        // return theQueue[FIRST_INDEX].priority;
        // } catch (NullPointerException e) {
        // throw new NullPointerException("There are no patients to be seen.");
        // }
    }

    /*
     * This function takes two parameters to change the priority of a particular
     * patient who may or may not be in the queue. If the patient is not in
     * queue
     * then nothing happens. This is done by traversing the array till the name
     * is
     * found then switing its priority. Then bubble approtialy, based on the
     * priority value.
     * name: is a String of the patients whos priority may be changed.
     * newPriority: is an int value that represents the new priorty of the
     * patient.
     */
    public void changePriority(String name, int newPriority) {
        for (int patient = 1; patient <= numPatients; patient++) {
            Patient curPatient = theQueue[patient];
            if (curPatient.name.equals(name)) {
                if (curPatient.priority > newPriority) {
                    curPatient.priority = newPriority;
                    bubbleUp(patient);
                    break;
                } else {
                    curPatient.priority = newPriority;
                    bubbleDown(patient);
                    break;
                }
            }
        }
    }

    /*
     * This function takes no parameter it will return
     * true of there are no patients in the queue
     */
    public boolean isEmpty() {
        return numPatients == 0;
    }

    /*
     * This function takes no parameter and returns
     * the number of patients in the queue.
     */
    public int size() {
        return numPatients;
    }

    /*
     * This function takes no parameters and will set all the
     * indecies of the array to null, to represent an empty queue.
     */
    public void clear() {
        theQueue = new Patient[DEFAULT_CAPACITY];
        // for (int patients = 1; patients < priorityQueue.length; patients++) {
        // priorityQueue[patients] = null;
        // }
        numPatients = 0;
    }

    /*
     * This function is a helper function that will take two paremeters to
     * determine
     * if one string is greater than the other. This is done in cases of a
     * tie-breaker when
     * patients have the same priority. It will compare the first string to the
     * second
     * string and return true of that string value is greater then second
     * string.
     * parent: is a string that represent the name of the patient at the index
     * that
     * may be swaped to.
     * current: is a string that represents the name of the patient that may be
     * swaped
     * Return false: if they are the same, true if they need to be swapped.
     */
    private boolean compareString(String parent, String current) {
        int minLength = Math.min(parent.length(), current.length());
        for (int letter = 0; letter < minLength; letter++) {
            if ((int) parent.charAt(letter) < (int) current.charAt(letter)) {
                return true;
            }
        }
        return false;
    }

    /*
     * This funciton takes one parameter which is the index of the element that
     * may need to be moved.
     * This is a helper function to enqueue and changePriority. This method will
     * be called
     * when a patients is added or is priority is changed and needs to be moved
     * up in the
     * priority queue. This is done by comparing the index of the element to be
     * moved with
     * its parent index. if the priorty of the parent index is smaller, swap the
     * elements
     * and check again until the priorities are in order.
     */
    private void bubbleUp(int startIndex) {
        //int parentIndex = startIndex / 2;
        int currentIndex = startIndex;
        while (currentIndex != 1
                && theQueue[currentIndex].priority <= theQueue[currentIndex
                        / 2].priority) {
            if (theQueue[currentIndex].priority == theQueue[currentIndex
                    / 2].priority) {
                int stringComparison = theQueue[currentIndex].name
                        .compareTo(theQueue[currentIndex / 2].name);
                if (stringComparison == 0 || stringComparison > 0) {
                    break;
                } else {
                    Patient tempSwapHolder = theQueue[currentIndex / 2];
                    theQueue[currentIndex / 2] = theQueue[currentIndex];
                    theQueue[currentIndex] = tempSwapHolder;
                    currentIndex = currentIndex/2;
                    break;
                    // parentIndex = currentIndex / 2;
                }

            } else {
                Patient tempSwapHolder = theQueue[currentIndex / 2];
                theQueue[currentIndex / 2] = theQueue[currentIndex];
                theQueue[currentIndex] = tempSwapHolder;
                currentIndex = currentIndex/2;
                // parentIndex = currentIndex / 2;
            }
        }
    }

    private Patient childPriorityMax(Patient childOne, Patient childTwo) {
        if (childOne.priority < childTwo.priority) {
            return childOne;
        } else if (childTwo.priority < childOne.priority) {
            return childTwo;
        } else {
            int nameComparison = childOne.name.compareTo(childTwo.name);
            if (nameComparison > 0) {
                return childTwo;
            }
            return childOne;
        }
    }

    private int movePatients(Patient current, Patient toSwap, int index) {
        int indexAfter = 0;
        if(theQueue[index*2].equals(toSwap)) {
            indexAfter = index*2;
        } else {
            indexAfter = (index*2)+1;
        }
        Patient tempSwapHolder = theQueue[indexAfter];
        theQueue[indexAfter] = theQueue[index];
        theQueue[index] = tempSwapHolder;
        return indexAfter;
    }

    /*
     * This function takes one parameter that is an invalue of the index of the
     * element
     * that may need to be moved. This funciton is a helper function to dequeue
     * and changePriority.
     * It is called when removing elements from the queue or changing the the
     * priority of a patient.
     * From the input index the elements are compared with their two childern,
     * and swaped if their
     * children have smaller prioity values than the startIndex. Then
     * recursively check to makesure
     * that the elements are in the correct oder.
     */
    private void bubbleDown(int startIndex) {
        if (startIndex * 2 > numPatients) {
            return;
        } else if (theQueue[startIndex * 2] != null
                && theQueue[(startIndex * 2) + 1] != null) {
            Patient toSwitch = childPriorityMax(theQueue[startIndex * 2],
                    theQueue[(startIndex * 2) + 1]);
            if (theQueue[startIndex].priority == toSwitch.priority) {
                int nameComparison = theQueue[startIndex].name
                        .compareTo(toSwitch.name);
                if (nameComparison < 1) {
                    return;
                } else {
                    movePatients(theQueue[startIndex], toSwitch, startIndex);
                    return;
                }
            }
            int indexAfter = movePatients(theQueue[startIndex], toSwitch,
                    startIndex);
            bubbleDown(indexAfter);
        } else if (theQueue[startIndex * 2] != null
                && theQueue[startIndex * 2 + 1] == null) {
            if (theQueue[startIndex].priority < theQueue[startIndex
                    * 2].priority) {
                return;
            } else if (theQueue[startIndex].priority == theQueue[startIndex
                    * 2].priority) {
                int nameComparison = theQueue[startIndex].name
                        .compareTo(theQueue[startIndex * 2].name);
                if (nameComparison < 1) {
                    return;
                } else {
                    movePatients(theQueue[startIndex], theQueue[startIndex * 2],
                            startIndex);
                    return;
                }
            }
        } else {
            movePatients(theQueue[startIndex], theQueue[startIndex * 2],
                    startIndex);

        }

        // int currentIndex = startIndex;
        // int indexToSwap = currentIndex;
        // int child1 = currentIndex * 2;
        // int child2 = currentIndex * 2 + 1;
        // if (child1 <= numPatients
        // && theQueue[currentIndex].priority > theQueue[child1].priority) {
        // indexToSwap = child1;
        // }
        // if (child2 <= numPatients
        // && theQueue[currentIndex].priority > theQueue[child2].priority) {
        // indexToSwap = child2;
        // }
        // if (indexToSwap != startIndex) {
        // Patient tempSwapHolder = theQueue[indexToSwap];
        // theQueue[indexToSwap] = theQueue[currentIndex];
        // theQueue[currentIndex] = tempSwapHolder;
        // bubbleDown(indexToSwap);
        // }
    }

    /*
     * This function takes no parameter and will create a string that represent
     * the priority queue, listing the patients in the queue by their name
     * and their priority "Name ()"
     * Return: a string that represent the priorityQueue.
     */
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        String priorityQueueString = "{";
        for (int patient = 1; patient < numPatients; patient++) {
            priorityQueueString += theQueue[patient].toString() + ", ";
        }
        priorityQueueString += theQueue[numPatients].toString() + "}";
        return priorityQueueString;
    }

}
