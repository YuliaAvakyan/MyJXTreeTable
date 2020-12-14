package ru.oogis.myTable.v1.data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Data {

    private List<HumanGroup> humanGroups = new ArrayList<HumanGroup>();

    public Data() {
        String[] city = {"Voronezh", " Yekaterinburg", "Ivanovo", "Kazan"};
        String[] nameWoman = new String[]{"Саша", "Маша", "Юля", "Маруся", "Лиля"};
        String[] nameMan = new String[]{"Саша", "Коля", "Миша", "Влад", "Максим"};
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            HumanGroup group = new HumanGroup(Integer.toString(i));
            for (int j = 0; j < random.nextInt(10); j++) {
                if ((j * i) % 2 == 0) {
                    group.add(new Man(
                            nameMan[random.nextInt(nameMan.length)],
                            random.nextInt(60),
                            city[random.nextInt(city.length)], random.nextInt(60)
                    ));
                } else {
                    group.add(new Woman(
                            nameWoman[random.nextInt(nameWoman.length)],
                            random.nextInt(40),
                            city[random.nextInt(city.length)]
                    ));
                }
            }
            humanGroups.add(group);
        }

    }

    public List<HumanGroup> getHumanGroups() {
        return humanGroups;
    }
}
