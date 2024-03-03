package org.max.homeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*В качестве домашнего задания вам предложена задача реализовать Java приложение
*для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия)
* и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
* Вам необходимо:
1. Создать свой Java Maven проект;
2. Добавить зависимости JUnit;
3. Реализовать прикладную задачу - приложение для демонстрации парадокса Монти Холла;
4. Покрыть проект тестами;
5. Использовать абстрактные классы;
6. Использовать параметризованные тесты;
7. Использовать ЖЦ тестов;
8. Написать негативные тесты;
9. Запушить проект на GitHub и сдать ссылку на свой проект как результат выполнения домашнего задания.
*/
public class Main {
    private static final List<Boolean> changeChoice = new ArrayList<>();
    private static final List<Boolean> notChangeChoice = new ArrayList<>();
    private static final Random rnd = new Random();

    public static List<Boolean> getChangeChoice() {
        return changeChoice;
    }

    public static List<Boolean> getNotChangeChoice() {
        return notChangeChoice;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            changeChoice.add(game(true));
            notChangeChoice.add(game(false));
        }
        long winWithChoice = changeChoice.stream().filter(Boolean::valueOf).count();
        long winWithoutChoice = notChangeChoice.stream().filter(Boolean::valueOf).count();
        System.out.println("Количество выигрышей с изменением выбора: " + winWithChoice);
        System.out.println("Количество выигрышей без изменения выбора: " + winWithoutChoice);
    }

    static boolean game(boolean choice) {
        boolean[] doors = new boolean[3];
        doors[rnd.nextInt(3)] = true;
        int tmp = rnd.nextInt(0, 3);
        int wieDoor = -1;
        for (int i = 0; i < 2; i++) {
            if (!doors[i]) {
                wieDoor = i;
            }
        }
        int nextChoice = tmp;
        if (choice) {
            for (int i = 0; i < 2; i++) {
                if (i == wieDoor || i == nextChoice) {
                    continue;
                }
                nextChoice = i;
            }
        }
        return doors[nextChoice];
    }
}

