import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BinaryTreeTest
{
     
     @Test
     public void testLca()
     {
    	 BinaryTree<Integer, Integer> bst = new BinaryTree<Integer, Integer>();
    	 bst.put(1, 1);
		 bst.put(2, 2);
		 bst.put(3, 3);
		 bst.put(4, 4);
		 bst.put(5, 5);
		 bst.put(6, 6);
		 bst.put(8, 8);
		
    	 assertEquals(6, (int)bst.lca(8,6));
     }
     

     
     
}

