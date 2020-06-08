package sbs.applitools.hackathon.test.uivalidation;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.dataProvider.TestState;


@TestState("LAPTOP_ALL")
public class FirstTest extends BaseTest {
	 
//	    public FirstTest(String target) {
//	        this.testTarget = target;
//	    }
//	 
//	    @BeforeClass
//	    public void beforeClass() {
//	        System.out.println("Before SimpleTest class executed.");
//	    }
//	 
//	    @Test
//	    public void testMethod() {
//	        System.out.println("testMethod parameter value is: " + testTarget.targetName);
//	    }
	    
	    
//		@Factory
//		public  Object[] getTestInstances() {
//			
//			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test_targets.json");
//			
//			System.out.println("**************In the test Factory**********************");
//			 
//			String TargetJson = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
//		      .lines()
//		      .collect(Collectors.joining("\n"));
//			 
//			List<Object> testList = new ArrayList<Object>();
//			TestTarget targets[] = (TestTarget[]) new JSONHelper().getObject(TargetJson, TestTarget[].class);
//			for(TestTarget target : targets) {
//				try {
//					// testList.add(this.class.getConstructor(this.class).newInstance(target));
//					testList.add(this.getClass().getConstructor(TestTarget.class).newInstance(target));
//				
//				} catch (Exception e) {
//					
//					e.printStackTrace();
//				}	
//			}			
//					
//			return testList.toArray();
//			
//			
//		}
	
}
