public class Saturn extends Currency {
    public Saturn(double totalFunds) {
        super("SaturnSilver", totalFunds);
    }
    
    @Override
    public String getName() {
        return Saturn.class.getSimpleName();
    }

    @Override
    public double toEarthDollars(double amount) {
        return amount / Exchangeable.saturnSilver;
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
        return EarthDollars * Exchangeable.saturnSilver;
    }

    @Override
    public void exchange(Currency other, double amount) {
        String amountFormat = String.format("%.2f", amount);

        if (amount > this.getTotalFunds()) {
            System.out.println("Uh oh - " + this.getName() + " only has an available balance of " + String.format("%.2f", this.getTotalFunds()) + ", which is less than " + amountFormat + "!");
            System.out.println();
            return;
        }

        System.out.println("Converting from SaturnSilver to " + other.currencyName + " and initiating transfer...");

        Double toEarthDollars = this.toEarthDollars(amount);
        Double fromEarthDollars = other.fromEarthDollars(toEarthDollars);

        String toEarthDollarsFormat = String.format("%.2f", toEarthDollars);
        String fromEarthDollarsFormat = String.format("%.2f", fromEarthDollars);

        System.out.println(amountFormat + " SaturnSilver = " + toEarthDollarsFormat + " EarthDollars = " + fromEarthDollarsFormat + " " + other.currencyName);
        System.out.println("Saturn exchange fee is 0.00 SaturnSilver");

        Double saturnTotalFunds = this.getTotalFunds() - amount;
        Double otherTotalFunds = other.getTotalFunds() + fromEarthDollars;

        this.setTotalFunds(saturnTotalFunds);
        other.setTotalFunds(otherTotalFunds);

        System.out.println("Saturn has a total of " + String.format("%.2f", this.getTotalFunds()) + " SaturnSilver");
        System.out.println(other.getName() + " has a total of " + String.format("%.2f", other.getTotalFunds()) + " " + other.currencyName);
        System.out.println();
    }
}
