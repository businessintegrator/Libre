/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seev.criterii.orders.xch;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import javax.persistence.criteria.Order;

/**
 *
 * @author tiaray
 */
public class OrderList {

    private java.util.List<Order> list;



    public OrderList() {
        list = new java.util.LinkedList();
    }

    public List<Order> getInternal() {
        return list;
    }

    public void setInternal(List<Order> list) {
        this.list = list;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public Iterator<Order> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    public boolean add(Order e) {
        return list.add(e);
    }

    public boolean removeObject(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends Order> c) {
        return list.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Order> c) {
        return list.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public void replaceAll(UnaryOperator<Order> operator) {
        list.replaceAll(operator);
    }

    public void sort(Comparator<? super Order> c) {
        list.sort(c);
    }

    public void clear() {
        list.clear();
    }

    public boolean equals(Object o) {
        return list.equals(o);
    }

    public int hashCode() {
        return list.hashCode();
    }

    public Order get(int index) {
        return list.get(index);
    }

    public Order set(int index, Order element) {
        return list.set(index, element);
    }

    public void add(int index, Order element) {
        list.add(index, element);
    }

    public Order remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    public ListIterator<Order> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Order> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Order> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public Spliterator<Order> spliterator() {
        return list.spliterator();
    }

    public boolean removeIf(Predicate<? super Order> filter) {
        return list.removeIf(filter);
    }

    public Stream<Order> stream() {
        return list.stream();
    }

    public Stream<Order> parallelStream() {
        return list.parallelStream();
    }

    public void forEach(Consumer<? super Order> action) {
        list.forEach(action);
    }
    
    
}
