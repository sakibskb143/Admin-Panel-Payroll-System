package SourceCode;

class ContractorEmployee extends Employee {
    private int contractDuration;
    private double hourlyRate;

    public ContractorEmployee(String name, int id, int contractDuration, double hourlyRate) {
        super(name, id);
        this.contractDuration = contractDuration;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        // Assuming contractor gets paid based on hours worked
        return contractDuration * 4 * 40 * hourlyRate; // Assuming 4 weeks per month and 40 hours per week
    }
}
