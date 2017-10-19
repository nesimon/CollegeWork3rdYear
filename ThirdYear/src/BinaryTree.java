/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author TODO
 *
 *************************************************************************/

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation: Log(n)
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    public int height() {
      //TODO fill in the correct implementation.
    	if(size() == 0)
    	{
    		return -1;
    	}
    	else
    	{
    		return height(root);
    	}
    }
    
    private int height(Node x)
    {
    	if (x == null) 
    	{
            return -1;
        }
    	int height1 = height(x.left);
        int height2 = height(x.right);

        if (height1 > height2) 
        {
            return height1 + 1;
        } 
        else 
        {
            return height2 + 1;
        }
    }
    
    public void delete(Key key) {
        //TODO fill in the correct implementation.
      	root = delete(root,key);
      }
      
      private Node delete(Node x, Key key)
      {
      	if(x == null)
      	{
      		return null;
      	}
      	int cmp = key.compareTo(x.key);
      	if(cmp < 0)
      	{
      		x.left = delete(x.left, key);
      	}
      	else if(cmp > 0)
      	{
      		x.right = delete(x.right, key);
      	}
      	else
      	{
      		if(x.right == null)
      		{
      			return x.left;
      		}
      		if(x.left == null)
      		{
      			return x.right;
      		}
      		Node t = x;
      		x = floor(x.left,x.left.key);
      		x.left = deleteFloor(x);
      		x.right = t.right;
      	}
      	x.N = size(x.left) + size(x.right) + 1;
      	return x;
      }
      
      private Node floor(Node x, Key key)
      {
      	if (x == null)
      	{
      		return null;
      	}
      	int cmp = key.compareTo(x.key);
      	if (cmp < 0)
      	{
      		return floor(x.left,key);
      	}
      	Node t = floor(x.right, key);
      	if(t != null)
      	{
      		return t;
      	}
      	else 
      	{
      		return x;
      	}
      }
      
      private Node deleteFloor(Node x)
      {
      	if(x.right == null)
      	{
      		return x.left;
      	}
      	x.N = 1 + size(x.left) + size(x.right);
      	return x;
      }

    
}
