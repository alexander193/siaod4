import java.util.Scanner;
import java.io.*;
public class Stack {
    private int stackSize = 0;
    private int[] stackArray;
    private int top;

    public Stack(int n) {
        this.stackSize = n;
        this.stackArray = new int[stackSize];
        this.top = -1;
    }

    public void addElementBot(int element) {
        int[] newMas = new int[stackSize + 1];
        newMas[0] = element;
        for (int i = 0; i < stackSize; i++)
            newMas[i + 1] = stackArray[i];
        stackArray = newMas;
        top++;
    }
    public void addElementTop(int element) {
        stackArray[++top] = element;
    }
    public int deleteElementTop() {
        return stackArray[top--];
    }
    public int deleteElementBot() {
        stackSize--;
        int[] newMas = new int[stackSize];
        int a = stackArray[0];
        for (int q = 0; q < stackSize; q++)
            newMas[q] = stackArray[q + 1];
        stackArray = newMas;
        top--;
        return a;
    }
    public int getTop() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == - 1);
    }
    public boolean isFull() {
        return (top == stackSize - 1);
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("C:\\Users\\sana2\\Desktop\\text.txt"))) {
            String str;
            String delimiter = " ";
            String[] line;
            str = in.nextLine();
            line = str.split(delimiter);
            int j = 0;
            Stack dek = new Stack(line.length);
            int a;
            double[] cord = new double[line.length];
            for (int i = 0; i < line.length; i++) {
                a = Integer.parseInt(line[i]);
                if (a < 0)
                    dek.addElementBot(a);
                else if (a > 0) {
                    dek.addElementTop(a);
                    j++;
                }
            }
            Stack dek2 = new Stack(line.length);
            for (int i = 0; i < line.length; i++) {
                if (j > 0) {
                    dek2.addElementBot(dek.deleteElementTop());
                    j--;
                }
                else
                    dek2.addElementTop(dek.deleteElementTop());
            }
            for (int i = 0; i < line.length; i++)
                System.out.print(dek2.deleteElementBot() + " ");
        }
        catch(IOException ex) {}
    }
}