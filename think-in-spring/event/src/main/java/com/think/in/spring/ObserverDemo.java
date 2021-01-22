package com.think.in.spring;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * {@link Observer} 示例
 * @author xschen
 *
 * @see Observer 观察者
 * @see Observable 可观察对象（消息发送者）
 * @see EventObject 事件对象
 * @see EventListener 事件监听器
 */


public class ObserverDemo {

    public static void main(String[] args) {

        EventObservable observable = new EventObservable();
        // 添加观察者
        observable.addObserver(new EventObserver());
        // 发布事件
        observable.notifyObservers("Hello, World");
    }

    static class EventObservable extends Observable {

        public void setChanged() {
            super.setChanged();
        }

        public void notifyObservers(Object arg) {
            setChanged(); // 需要将changed设置为true，具体可以看notifyObservers(Object arg)的实现
            super.notifyObservers(new EventObject(arg));
            clearChanged();
        }
    }

    static class EventObserver implements Observer, EventListener {
        @Override
        public void update(Observable o, Object event) {
            EventObject eventObject = (EventObject) event;
            System.out.println("received event: " + eventObject);
        }
    }
}
