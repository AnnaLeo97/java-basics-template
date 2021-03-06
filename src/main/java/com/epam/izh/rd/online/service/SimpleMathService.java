package com.epam.izh.rd.online.service;
import java.util.Arrays;
import java.util.Collections;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 == value2) {
            return 0;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        int maxFrom;
        maxFrom = value1 > value2 ? value1 : value2;
        return maxFrom;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
            for (int i = values.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (values[j] > values[j + 1]) {
                        int maxFrom = values[j];
                        values[j] = values[j + 1];
                        values[j + 1] = maxFrom;
                    }
                }
            }
         return values[values.length-1];
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int j = 0;
        int n = 0;
        for (int i = 0; i < values.length; i++) {//Узнаем размер массива
            if (values[i] % 2 == 0) {
                n++;
            }
        }
        int even[] = new int[n]; //Создаем массив нужного размера

            for (int i = 0; i < values.length; i++) {//Закидываем в массив четные чиселки
                    if (values[i] % 2 == 0) {
                        even[j] = values[i];
                        j++;
                    }
                }
        return even;//Вернули массив
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        int result = 1;
        if (initialVal == 0) {
            return 1;
        } else {
            for (int i = 1; i <=initialVal; i ++){//Подсчет значения факториала, result = 1
                result = result*i;
            }
            return result;
        }
    }


    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return (calcFibonacci(number - 1) + calcFibonacci(number - 2));
        }
    }


    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        Arrays.sort(values);
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean isPrimary = false;//Сейчас будет больно.
        int s = 0;//Задача увеличивает счетчик 's', когда число проходит 3 проверки на простоту. s>2 => число обычное
        if (number%1==0) {//Проверка на делимость на 1, s++
            s++;
        }
        else {};

        if (number%number==0) { //Проверка на делимость на само число, s++
            s++;
        }
        else {};

        for (int i = 2; i<number; i++){ //Проверка на делимость на другие числа, если прошло- s++(s=3) число обычное
            if ( number%i ==0) {
                s++;
            }
            else {};
        }
        if (s >2) {//Проверка значения счетчика, число простое\сложное
            isPrimary = false;
        }
        else {
            isPrimary = true;
        }
        return  isPrimary;//вывод результата. Г-дь, как мне стыдно, наверное, есть способы получше.
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int j = 0;
        int[] res = new int[values.length]; //Создаём временный массив
        for (int i = values.length - 1; i >= 0; i--, j++) {
            res[j] = values[i];
        }
        return res;
    }
}
