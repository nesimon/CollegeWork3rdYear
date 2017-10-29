/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author Neil Simon
 *
 *************************************************************************/

public class DAG<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node parent;
        private Node[] children;   // subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.children[0] = null;
        }
    }
    
    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Node search(Key key) 
    { 
    	return search(root, key);
    }

    private Node search(Node x, Key key)
    {
        if (x == null) return null;
        if (x.key == key) return x;
        Node answer = x;
    	int index = 0;
    	while(x.children[index] != null)
    	{   		
    		answer = search(x.children[index], x.key);
    		if (answer.key == key) return answer;
    		index++;
    	}
    	return answer;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void addChild(Key key, Value val) 
    {
        root = addChild(root, key, val);
    }

    private Node addChild(Node x, Key key, Value val) 
    {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
        {
        	x.parent = new Node(key, val);
        	root = x.parent;
        	root.children[0] = x;
        }
        else if (cmp > 0)
        {
        	boolean notFilled = true;
        	int index = 0;
        	while(notFilled)
        	{
        		if (x.children[index] == null)
            	{
            		x.children[index] = new Node(key, val);
            		x.children[index+1] = null;
            		x.children[index].parent = x;
            		notFilled = false;
            	}
        		index++;
        	}
        }
        else
        {
        	x.val = val;
        }

        return x;
    }
    
 
}
