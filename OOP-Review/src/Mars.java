public class Mars extends Currency {
    public Mars(double totalFunds) {
        super("MarsMoney", totalFunds);
    }

    @Override
    public String getName() {
        return Mars.class.getSimpleName();
    }

    @Override
    public double toEarthDollars(double amount) {
        return amount / Exchangeable.marsMoney;
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
        return EarthDollars * Exchangeable.marsMoney;
    }

    @Override
    public void exchange(Currency other, double amount) {
        String amountFormat = String.format("%.2f", amount);

        if (amount > this.getTotalFunds()) {
            System.out.println("Uh oh - " + this.getName() + " only has an available balance of " + String.format("%.2f", this.getTotalFunds()) + ", which is less than " + amountFormat + "!");
            System.out.println();
            return;
        }
        
        Double exchangeFee = amount * 0.1;

        if (amount + exchangeFee > this.getTotalFunds()) {
            System.out.println("Not enough available balance to pay the exchange fee");
            System.out.println();
            return;
        } 

        System.out.println("Converting from MarsMoney to " + other.currencyName + " and initiating transfer...");

        Double toEarthDollars = this.toEarthDollars(amount);
        Double fromEarthDollars = other.fromEarthDollars(toEarthDollars);

        String toEarthDollarsFormat = String.format("%.2f", toEarthDollars);
        String fromEarthDollarsFormat = String.format("%.2f", fromEarthDollars);

        System.out.println(amountFormat + " MarsMoney = " + toEarthDollarsFormat + " EarthDollars = " + fromEarthDollarsFormat + " " + other.currencyName);
        System.out.println("Mars exchange fee is " + String.format("%.2f", exchangeFee) + " MarsMoney");

        Double marsTotalFunds = this.getTotalFunds() - amount - exchangeFee;
        Double otherTotalFunds = other.getTotalFunds() + fromEarthDollars;

        this.setTotalFunds(marsTotalFunds);
        other.setTotalFunds(otherTotalFunds);

        System.out.println("Mars has a total of " + String.format("%.2f", this.getTotalFunds()) + " MarsMoney");
        System.out.println(other.getName() + " has a total of " + String.format("%.2f", other.getTotalFunds()) + " " + other.currencyName);
        System.out.println();
    }
}
