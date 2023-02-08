import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Node<T> { //not an inner class for ease of testing
	T       data;
	Node<T> left;
	Node<T> right;

	public Node(T data) {
		this(data, null, null);
	}

	public Node(T data, Node<T> left, Node<T> right) {
		this.data  = data;
		this.left  = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "" + this.data;
	}
}

public class BinaryTree<T>
{
	private Node<T> overallRoot;
	
	/** Construct an empty tree */
	public BinaryTree() { }

	/** Construct a binary tree given a pre-built tree */
	public BinaryTree(Node<T> overallRoot) {
		this.overallRoot = overallRoot;
	}
	
	public Node<T> getRoot() { return this.overallRoot; }
	
	public void reflect() { reflect(overallRoot); }

	private void reflect(Node<T> root) {
		if (root == null) return;

		Node<T> temporary = root.left;
		root.left = root.right;
		root.right = temporary;

		reflect(root.left); 
		reflect(root.right);
	}

	public Node<String> build(int levels, String s) {
		if (levels <= 0) return null;

		Node<String> root = new Node<String>(s);
		
		root.left = build(--levels, s);
		root.right = build(levels, s);
		
		return root;
	}
}
