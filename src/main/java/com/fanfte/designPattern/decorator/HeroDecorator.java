package com.fanfte.designPattern.decorator;

/**
 * Created by tianen on 2018/9/28
 *
 * @author fanfte
 * @date 2018/9/28
 **/
public abstract class HeroDecorator implements Hero{

    private Hero decoratedHero;

    public HeroDecorator(Hero decoratedHero) {
        this.decoratedHero = decoratedHero;
    }

    @Override
    public void init() {
        decoratedHero.init();
    }
}
