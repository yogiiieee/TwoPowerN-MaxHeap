import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoPowerNMaxHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;
    // private int numChildrenPower;
    private int numChildren;

    public TwoPowerNMaxHeap(int numChildrenPower) {
        this.heap = new ArrayList<>();
        // this.numChildrenPower = numChildrenPower;
        this.numChildren = (int) Math.pow(2, numChildrenPower);
    }

    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public T popMax() {
        if(heap.size() == 0) {
            throw new IllegalStateException("Heap is Empty");
        }
        T max = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);

        if(heap.size() > 0) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return max;
    }
    
    private void heapifyUp(int index) {
        while(index > 0) {
            int parentIndex = (index - 1) / numChildren;
            if(heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while(true) {
            int largestIndex = index;
            for(int i=1; i<numChildren; i++) {
                int childIndex = numChildren * index + i;
                if(childIndex < heap.size() && heap.get(childIndex).compareTo(heap.get(largestIndex)) > 0) {
                    largestIndex = childIndex;
                }
            }
            if(largestIndex != index) {
                Collections.swap(heap, index, largestIndex);
                index = largestIndex;
            } else {
                break;
            }
        }
    }

    public void printHeap() {

        System.out.println("Heap: " + heap);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the power for number of Children: ");
        int numChildrenPower = scanner.nextInt();
        TwoPowerNMaxHeap<Integer> maxHeap = new TwoPowerNMaxHeap<>(numChildrenPower);
        while(true) {
            System.out.println("\nOptions:");
            System.out.println("1. Insert an element\n2. Pop the max element");
            System.out.println("3. Print heap\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter value to Insert: ");
                    int value = scanner.nextInt();
                    maxHeap.insert(value);
                    break;
                case 2:
                    try {
                        int max = maxHeap.popMax();
                        System.out.println("Popped max element: " + max);
                    } catch(IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    maxHeap.printHeap();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }
        }
    }
}