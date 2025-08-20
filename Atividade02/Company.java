package Atividade02;

class Company extends TaxPayer {
        private Integer numberOfEmployees;

        public Company(String name, Double annualIncome, Integer numberOfEmployees) {
            super(name, annualIncome);
            this.numberOfEmployees = numberOfEmployees;
        }

        @Override
        public Double tax() {
            // Regras para pessoa jurídica
            if (numberOfEmployees > 10) {
                return getAnnualIncome() * 0.14;
            } else {
                return getAnnualIncome() * 0.16;
            }
        }
    }
