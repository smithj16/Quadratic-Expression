package com.company;

/** The QuadraticExpression Java application performs
 * various task using a quadratic expression
 * @author
 *    Jacob Smith
 **/
 public class QuadraticExpression implements Cloneable{

    private double a;
    private double b;
    private double c;

    /** initialize instance variables to zero when object is created
     */
    public QuadraticExpression (){
        // nothing here
    }

    /** initialize instance variables when object is created
     * @param newA
     *   double value for ax^2
     * @param newB
     *   double value for bx
     * @param newC
     *   double value for c
     */
    public QuadraticExpression(double newA, double newB, double newC){
        a = newA;
        b = newB;
        c = newC;
    }

    /** Converts the quadratic expression to a string
     * @return
     *    the quadratic converted to a string
     */
    public String toString(){
        return a + "x^2 + " + b + "x + " + c;
    }

    /** evaluates the quadratic expression ax^2 + bx + c
     * at the the double value of x
     * @param x
     *   a double value for x
     * @return
     *   a double value for the quadratic expression evaluated at x
     */
    public double evaluate(double x){

        return ((a*(x * x))+(b*x)+(c));
    }

    /** assigns a to the new value of a
     *
     * @param newA
     *    new double value for a
     */
    public void setA(double newA){

        a = newA;
    }

    /** assigns b to the new value of b
     *
     * @param newB
     *  new double value for b
     */
    public void setB(double newB){
        b = newB;
    }

    /** assigns c to the new value of c
     *
     * @param newC
     *   new double value for c
     */
    public void setC(double newC){

        c = newC;
    }

    /** scales the quadratic expression by r
     *
     * @param r
     *   double value that the quadratic expression is scaled by
     * @param q
     *   reference variable to the object that stores the quadratic expression
     * @return
     *   return a new quadratic expression that is r times q
     */
    public static QuadraticExpression scale( double r, QuadraticExpression q ){
        QuadraticExpression q1 = new QuadraticExpression(r*q.a,r*q.b,r*q.c);
        return q1;
    }

    /** calculates the number of roots a quadratic expression may have
     * @return
     *   returns the number of roots a quadratic expression may have
     */
    public int numberOfRoots(){

        if (a == 0 && b == 0 && c == 0){

            return 3;
        }
        else if (a == 0 && b ==  0 && c != 0 ){

            return 0;
        }
        else if (a == 0 && b != 0){

            return 1;
        }
        else if ((a != 0) && ((b*b)< 4*(a*c)) ) {

            return 0;
        }
        else if ( a != 0 && ((b*b) == 4*(a*c))){

            return 1;
        }

        else if ( a != 0 && ((b*b) > 4*(a*c))){

            return 2;
        }

        return -1;
    }

    /** calculates the sum of to quadratic expressions
     *
     * @param q1
     *   reference variable to an object that contains a quadratic expression
     * @param q2
     *   reference variable to an object that contains a quadratic expression
     * @return
     *   returns a new expression that is the sum of the q1 and q2
     */
    public static QuadraticExpression add(QuadraticExpression q1, QuadraticExpression q2){
        QuadraticExpression q3 = new QuadraticExpression();
        q3.a = ((q1.a+ q2.a));
        q3.b = (q1.b+ q2.b);
        q3.c = (q1.c + q2.c);

        return q3;
    }

    /** adds q to the calling expression object
     *
     * @param q
     *   reference variable to the object that contains a quadratic expression
     */
    public void add(QuadraticExpression q){
        a = a + q.a;
        b = b + q.b;
        c = c + q.c;
    }

    /** finds the smaller root of a given quadratic expression
     * @throws ArithmeticException
     *   Indicates that the given quadratic expression has no real roots
     * @return
     *   returns the root if only one exist
     *   if two real roots, return the smaller one
     *   if infinite real roots, return -Double.MAX_VALUE
     *
     */
    public double smallerRoot(){
        if (a == 0 && b == 0 && c == 0){

            return -(Double.MAX_VALUE);
        }
        else if (a == 0 && b ==  0 && c != 0 ){
            throw new ArithmeticException("no real root.");
        }
        else if (a == 0 && b != 0){

            return (-c/b);
        }
        else if ((a != 0) && ((b*b)< 4*(a*c)) ) {
            throw new ArithmeticException("No real root.");
        }
        else if ( a != 0 && ((b*b) == 4*(a*c))){

            return (-b/(2*a));
        }

        else if ( a != 0 && ((b*b) > 4*(a*c))){
            double ans1, ans2;

            ans1 = (-b - (Math.sqrt((b*b)-4*(a*c)))) / (2*a);
            ans2 = (-b + (Math.sqrt((b*b)-4*(a*c)))) / (2*a);

            if (ans1 > ans2){
                return ans2;
            }
            else {
                return ans1;
            }

        }
        else
        return 0;
    }

    /** finds the larger root of a given quadratic expression
     * @throws ArithmeticException
     *   Indicates that the given quadratic expression has no real roots
     * @return
     *   returns the root if only one exist
     *   if two real roots, return the larger one
     *   if infinite real roots, return Double.MAX_VALUE
     *
     */
    public double largerRoot(){
        if (a == 0 && b == 0 && c == 0){

            return Double.MAX_VALUE;
        }
        else if (a == 0 && b ==  0 && c != 0 ){
            throw new ArithmeticException("no real root");
        }
        else if (a == 0 && b != 0){

            return (-c/b);
        }
        else if ((a != 0) && ((b*b)< 4*(a*c)) ) {
            throw new ArithmeticException("no real root");
        }
        else if ( a != 0 && ((b*b) == 4*(a*c))){

            return (-b/(2*a));
        }

        else if ( a != 0 && ((b*b) > 4*(a*c))){
            double ans1, ans2;

            ans1 = (-b - (Math.sqrt((b*b)-4*(a*c)))) / (2*a);
            ans2 = (-b + (Math.sqrt((b*b)-4*(a*c)))) / (2*a);

            if (ans1 > ans2){
                return ans1;
            }
            else {
                return ans2;
            }

        }
        else
        return 0;
    }

    /** compares the instance variables of the calling object to instance variables of another object
     * @param o
     *   reference variable to the Object class
     * @return
     *   returns true if the instance variables are equal
     *   returns false if the instance variables are not equal
     *   returns false if o is not an instance of the QuadraticExpression class
     */

    public boolean equals(Object o){


        if(!(o instanceof QuadraticExpression))
            return false;

         QuadraticExpression q = (QuadraticExpression) o;

        return ((q.a == a)&& (q.b == b) && (q.c == c));

    }

    /** creates a reference variable to a new object that is the copy of the calling object
     * @return
     *   returns a copy of the calling object
     */
    public QuadraticExpression clone(){
        QuadraticExpression q1;

        try {
            q1 = (QuadraticExpression) super.clone();
        }

        catch (CloneNotSupportedException e){
            throw new RuntimeException("This class does not implement cloneable");
        }

        return q1;
    }



}


