package hr.fer.oop.swing2.workers.properties;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.SwingWorker;

public class PrimeNumbersWorker extends SwingWorker<List<Integer>, Integer> {

    private final int numberOfPrimes;
	private Consumer<List<Integer>> chunksProcessor;
	private Runnable onDone;

	
    /**
     * @param numberOfPrimes Number of prime numbers to calculate
     * @param chunksProcessor consumer of chunks produced by this worker
     * @param onDone an action to be run after this worker is finished
     */
    public PrimeNumbersWorker(int numberOfPrimes, 
    		Consumer<List<Integer>> chunksProcessor,
    		Runnable onDone
    		) 
    {
        this.numberOfPrimes = numberOfPrimes;
		this.chunksProcessor = chunksProcessor;
		this.onDone = onDone;
    }

    @Override
    protected List<Integer> doInBackground() throws Exception {
        List<Integer> primeNumbers = new LinkedList<>();

        int count = 0;
        int number = 2;
        boolean isPrime;

        while (count < numberOfPrimes) {
            isPrime = true;

            int limit = (int) Math.sqrt(number);
            for (int divisor = 2; divisor <= limit; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;

                primeNumbers.add(number);

                //set progress
                setProgress(100 * count / numberOfPrimes);
                //publish prime number
                publish(number);

                //slow down the thread
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            number++;
        }

        return primeNumbers;
    }

    @Override
    protected void process(List<Integer> chunks) {
        chunksProcessor.accept(chunks);
    }

    @Override
    protected void done() {
        onDone.run();
    }
}