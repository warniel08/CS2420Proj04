/*
*   Warner Nielsen
*   2/11/19
*   Project 04
*   CS 2420
*   Garth Sorenson
* */


/*
*   This Polynomial class consists of several different functions to
*   display and/or manipulate a Polynomial or combination of two
*   Polynomials.
* */
package NielWarnProj04;

public class Polynomial {
    // Define Node class with data fields for coeff and power with a next Node
    class Node {
        int coeff_;
        int power_;
        Node next;
    }

    // Define HeadNode class with data field degree and Node next
    class HeadNode {
        int degree_;
        Node next;
    }

    HeadNode head; // headNode reference

    // Constructor for new Polynomial with data members initialized
    public Polynomial() {
        head = new HeadNode();
        head.degree_ = 0;
        head.next = null;
    }

    /*
    *   getCoefficient() takes in an argument for the power of the polynomial
    *   it returns an int representing the coefficient of that given power
    * */
    public int getCoefficient(int power) {
        if (head.next == null) {
            return 0;
        }

        Node curr = head.next;

        while (curr != null) {
            if (curr.power_ == power) {
                return curr.coeff_;
            }
            curr = curr.next;
        }
        return 0;
    }

    /*
    *   setCoefficient() takes in an int coefficient and int power
    *   it returns nothing, but it sets the coefficient_ data field
    *   to the new given coefficient according to the power that is
    *   given
    *   if there isn't any Node with the given coefficient and power,
    *   this method will insert the new Node in its proper place
    * */
    public void setCoefficient(int coeff, int power) {
        // create a curr reference and a newNode
        Node curr = head.next;
        Node newNode = new Node();

        // initialize the new node with coefficient and power input into the method
        newNode.coeff_ = coeff;
        newNode.power_ = power;

        if (head.degree_ < power) {
            head.degree_ = power;
        }

        if (head.next == null) {
            head.next = newNode;
            return;
        }

        while (curr.next != null && power < curr.power_) {
            curr = curr.next;
        }

        Node prev = curr;

        if (power == curr.power_) { // if the curr.next.power_ == power then set the curr.next.coeff_ == to coeff
            curr.coeff_ = coeff;
        } else if (curr.next == null) {
            // add new node to the end
            curr.next = newNode;
        } else if (head.next == prev){ // otherwise if head.next == prev then add newNode at beginning
            head.next = newNode;
            newNode.next = curr;
        }
    }

    /*
    *   Override the toString() method to print out the polynomial in the format:
    *      -3x^7+4x^3-2x^1-8
    * */

    @Override
    public String toString() {
        String s = new String();

        for (int i = head.degree_; i >= 0 ; i--) {
            if (i == head.degree_) {
                s += getCoefficient(i);
            } else if (getCoefficient(i) == 0) {
                continue;
            } else if (getCoefficient(i) >= 1) {
                s += "+" + getCoefficient(i);
            } else if (getCoefficient(i) < -1) {
                s += getCoefficient(i);
            } else if (getCoefficient(i) == -1) {
                s += " - 1";
            } else {
                s += " + 1";
            }
            if (i > 0) {
                s += "x^" + i;
            }
        }
        return s;
    }

    /*
    *   the evaluate function receives a term for x representing the
    *   x in the polynomial and does the multiplication and addition or
    *   subtraction to evaluate the polynomial
    *   it returns a double representing the value that is evaluated after
    *   substituting the given value for x
    * */
    public double evaluate(double x) {
        Node curr = head.next;
        double solvedPolynomial = 0;

        while (curr != null) {
            solvedPolynomial += getCoefficient(curr.power_) * java.lang.Math.pow(x, curr.power_);
            curr = curr.next;
        }
        return solvedPolynomial;
    }

    /*
    *   add will take another Polynomial called other or right hand side Polynomial
    *   and add like terms to the current Polynomial or left hand side, for example:
    *   (3x^2+3x^1) + (2x^2+1) becomes 5x^2+3x^1+1
    *   it returns the new Polynomial after the two have been added
    * */
    public Polynomial add(Polynomial other) {
        Polynomial combinedPoly = new Polynomial();
        int largestDegree;

        if (this.head.degree_ > other.head.degree_) {
            largestDegree = this.head.degree_;
        } else {
            largestDegree = other.head.degree_;
        }

        for (int i = largestDegree; i >= 0; i--) {
            combinedPoly.setCoefficient(getCoefficient(i) + other.getCoefficient(i), i);
        }

        return combinedPoly;
    }
}
