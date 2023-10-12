public class Neptune extends Currency {
    public Neptune(double totalFunds) {
        super("NeptuneNuggets", totalFunds);
    }
    
    @Override
    public String getName() {
        return Neptune.class.getSimpleName();
    }

    @Override
    public double toEarthDollars(double amount) {
        return amount / Exchangeable.neptuneNuggets;
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
        return EarthDollars * Exchangeable.neptuneNuggets;
    }

    @Override
    public void exchange(Currency other, double amount) {
        String amountFormat = String.format("%.2f", amount);

        if (amount > this.getTotalFunds()) {
            System.out.println("Uh oh - " + this.getName() + " only has an available balance of " + String.format("%.2f", this.getTotalFunds()) + ", which is less than " + amountFormat + "!");
            System.out.println();
            return;
        }

        if (amount + 5 > this.getTotalFunds()) {
            System.out.println("Not enough available balance to pay the exchange fee");
            System.out.println();
            return;
        } 

        System.out.println("Converting from NeptuneNuggets to " + other.currencyName + " and initiating transfer...");

        Double toEarthDollars = this.toEarthDollars(amount);
        Double fromEarthDollars = other.fromEarthDollars(toEarthDollars);

        String toEarthDollarsFormat = String.format("%.2f", toEarthDollars);
        String fromEarthDollarsFormat = String.format("%.2f", fromEarthDollars);

        System.out.println(amountFormat + " NeptuneNuggets = " + toEarthDollarsFormat + " EarthDollars = " + fromEarthDollarsFormat + " " + other.currencyName);
        System.out.println("Neptune exchange fee is " + String.format("%.2f", 5.0) + " NeptuneNuggets");

        Double neptuneTotalFunds = this.getTotalFunds() - amount - 5;
        Double otherTotalFunds = other.getTotalFunds() + fromEarthDollars;

        this.setTotalFunds(neptuneTotalFunds);
        other.setTotalFunds(otherTotalFunds);

        System.out.println("Neptune has a total of " + String.format("%.2f", this.getTotalFunds()) + " NeptuneNuggets");
        System.out.println(other.getName() + " has a total of " + String.format("%.2f", other.getTotalFunds()) + " " + other.currencyName);
        System.out.println();
    }
}
