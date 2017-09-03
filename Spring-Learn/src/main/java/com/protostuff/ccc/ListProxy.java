package com.protostuff.ccc;

import java.util.*;

public class ListProxy<T> implements List<T>
{
    List<T> list;

    public List getList()
    {
        return list;
    }

    public ListProxy()
    {
        list = new ArrayList<>();
    }

    public ListProxy(List<T> list)
    {
        this.list = list;
    }

    @Override
    public int size()
    {
        return list.size();
    }

    @Override
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return list.contains(o);
    }

    @Override
    public Iterator iterator()
    {
        return list.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return list.toArray();
    }

    @Override
    public Object[] toArray(Object[] a)
    {
        return list.toArray(a);
    }

    @Override
    public boolean add(T o)
    {
        return list.add(o);
    }

    @Override
    public boolean remove(Object o)
    {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection c)
    {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c)
    {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c)
    {
        return list.addAll(index,
                c);
    }

    @Override
    public boolean removeAll(Collection c)
    {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c)
    {
        return list.retainAll(c);
    }

    @Override
    public void clear()
    {
        list.clear();
    }

    @Override
    public T get(int index)
    {
        return list.get(index);
    }

    @Override
    public T set(int index, T element)
    {
        return list.set(index,
                element);
    }

    @Override
    public void add(int index, T element)
    {
        list.add(index,
                element);
    }

    @Override
    public T remove(int index)
    {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o)
    {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator()
    {
        return list.listIterator();
    }

    @Override
    public ListIterator listIterator(int index)
    {
        return list.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex)
    {
        return list.subList(fromIndex,
                toIndex);
    }
}
