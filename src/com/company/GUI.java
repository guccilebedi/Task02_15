package com.company;

import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private JPanel panel;
    private JButton fillList;
    private JButton runTask;
    private JTable table1;
    private JButton clearList;
    private JButton setValues;
    private JLabel inputNText;
    private JLabel inputKText;
    private JTextField nTextField;
    private JTextField kTextField;
    private JButton getElement;
    private JButton removeElement;


    public GUI() {
        List list = new List();
        final int[] N = {10};
        final int[] k = {8};

        setValues.addActionListener(new ActionListener() {     // установить значения k и N
            @Override
            public void actionPerformed(ActionEvent e) {
                N[0] = Integer.parseInt(nTextField.getText());
                k[0] = Integer.parseInt(kTextField.getText());
            }
        });

        fillList.addActionListener(new ActionListener() {     // заполнить список и показать его
            @Override
            public void actionPerformed(ActionEvent e) {
                List tempList = list;
                for (int i = 1; i <= N[0]; i++) {
                    tempList.add(i);
                }
                tempList.loop();
                JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, tempList.toArray(N[0]));
                tempList.clear();
            }
        });

        runTask.addActionListener(new ActionListener() {     // выполнить "считалку"
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= N[0]; i++) {
                    list.add(i);
                }
                list.loop();
                list.runTask(N[0], k[0]);
                JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, list.toArray(1));
                list.clear();
            }
        });

        clearList.addActionListener(new ActionListener() {     // очистить лист (надо использовать каждый раз после выполнения "считалки")
            @Override
            public void actionPerformed(ActionEvent e) {
                list.clear();
                JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
            }
        });

        getElement.addActionListener(new ActionListener() {     // показать элемент под индексом k
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= N[0]; i++) {
                    list.add(i);
                }
                int[] arr = new int[1];
                arr[0] = list.getElement(k[0]);
                JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, arr);
                list.clear();
            }
        });

        removeElement.addActionListener(new ActionListener() {     // удалить из списка элемент под индексом k и показать список
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= N[0]; i++) {
                    list.add(i);
                }
                list.removeElement(k[0]);
                JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, list.toArray(N[0] - 1));
                list.clear();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
