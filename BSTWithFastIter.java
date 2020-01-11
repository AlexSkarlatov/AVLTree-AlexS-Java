package hw5;

import java.util.NoSuchElementException;

//import hw5.BST.InorderIterator;

public class BSTWithFastIter<E extends Comparable<E>> extends BST<E> {

	@Override
	// override iterator method
	public java.util.Iterator<E> iterator() {
		return new FastIterator();
	}
	private class FastIterator implements java.util.Iterator<E> {

		private java.util.Stack<TreeNode<E>> stack = new java.util.Stack<>();
		private TreeNode<E> current = root;
		private E lastReturned = null;

		public FastIterator() {
		}

		@Override
		public boolean hasNext() {
			if (current != null || !stack.empty())
				return true;
			else
				return false;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			while (current != null) {
				stack.add(current);
				current = current.left;
			}
			// pop node
			TreeNode<E> node = stack.pop();
			lastReturned = node.element;
			current = node.right;
			return lastReturned;
		}

		public void remove() {
			// TODO5
			if (lastReturned == null)
				throw new IllegalStateException();
			// call delete on the BST, deleting last returned element
			delete(lastReturned);
			// set lastReturned to null
			lastReturned = null;
			// return true;
		}

	}

}
