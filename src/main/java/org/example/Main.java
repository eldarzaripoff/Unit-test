package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.print("""
                    Выберите операцию и введите её номер:
                    1. Добавить новый доход
                    2. Добавить новый расход
                    3. Выбрать ситему налогооблажения
                    end. Закрыть программу
                    """);
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            if ("".equals(input)) {
                throw new NullPointerException();
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1 -> {
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                }
                case 2 -> {
                    System.out.println("Введите сумму расхода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    spendings += money;
                }
                case 3 -> theBestOption(taxEarningsMinusSpendings(earnings, spendings), taxEarnings(earnings));
                default -> System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int taxEmS = (earnings - spendings) * 15 / 100;
        return Math.max(taxEmS, 0);
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static void theBestOption(int TaxEmS, int TaxEarn) {
        if (TaxEarn >= TaxEmS) {
            int difference = TaxEarn - TaxEmS;
            System.out.println("Мы советуем вам УСН доходы - расходы");
            System.out.println("Ваш налог составит: " + TaxEmS);
            System.out.println("Экономия составит: " + difference);
            System.out.println("Налог на другой системе:" + TaxEarn);
        } else {
            int difference = TaxEmS - TaxEarn;
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + TaxEarn);
            System.out.println("Экономия составит: " + difference);
            System.out.println("Налог на другой системе:" + TaxEmS);
        }
    }
}