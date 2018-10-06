package com.fanfte.designPattern.decorator;

/**
 * Created by tianen on 2018/9/28
 *
 * @author fanfte
 * @date 2018/9/28
 **/
public class Suit extends HeroDecorator {

    private Hero decoratedHero;

    public Suit(Hero decoratedHero) {
        super(decoratedHero);
    }

    @Override
    public void init() {
        super.init();
        getSkin();
    }

    private void getSkin() {
        System.out.println("Wear a skin.");
    }

    public static void main(String[] args) {
        Victor victor = new Victor();
        Suit suit = new Suit(victor);
        suit.init();
    }
}
