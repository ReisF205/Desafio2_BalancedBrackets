/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2_balancedbracketscheck;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 * @author Clarissa
 */
public class Desafio2_BalancedBracketsCheck {

    /**
     * @param args the command line arguments
     */
        
    static boolean areBracketsBalanced(String expr)  throws Exception
    {
        Deque<Character> pilha = new ArrayDeque<>();
 
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                pilha.push(x);
                continue;
            }
			
            if (pilha.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = pilha.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = pilha.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = pilha.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        return (pilha.isEmpty());
    }
 
    public static void main(String[] args) throws Exception 
    {        
      
        File arq = new File("Entrada.txt");        
        ArrayList<String> entrada = new ArrayList<>();
        StringBuilder construtor = new StringBuilder();
        
        if (arq.exists()) 
        {
            Scanner dig = new Scanner(arq);
            
            while (dig.hasNext())
            {
               entrada.add(dig.nextLine());
            }            
        }
        
        arq = new File("SaidaValidada.txt");
                arq.createNewFile();
                try (FileWriter script = new FileWriter("SaidaValidada.txt")) {
                    script.write(construtor.toString());
                }
                System.out.print(construtor.toString());
                System.out.println("\nArquivo Validado criado");
    }
   
}
