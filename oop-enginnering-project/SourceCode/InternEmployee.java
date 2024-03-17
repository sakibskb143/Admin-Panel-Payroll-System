package SourceCode;

class InternEmployee extends Employee {
    private int durationInMonths;
    private double monthlyStipend;

    public InternEmployee(String name, int id, int durationInMonths, double monthlyStipend) {
        super(name, id);
        this.durationInMonths = durationInMonths;
        this.monthlyStipend = monthlyStipend;
    }

    @Override
    public double calculateSalary() {
        return monthlyStipend;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }
}
