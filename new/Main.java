import java.awt.*;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame MainFrame = new JFrame();
        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(4,1));
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[] array = CreateRandMass(100,MainPanel);

        //Необходимо проверить скорость работы
        //разных алгоритмов сортировки(вставки, быстрой, пузырьком,выборкой)
        //Для измерения времени используем nanoTime()
        //Сохраняем время на старте
        long start = System.nanoTime();

        //Делаем сортировку
        int[] sortedArr = BubbleSort(array);

        long end = System.nanoTime() - start;
        MainPanel.add(new JLabel("Программа выполнена за: " + end));

        MainPanel.add(new JLabel("отсортирован: " + IsSorted(sortedArr)));
        String rez = "";
        for (int i = 0; i< sortedArr.length; i++){
            rez+= sortedArr[i] + " ";
        }
        MainPanel.setBackground(Color.PINK);
        MainPanel.add(new JLabel(rez));
        MainFrame.getContentPane().add(MainPanel,BorderLayout.CENTER);
        MainFrame.setSize(1700,300);
        MainFrame.setVisible(true); 
         


        

    }

    private static boolean IsSorted(int[] array) {
        for (int i = 0; i <array.length-1; i++){
            if(array[i] > array[i+1])
                return false;
        }
        return  true;
    }

    private static int[] BubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length-i-1; j++)
                if (array[j] > array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
        return array;
    }


    private static int[] CreateRandMass(int lenght, JPanel panel) {
        int[] array = new int[lenght];
        String rez = "";
        for (int i = 0; i < lenght; i++) {
            array[i] = (int) Math.round((Math.random() * 100));
            
            rez = rez + array[i] +" ";
        }
        panel.add(new JLabel(rez));
        System.out.println();
        return array;
    }
}
