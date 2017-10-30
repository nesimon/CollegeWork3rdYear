import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	@Test
    public void testPut()
    {
		DAG<Integer, Integer> dag = new DAG<Integer, Integer>();
   	 	dag.addChild(7, 7);
   	 	dag.addChild(8, 8);
   	 	dag.addChild(9, 9);
   	 	
   	 	assertEquals(8, (int)dag.search(8)); 	
    }

}
