package com.example.user.simple_calculator;

import android.util.Log;

import java.util.Stack;
import java.util.StringTokenizer;

public class EvaluateString
{
    public static String evaluateInfix(String exps)
    {
        exps = exps.replaceAll("\\s+", "");

        Stack<String> stack = new Stack<String>();

        StringTokenizer tokens = new StringTokenizer(exps, "{}()*/+-", true);
        while(tokens.hasMoreTokens()){
            String tkn = tokens.nextToken();
            /**read each token and take action**/
            if(tkn.equals("(")
                    || tkn.equals("{")
                    || tkn.matches("[0-9]+")
                    || tkn.equals("*")
                    || tkn.equals("/")
                    || tkn.equals("+")
                    || tkn.equals("-")){
                /**push token to the stack**/
                stack.push(tkn);
            } else if(tkn.equals("}") || tkn.equals(")")){
                try {
                    int op2 = Integer.parseInt(stack.pop());
                    String oprnd = stack.pop();
                    int op1 = Integer.parseInt(stack.pop());
                    /**Below pop removes either } or ) from stack**/
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    int result = 0;
                    if(oprnd.equals("*")){
                        result = op1*op2;
                    } else if(oprnd.equals("/")){
                        result = op1/op2;
                    } else if(oprnd.equals("+")){
                        result = op1+op2;
                    } else if(oprnd.equals("-")){
                        result = op1-op2;
                    }
                    /**push the result to the stack**/
                    stack.push(result+"");
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        String finalResult = "";
        try {
            finalResult = stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalResult;
    }



}
