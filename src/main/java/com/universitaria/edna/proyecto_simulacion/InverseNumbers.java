//package com.universitaria.edna.proyecto_simulacion;
//
//import java.util.Random;
//
//public class InverseNumbers {
//    private Random random1 = new Random();
//    public double inverse(){
//
//        double alpha = 10;
//        double beta = 10;
//        double sigConteo =RandomDigits(4);
//        sigConteo = salidaX(sigConteo, alpha, beta);
//        if (sigConteo.Equals(U))
//        {
//            sigConteo=  RandomDigits(4);
//        }
//        return  sigConteo;
//    }
//    public double RandomDigits(int length)
//    {
//        string s = string.Empty;
//        for (int i = 0; i < length; i++)
//            s = String.Concat(s, random.Next(1, 10).ToString());
//        return double.Parse(s);
//    }
//
//    public double salidaX(double U, double alpha, double beta)
//    {
//        double uaplicada = U / 10000;
//
//        double entreParentesis = (1 - uaplicada);
//
//        double logNatural = Math.Log(entreParentesis);
//
//        double porNegativo = logNatural * (-1);
//
//        double ElevadoAlpha = Math.Pow(porNegativo, (1 / alpha));
//
//        double x = beta * ElevadoAlpha;
//
//        return x;
//    }
//}
