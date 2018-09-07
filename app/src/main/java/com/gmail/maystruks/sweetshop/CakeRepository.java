package com.gmail.maystruks.sweetshop;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CakeRepository {

    private static CakeRepository INSTANCE = null;
    private ArrayList<Cake> cakesList;
    private Random random;
    private Context context;

    private CakeRepository(Context context) {
        this.context = context;
        cakesList = new ArrayList<>();
        random = new Random();
        initRepository();
    }

    public static CakeRepository getINSTANCE(Context context) {
        if (null == INSTANCE) {
            INSTANCE = new CakeRepository(context);
        }
        return INSTANCE;
    }

    private void initRepository() {

        cakesList.add(new Cake("Старый Наролеон", "Сейчас пекут Наполеоны в упрощенном варианте, и старый рецепт Наполеона забыт совершенно. \n" +
                "А ведь в классическом Наполеоне должно быть очень много тонких коржей, пропитанных кремом. \n" +
                "Предлагаю вспомнить и насладиться вкусом настоящего Наполеона. \n" +
                "Такой торт отлично впишется в новогодние блюда.",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.old_napoleon)));

        cakesList.add(new Cake("Красный бархат", "Торт по этому рецепту получается не только красивым, но и очень вкусным.\n" +
                " Бисквит сочный, легкий и ароматный, а сам торт \"Красный бархат\" выглядит великолепно.",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.cake_red_velvet)));

        cakesList.add(new Cake("Три шоколада", "Рецепт торта \"Три шоколада\", который украсит любой праздничный стол.",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.cake_three_chocolate)));

        cakesList.add(new Cake("Фруктовый торт", "Торт с фруктами — желанный гость на любом торжестве. " +
                "Разнообразие его вариантов способствует полёту фантазии, и позволяет создать свой неповторимый фирменный рецепт. " +
                "Фруктовые торты более низкокалорийны в сравнении с другими вариантами." +
                " А ещё они красивые, яркие, свежие, сочные, невероятно вкусные и даже чуточку полезные. ",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.frut_cake)));

        cakesList.add(new Cake("Шоколадный торт", "Для меня это самый простой рецепт шоколадного торта," +
                " готовлю его, когда мало времени, а очень хочется сладенького.",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.cake_chocolate)));

        cakesList.add(new Cake("Торт карпатка", "Нежный, очень интересный и вкусный торт \"Карпатка\" - настоящее праздничное украшение стола. " +
                "Готовится он не сложнее самого банального тортика на два коржа. Только тесто в этом десерте не простое, а заварное. " +
                "Поэтому и коржи получаются такие \"гористые\", как горы Карпаты. К нам этот рецепт пришёл из Польши. " +
                "Он, в отличие от большинства десертов, умеренно сладкий, совсем не приторный. " +
                "Приготовив его один раз, вы будете возвращаться к этому кондитерскому чуду снова и снова. ",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.cake_karpatka)));

        cakesList.add(new Cake("Торт рафаэлло", "Нежный вкус конфет «Рафаэлло» вдохновил кондитеров на создание лёгкого, " +
                "воздушного торта, который станет жемчужиной любого застолья." +
                " Его готовят на дни рождения и юбилеи, свадебные банкеты и просто дружеские посиделки." +
                " Мягкий тающий бисквит, пропитанный сливочным кремом с тонкой тропической ноткой кокоса." +
                " Ммммм… Это действительно райское наслаждение!" +
                " Попробуйте и вы испечь этот десерт, пользуясь нашим пошаговым рецептом. ",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.cake_rafaello)));

    }


    public ArrayList<Cake> getCakesList() {

        Collections.shuffle(cakesList, random);
        return cakesList;
    }
}
