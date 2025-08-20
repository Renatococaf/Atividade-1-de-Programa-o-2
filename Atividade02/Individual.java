package Atividade02;

// Subclasse para representar uma pessoa física
class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        // Regras para pessoa física
        if (getAnnualIncome() < 20000.00) {
            return getAnnualIncome() * 0.15 - (healthExpenditures * 0.5);
        } else {
            return getAnnualIncome() * 0.25 - (healthExpenditures * 0.5);
        }
    }

}
