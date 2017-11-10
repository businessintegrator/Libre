/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.businessintegrator.easy.tea.crypt.norm.fast.asymetric;

import java.math.BigInteger;

/**
 *
 * @author o
 */
public class Metrics {

    public final static String prime1 = "kcss921b6xitejl91dtna1q9btwkxogj03qux7myifrl90r3qj4tx0jgaw1xapxizh55r4kf51y5f5begzkebyfj3pz51msa64v";
    public final static String prime2 = "kcss921b6xitejl91dtna1q9btwkxogj03qux7myifrl90r3qj4tx0jgaw1xapxizh55r4kf51y5f5begzkebyfj3pz51msa6l1";

    public Metrics() {
    }

    public void timeInstantiation() {
        long t = System.currentTimeMillis();
        BigInteger p = new BigInteger(prime1, 36);
        long delta = System.currentTimeMillis() - t;
        System.out.println("instanciation " + delta + "; milliseconds");
    }

     public void timeDivision() {
        BigInteger p = new BigInteger(prime1, 36);
        BigInteger a = new BigInteger("kcss921b6xitejl91dtna1q9btwkxogj03qux7myifrl90r3qj4tx0jgaw1xapxizh55r4kf51y5f5begzkebyfj3pz51msa641", 36);
        BigInteger b = new BigInteger("kcss921b6xitejl91dtna1q9btwkxogj03qux7myifrl90r3qj4tx0jgaw1xapxizh55r4kf51y5f5begzkebyfj3pz51msa6", 36);
        long t = System.currentTimeMillis();
        BigInteger [] c = a.divideAndRemainder(b);
        long delta = System.currentTimeMillis() - t;
        System.out.println("division euclidienne;" + delta + "; milliseconds");

    }
    public void timeExponentiation() {
        BigInteger p = new BigInteger(prime1, 36);
        BigInteger a = new BigInteger("kcss921b6xitejl91dtna1q9btwkxogj03qux7myifrl90r3qj4tx0jgaw1xapxizh55r4kf51y5f5begzkebyfj3pz51msa641", 36);
        BigInteger b = new BigInteger("3360", 36);
        long t = System.currentTimeMillis();
        BigInteger c = a.modPow(b, p);
        long delta = System.currentTimeMillis() - t;
        System.out.println("exponetiation;" + delta + "; milliseconds");

    }
    
     public void timePgcd() {
        BigInteger p = new BigInteger(prime1, 36);
        BigInteger q = new BigInteger(prime2, 36);
        
        long t = System.currentTimeMillis();
        BigInteger c = p.gcd(q);
        long delta = System.currentTimeMillis() - t;
        System.out.println("pgcd;" + delta + " milliseconds"+ " "+c);

    }
     
      public void timeInverse() {
        BigInteger p = new BigInteger(prime1, 36);
        BigInteger q = new BigInteger(prime2, 36);
        
        long t = System.currentTimeMillis();
        BigInteger c = p.modInverse(q);
        long delta = System.currentTimeMillis() - t;
        System.out.println("inverse;" + delta + " milliseconds"+ " "+c);

    }

    public static void main(String[] args) {
        Metrics m = new Metrics();
        m.timeInstantiation();
        m.timeDivision();
        m.timeExponentiation();
        m.timePgcd();
    }
}
