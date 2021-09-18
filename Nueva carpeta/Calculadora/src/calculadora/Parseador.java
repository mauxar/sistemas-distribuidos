/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;
import java.util.Stack;

/**
 *
 * @author mauag
 */

public class Parseador {
    
private String ultimaParseada;


public Parseador(){ultimaParseada="0";}


public String parsear (String expr)  {
 String res="";
 expr=depurar(expr);
 String[] arrayInfix = expr.split(" ");

    //Declaración de las pilas
    Stack < String > E = new Stack < String > (); //Pila entrada
    Stack < String > P = new Stack < String > (); //Pila temporal para operadores
    Stack < String > S = new Stack < String > (); //Pila salida

    //Añadir la array a la Pila de entrada (E)
    for (int i = arrayInfix.length - 1; i >= 0; i--) { E.push(arrayInfix[i]);}
    

    try {
      //Algoritmo Infijo a Postfijo
      while (!E.isEmpty()) {
        switch (pref(E.peek())){
          
          case 1:
            P.push(E.pop());
            break;
          
          case 3:
          case 5:
          case 4:
            while(pref(P.peek()) >= pref(E.peek())) {
              S.push(P.pop());
            }
            P.push(E.pop());
            break; 
          
          case 2:
            while(!P.peek().equals("(")) {
              S.push(P.pop());
            }
            P.pop();
            E.pop();
            break; 
         
          default:
            S.push(E.pop()); 
        } 
      } 

      //Eliminacion de `impurezas´ en la expresiones algebraicas
      String infix = expr.replace(" ", "");
      String postfix = S.toString().replaceAll("[\\]\\[,]", "");

      //Mostrar resultados:
      System.out.println("Expresion Infija: " + infix);
      System.out.println("Expresion Postfija: " + postfix);
      res=postfix; 
    }catch(Exception ex){ 
      System.out.println("Error en la expresión algebraica");
      System.err.println(ex);
    }
 return  res;
  }

  //Depurar expresión algebraica
  private static String depurar(String s) {
    s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
    for(int i=0;i<s.length();i++) //agraga * a x()=x*()
        
    {if (s.charAt(i)=='('&&i!=0){if (s.charAt(i-1)=='0'||s.charAt(i-1)=='1'||s.charAt(i-1)=='2'
                               ||s.charAt(i-1)=='3'||s.charAt(i-1)=='4'||s.charAt(i-1)=='5'
                               ||s.charAt(i-1)=='6'||s.charAt(i-1)=='7'||s.charAt(i-1)=='8'||s.charAt(i-1)=='9'
                                 )
                              s=s.substring(0, i)+"*"+s.substring(i,s.length());                     
    
                           }
    
    }
    s = "(" + s + ")";
    String simbols = "+-*/%()^";
    String str = "";
  
    //Deja espacios entre operadores
    for (int i = 0; i < s.length(); i++) {
      if (simbols.contains("" + s.charAt(i))) {
        str += " " + s.charAt(i) + " ";
      }else str += s.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  } 

  //Jerarquia de los operadores
  private static int pref(String op) {
    int prf = 99;
    if (op.equals("^")) prf = 5;
    if (op.equals("*") || op.equals("/")|| op.equals("%")) prf = 4;
    if (op.equals("+") || op.equals("-")) prf = 3;
    if (op.equals(")")) prf = 2;
    if (op.equals("(")) prf = 1;
    return prf;
  }

public String evaluar(String expr){
    if(expr.equals("")) return ""; 
    
  String[] post = expr.split(" ");    
    
    //Declaración de las pilas
    Stack < String > E = new Stack < String > (); //Pila entrada
    Stack < String > P = new Stack < String > (); //Pila de operandos

    //Añadir post (array) a la Pila de entrada (E)
    for (int i = post.length - 1; i >= 0; i--) {
      E.push(post[i]);
    }

    //Algoritmo de Evaluación Postfija
    String operadores = "+-*/%^"; 
    while (!E.isEmpty()) {
      if (operadores.contains("" + E.peek())) {
       String a=P.pop();
       String b=(!P.isEmpty()) ?P.pop():"0";
      
       P.push(evaluar(E.pop(),a ,b) + "");
      }else {
        P.push(E.pop());
      } 
    }

    //Mostrar resultados:
    System.out.println("Expresion: " + expr);
    System.out.println("Resultado: " + P.peek());
  return P.peek();
  }

  private static float evaluar(String op, String n2, String n1) {
    float num1 = Float.valueOf(n1);
    float num2 = Float.valueOf(n2);
    if (op.equals("+")) return (num1 + num2);
    if (op.equals("-")) return (num1 - num2);
    if (op.equals("*")) return (num1 * num2);
    if (op.equals("/")) return (num1 / num2);
    if (op.equals("%")) return (num1 % num2);
    if (op.equals("^")) return (float)(Math.pow(num1, num2));
    return 0;
  }

}








