public interface Exchangeable {
    public double earthDollars = 1.00;
    public double marsMoney = 1.30;
    public double saturnSilver = 0.87;
    public double neptuneNuggets = 2.00;

    public void exchange(Currency other, double amount);
}
