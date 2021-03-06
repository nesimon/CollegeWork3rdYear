import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BinaryTreeTest
{
     
	 @Test
     public void testPut()
     {
    	 BinaryTree<Integer, Integer> bst = new BinaryTree<Integer, Integer>();
    	 bst.put(1, 7);
		 bst.put(2, 8);
		 bst.put(3, 9);
		
    	 assertEquals(8, (int)bst.get(2));
    	 assertEquals(9, (int)bst.get(3));
     }
		
     @Test
     public void testLca1()
     {
    	 BinaryTree<Integer, Integer> bst = new BinaryTree<Integer, Integer>();
    	 bst.put(1, 1);
		 bst.put(2, 2);
		 bst.put(3, 3);
		 bst.put(4, 4);
		 bst.put(5, 5);
		 bst.put(6, 6);
		 bst.put(8, 8);
		
    	 assertEquals(4, (int)bst.lca(4,8));
    	 assertEquals(1, (int)bst.lca(1,8));
     }
     
     @Test
     public void testLca2()
     {
    	 BinaryTree<Integer, Integer> bst = new BinaryTree<Integer, Integer>();
    	 bst.put(6, 6);
		 bst.put(5, 2);
		 bst.put(1, 3);
		 bst.put(2, 4);
		 bst.put(7, 5);
		 bst.put(7, 6);
		 bst.put(11, 11);
		 bst.put(8, 8);
		 bst.put(10, 10);
		 bst.put(9, 9);
		 bst.put(4, 4);
		
		 assertTrue(bst.contains(11));
    	 assertEquals(6, (int)bst.lca(4,9));
     }
     
     @Test
     public void testLca3()
     {
    	 BinaryTree<Integer, Integer> bst = new BinaryTree<Integer, Integer>();	
		 assertNull(bst.lca(4,9));
		 assertNull(bst.get(4));
		 assertTrue(bst.isEmpty());
		 
		 bst.put(6, 6);
		 bst.put(7, 7);
		 bst.put(5, 5);
		 
		 assertEquals(6, (int)bst.lca(5,7));
		 assertNull(bst.lca(4,9));
     }
     
     @Test
     public void testLca4()
     {
    	 BinaryTree<Integer, Integer> bst = new BinaryTree<Integer, Integer>();    	 
    	 bst.put(6, 6);
		 bst.put(5, 2);
		 bst.put(1, 3);
		 bst.put(7, 3);
		 
		 assertEquals(4, bst.size());
     }
    
}

