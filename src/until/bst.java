package until;

import java.util.Arrays;

public class bst {
	static class Node {
		public int key;
		public int left_height;
		public int right_height;
		public int height;
		public Node parent;
		public Node left_child;
		public Node right_child;

		public Node(Node parent, Node left_child, Node right_child, int key) {
			super();
			this.parent = parent;
			this.left_child = left_child;
			this.right_child = right_child;
			this.key = key;
		}

		public Node(int key) {
			this(null, null, null, key);
		}

	}

	private Node root;

	public bst() {
		this.root = null;
	}

	public bst(int[] keys) {
		Arrays.sort(keys);
		this.root = treeNode(keys, 0, keys.length - 1);

	}

	public Node treeNode(int[] keys, int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		Node root = new Node(keys[mid]);
		root.left_child = treeNode(keys, left, mid - 1);
		root.right_child = treeNode(keys, mid + 1, right);
		return root;
	}

	public int predecessor(int q) {
		int p = -1;
		if (root == null) {
			return p;
		}
		Node node = root;
		while (node != null) {
			if (node.key == q) {
				p = q;
				return p;
			} else if (node.key > q) {
				node = node.left_child;
			} else {
				p = node.key;
				node = node.right_child;
			}
		}

		return p;
	}

	private Node successor(Node node) {
		Node successor = null;
		Node successorParent = null;
		Node current = node.right_child;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left_child;
		}
		if (successor != node.right_child) {
			successorParent.left_child = successor.right_child;
			successor.right_child = node.right_child;
		}
		return successor;
	}

	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		node.left_height = getHeight(node.left_child);
		node.right_height = getHeight(node.right_child);
		node.height = Math.max(node.left_height, node.right_height) + 1;
		return node.height;
	}

	public void insert(int q) {
		root = insert(q, root);
	}

	public Node insert(int q, Node t) {
		Node node = new Node(q);
		if (t == null) {
			return node;
		}
		if (q < t.key) {
			t.left_child = insert(q, t.left_child);
		} else {
			t.right_child = insert(q, t.right_child);
		}
		getHeight(t);
		return banlance(t);
	}

	public boolean delete(int q) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while (current != null && current.key != q) {
			parent = current;
			if (current.key > q) {
				isLeftChild = true;
				current = current.left_child;
			} else {
				isLeftChild = false;
				current = current.right_child;
			}
		}
		if (current == null) {
			return false;
		}
		// Case 1: if node to be deleted has no children
		if (current.left_child == null && current.right_child == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.left_child = null;
			} else {
				parent.right_child = null;
			}
			// Case 2: if node to be deleted has only one child
		} else if (current.right_child == null) {
			if (current == root) {
				root = current.left_child;
			} else if (isLeftChild) {
				parent.left_child = current.left_child;
			} else {
				parent.right_child = current.left_child;
			}
		} else if (current.left_child == null) {
			if (current == root) {
				root = current.right_child;
			} else if (isLeftChild) {
				parent.left_child = current.right_child;
			} else {
				parent.right_child = current.right_child;
			}
			// Case 3: current.left != null && current.right != null
		} else {
			Node successor = successor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left_child = successor;
			} else {
				parent.right_child = successor;
			}
			successor.left_child = current.left_child;
		}
		banlance(root);
		return true;
	}

	public int find_min(Node t) {
		if (t.left_child == null) {
			return t.key;
		} else {
			return find_min(t.left_child);
		}
	}

	public Node banlance(Node t) {
		if (Math.abs(t.left_height - t.right_height) <= 1) {
			return t;
		} else if (t.left_height < t.right_height) {
			if (t.right_child.left_height < t.right_child.right_height) {
				return right_right(t);
			} else {
				return right_left(t);
			}
		} else {
			if (t.left_child.left_height > t.left_child.right_height) {
				return left_left(t);
			} else {
				return left_right(t);
			}
		}
	}

	//Case1: right_right banlance
	public Node right_right(Node oldroot) {
		Node newroot = oldroot.right_child;
		oldroot.right_child = newroot.left_child;
		newroot.left_child = oldroot;
		getHeight(oldroot);
		getHeight(newroot);
		return newroot;
	}

	//Case2: right_left banlance
	public Node right_left(Node oldroot) {
		oldroot.right_child = left_left(oldroot.right_child);
		getHeight(oldroot);
		return right_right(oldroot);
	}

	//Case3: left_left banlance
	public Node left_left(Node oldroot) {
		Node newroot = oldroot.right_child;
		oldroot.left_child = newroot.right_child;
		newroot.right_child = oldroot;
		getHeight(oldroot);
		getHeight(newroot);
		return newroot;
	}

	//Case4: left_right banlance
	public Node left_right(Node oldroot) {
		oldroot.left_child = right_right(oldroot.left_child);
		getHeight(oldroot);
		return left_left(oldroot);
	}

	public void show(Node t) {
		if (t == null) {
			return;
		}
		System.out.print(t.key);
		System.out.print("  ");
		show(t.left_child);
		show(t.right_child);
	}
}

