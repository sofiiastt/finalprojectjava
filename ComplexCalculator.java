import java.util.Scanner;

public class ComplexCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ComplexNumber num1 = readComplexNumber("Enter the first complex number:");
        ComplexNumber num2 = readComplexNumber("Enter the second complex number:");
        
        log("First complex number: " + num1);
        log("Second complex number: " + num2);

        ComplexNumber sum = num1.add(num2);
        ComplexNumber difference = num1.subtract(num2);
        ComplexNumber product = num1.multiply(num2);
        ComplexNumber quotient = num1.divide(num2);

        log("Sum: " + sum);
        log("Difference: " + difference);
        log("Product: " + product);
        log("Quotient: " + quotient);
    }

    private static ComplexNumber readComplexNumber(String message) {
        System.out.println(message);
        double real = scanner.nextDouble();
        double imaginary = scanner.nextDouble();
        return new ComplexNumber(real, imaginary);
    }

    private static void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    public String toString() {
        if (this.imaginary < 0) {
            return this.real + " - " + (-this.imaginary) + "i";
        } else {
            return this.real + " + " + this.imaginary + "i";
        }
    }
}