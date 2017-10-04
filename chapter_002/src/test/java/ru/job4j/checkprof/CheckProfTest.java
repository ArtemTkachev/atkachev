package ru.job4j.checkprof;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckProfTest {

    @Test
    public void whenCheckProfsThenAllGood() {
        CheckProf cp = new CheckProf();
        String[] profnames = new String[]{"Иванов", "Петров", "Сидоров"};
        String[] cliensnames = new String[]{"Иванченко", "Петренко", "Сидоренко"};

        String[] result = cp.checkProfession(profnames, cliensnames);
        String[] expected = new String[]{"Учитель Иванов преподает студенту Иванченко",
                "Инженер Петров работает на заказчика Петренко",
                "Врач Сидоров лечит пациента Сидоренко"};
        assertThat(result, is(expected));
    }


}
