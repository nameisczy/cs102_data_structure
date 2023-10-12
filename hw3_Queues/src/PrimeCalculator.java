public class PrimeCalculator {

    public PrimeCalculator() {}

    public void primesTo(int num) throws IllegalArgumentException {
        if (num < 2) {
            throw new IllegalArgumentException("Input must be a number greater than or equal to 2.");
        }

        ArrayQueue<Integer> numbers = new ArrayQueue<>(num - 1);
        ArrayQueue<Integer> primes = new ArrayQueue<>();

        for (int i = 2; i <= num; i++) {
            numbers.enqueue(i);
        }

        while (!numbers.isEmpty()) {
            int p = numbers.dequeue();
            primes.enqueue(p);

            int size = numbers.size();
            for (int i = 0; i < size; i++) {
                int n = numbers.dequeue();
                if (n % p != 0) {
                    numbers.enqueue(n);
                }
            }
        }
        printPrimes(primes, num);
    }

    private void printPrimes(ArrayQueue<Integer> primes, int num) {
        System.out.println("Printing primes up to " + num + ": ");
        while (!primes.isEmpty()) {
            System.out.print(primes.dequeue());
            if (primes.isEmpty()) {
                System.out.print("." + "\n");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new PrimeCalculator().primesTo(20);
        new PrimeCalculator().primesTo(2);
        new PrimeCalculator().primesTo(0);
    }
}
