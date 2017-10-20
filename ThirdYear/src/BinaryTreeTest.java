import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BinaryTreeTest
{
     
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
		
    	 assertEquals(6, (int)bst.lca(4,9));
     }
     

     
     
}

