package com.family;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// Data structure to store a Binary Tree node
class Node
{
	
	String key;
	Node left = null, right = null;

	Node(String key) {
		this.key = key;
	}
}

class Main
{
	// Function to print all nodes of a given binary tree in specific
	// order from top to bottom
	public static void printNodes(Node root)
	{
		// return is tree is empty
		if (root == null) {
			return;
		}

		// print root node
		System.out.print(root.key + " ");

		// create a two empty queues and enqueue root's left and
		// right child respectively
		Queue<Node> first = new ArrayDeque<Node>();
		first.add(root.left);

		Queue<Node> second = new ArrayDeque<Node>();
		second.add(root.right);

		// run till queue is empty
		while (!first.isEmpty())
		{
			// calculate number of nodes in current level
			int n = first.size();

			// process every node of current level
			while (n-- > 0)
			{
				// pop front node from first queue and print it
				Node x = first.poll();

				System.out.print(x.key + " ");

				// push left and right child of x to first queue
				if (x.left != null) {
					first.add(x.left);
				}

				if (x.right != null) {
					first.add(x.right);
				}

				// pop front node from second queue and print it
				Node y = second.poll();

				System.out.print(y.key + " ");

				// push right and left child of y to second queue
				if (y.right != null) {
					second.add(y.right);
				}

				if (y.left != null) {
					second.add(y.left);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		String line = "";  
		String splitBy = ",";  
		Node root;
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("input.csv"));  
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] input = line.split(splitBy);    // use comma as separator  
	
		
		root = new Node(input[2]);
		root.left = new Node(input[2]);
		root.right = new Node(input[2]);
		root.left.left = new Node(input[2]);
		root.left.right = new Node(input[2]);
		root.right.left = new Node(input[2]);
		root.right.left.left = new Node(input[2]);
		printNodes(root);
		}  
		
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
		
		
	}
}