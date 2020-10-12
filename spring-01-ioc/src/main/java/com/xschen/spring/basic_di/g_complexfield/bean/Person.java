package com.xschen.spring.basic_di.g_complexfield.bean;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author xschen
 *
 * todo: 使用xml的方式来注入
 */

@Component
public class Person {
    private String[] names;
    private List<String> tels;
    private Set<Cat> cats;
    private Map<String, Object> events;
    private Properties props;

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setTels(List<String> tels) {
        this.tels = tels;
    }

    public void setCats(Set<Cat> cats) {
        this.cats = cats;
    }

    public void setEvents(Map<String, Object> events) {
        this.events = events;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", tels=" + tels +
                ", cats=" + cats +
                ", events=" + events +
                ", props=" + props +
                '}';
    }
}
