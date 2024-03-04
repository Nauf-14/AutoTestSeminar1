package org.max.homeWork;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Nested
    @DisplayName("Тесты для класса Main")
    class MainTests {

        @Test
        @DisplayName("Тест метода game при изменении выбора")
        void testGameWithChangeChoice() {
            int iterations = 1000;
            int expectedWins = 0;

            for (int i = 0; i < iterations; i++) {
                boolean result = Main.game(true);
                if (result) {
                    expectedWins++;
                }
            }

            long actualWins = Main.getChangeChoice().stream().filter(Boolean::valueOf).count();
            //у Вас actualWins всегда будет 0, т.к. массив changeChoice из метода getChangeChoice() в классе Main заполняется только в методе main, а не в методе game
            assertEquals(expectedWins, actualWins, "Количество выигрышей с изменением выбора не соответствует ожидаемому");
        }

        @Test
        @DisplayName("Тест метода game без изменения выбора")
        void testGameWithoutChangeChoice() {
            int iterations = 1000;
            int expectedWins = 0;

            for (int i = 0; i < iterations; i++) {
                boolean result = Main.game(false);
                if (result) {
                    expectedWins++;
                }
            }

            long actualWins = Main.getNotChangeChoice().stream().filter(Boolean::valueOf).count();
            //у Вас actualWins всегда будет 0, т.к. массив notChangeChoice из метода getNotChangeChoice() в классе Main заполняется только в методе main, а не в методе game
            assertEquals(expectedWins, actualWins, "Количество выигрышей без изменения выбора не соответствует ожидаемому");
        }
    }

    @Nested
    @DisplayName("Жизненный цикл тестов для класса Main")
    class MainLifecycleTests {

        @BeforeAll
        static void setUp() {
            System.out.println("Подготовка перед выполнением тестов для класса Main");
        }

        @BeforeEach
        void init() {
            System.out.println("Инициализация перед каждым тестом для класса Main");
        }

        @AfterEach
        void tearDown() {
            System.out.println("Завершение после каждого теста для класса Main");
        }

        @AfterAll
        static void cleanUp() {
            System.out.println("Завершение после выполнения всех тестов для класса Main");
        }
    }

    @Test
    @DisplayName("Негативный тест метода game")
    void testNegativeGame() {
        //почему метод Main.game должен бросать Exception ?
        assertThrows(NullPointerException.class, () -> Main.game(true), "Метод game не выбрасывает ожидаемое исключение");
    }
}








