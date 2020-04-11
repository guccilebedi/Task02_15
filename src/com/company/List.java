package com.company;

public class List {
    private ListElement head;     // первый элемент списка
    private ListElement tail;     // последний элемент списка

    public List() {
    }

    public void add(int element) {     // метод добавления элемента в список
        ListElement temp = new ListElement(element, null);
        if (head == null) {
            this.head = temp;
            this.tail = head;
        } else {
            tail.setNext(temp);
            tail = tail.getNext();
        }
    }

    public void loop() {     // метод зацикливания списка путём назначения head следующим после tail
        tail.setNext(head);
    }

    public void runTask(int N, int k) {     // метод выполнения "считалки"
        ListElement curListElement = head;
        ListElement nextListElement = head;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < k; j++) {
                curListElement = nextListElement;
                nextListElement = nextListElement.getNext();
                if (j == k - 1) {
                    curListElement.setData(nextListElement.getData());
                    curListElement.setNext(nextListElement.getNext());
                }
            }
        }
        curListElement.setNext(null);
        head = curListElement;
        tail = head;
    }

    public void removeElement(int i) {     // метод удаления элемента, стоящего по индексу i
        ListElement curListElement = head;
        ListElement nextListElement = head;
        for (int j = 0; j <= i - 1; j++) {
            curListElement = nextListElement;
            nextListElement = nextListElement.getNext();
            if (j == i - 2 && nextListElement.getNext() == null) {
                curListElement.setNext(null);
                break;
            } else {
                if (j == i - 1) {
                    curListElement.setData(nextListElement.getData());
                    curListElement.setNext(nextListElement.getNext());
                }
            }
        }
    }

    public int getElement(int i) {     // метод получения значения элемента, стоящего по индексу i
        int data = 0;
        ListElement curListElement = head;
        for (int j = 0; j <= i - 1; j++) {
            if (j == i - 1) {
                data = curListElement.getData();
            }
            curListElement = curListElement.getNext();
        }
        return data;
    }

    public int[] toArray(int size) {     // метод преобразования списка в массив
        int[] arr = new int[size];
        if (head.getNext() != null) {
            tail.setNext(null);
        }
        ListElement temp = head;
        int i = 0;
        while (temp.getNext() != null) {
            arr[i] = temp.getData();
            temp = temp.getNext();
            i++;
        }
        arr[i] = temp.getData();
        return arr;
    }

    public void clear() {     // метод очистки списка
        head = null;
        tail = null;
    }
}
