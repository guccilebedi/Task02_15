package com.company;

public class ListElement {
    private int data;     // данные ячейки
    private ListElement next;     // ссылка на следующую ячейку

    ListElement(int data, ListElement next) {     // конструктор для ячейки списка
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public ListElement getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }
}
