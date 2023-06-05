/**
 * # Main class to test various map.txt.
 */
public class Main {

	/**
	 * # main function.
	 * @param args # default parameter.
	 */
    public static void main(String args[]){
        
		long startTime = System.nanoTime(); 

        new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map01.txt", 500, 500)).start();
        //new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map02.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map03.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map04.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map05.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map06.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map07.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map08.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map09.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/map10.txt", 500, 500)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/pisa.txt", 1000, 1000)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/tokyo.txt", 1000, 1000)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/triumph.txt", 1000, 1000)).start();
		//new Thread(new TestCases("/Users/enesaysu/Desktop/hw8/TextFiles/vatican.txt", 1000, 1000)).start();

		long endTime = System.nanoTime();
        double runningTime = (endTime - startTime) / 1_000_000.0; 
        System.out.println("Running time: " + runningTime + " ms");
    }
}

