package com.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class UnmodifiableArrayList<E extends DeepCloneable> extends ArrayList<E> {
	public UnmodifiableArrayList(){
		super();
	}
	public UnmodifiableArrayList(int i){
		super(i);
	}
	public UnmodifiableArrayList(Collection<? extends E> c) {
		super(c.size());
		for (E e : c) {
			add(e);
		}
	}

	@Override
	public boolean add(E e) {
		E newE = (E) e.deepClone();
		return super.add(newE);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {

		return super.addAll(new UnmodifiableArrayList(c));
	}

	@Override
	public E get(int index) {
		return (E) super.get(index).deepClone();
	}

	@Override
	public Object[] toArray() {
		Object[] array = super.toArray();
		int index = 0;
		for (Object o : array) {
			array[index++] = ((E) o).deepClone();
		}
		return array;
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		throw new UnsupportedOperationException("Modification unsupported");
	}
	@Override
	public void forEach(Consumer<? super E> action) {
		throw new UnsupportedOperationException("Modification unsupported");
	}
	@Override
	public void replaceAll(UnaryOperator<E> operator) {
		throw new UnsupportedOperationException("Modification unsupported");
	}
	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException("Modification unsupported");
	}

	private class Itr implements Iterator<E> {
		private final Iterator<? extends E> iterator = UnmodifiableArrayList.super.iterator();

		public boolean hasNext() {
			return iterator.hasNext();
		}

		@SuppressWarnings("unchecked")
		public E next() {
			return iterator.next();
		}

		public void remove() {
			throw new UnsupportedOperationException("Modification unsupported");
		}
		

		@Override
		@SuppressWarnings("unchecked")
		public void forEachRemaining(Consumer<? super E> consumer) {
			iterator.forEachRemaining(consumer);
		}
	}
	 private class ListItr extends Itr implements ListIterator<E>{
		 private final ListIterator<? extends E> iterator = UnmodifiableArrayList.super.listIterator();
		@Override
		public boolean hasPrevious() {
			return iterator.hasPrevious();
		}

		@Override
		public E previous() {
			return iterator.previous();
		}

		@Override
		public int nextIndex() {
			return iterator.nextIndex();
		}

		@Override
		public int previousIndex() {
			return iterator.previousIndex();
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException("Modification unsupported");
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException("Modification unsupported");
			
		}
		
		 
	 }
	 @Override
	public List<E> subList(int fromIndex, int toIndex) {
		return new UnmodifiableArrayList<E>(super.subList(fromIndex, toIndex));
	}

}
