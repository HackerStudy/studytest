package com.hackerstudy.studytest.exception;

/**
 * @class: ExceptionMain
 * @description: 异常测试类
 * @author: Administrator
 * @date: 2019-06-21 09:09
 */
public class ExceptionMain {

    public static void main(String[] args) {
        try{
            lose2Exception();
            loseException();
            //repeatNewException(10,0);
            //repeatException(10,0);
            //calculate(10,0);
            //new CreateException().createException();
        }catch(CalculateException e){
            e.printStackTrace(System.out);
        }catch(ArithmeticException e){
            e.printStackTrace(System.out);
        }catch (Exception e){
            System.out.println("异常处理");
            System.out.println("getMessage:"+e.getMessage());
            System.out.println("getLocalizedMessage:"+e.getLocalizedMessage());
            System.out.println("toString:"+e.toString());
            System.out.println("printStackTrace:");
            e.printStackTrace();
            System.out.println("getClass:"+e.getClass());
            System.out.println("getName:"+e.getClass().getName());
            System.out.println("getSimpleName:"+e.getClass().getSimpleName());
            System.out.println("获取该异常的调用方法:");
            for(StackTraceElement ste:e.getStackTrace()){
                System.out.println(ste.getMethodName());
            }
        }
    }

    /**
     * 计算
     */
    public static int calculate(int a,int b) throws ArithmeticException{
        try {
            int result = a / b;
            return result;
        }catch (ArithmeticException e){
            throw new ArithmeticException("算法错误:"+e.getMessage());
        }
    }

    /**
     * 重新抛出异常（fillInStackTrace）
     */
    public static void repeatException(int a,int b) throws ArithmeticException{
        try{
            calculate(a,b);
        }catch (ArithmeticException e){
            //在原异常的基础上重新抛出新异常,fillInStackTrace是针对同一种异常
            throw (ArithmeticException) e.fillInStackTrace();
            //throw new ArithmeticException(e.getMessage());
        }
    }

    /**
     * 重新抛出新异常(异常链)
     */
    public static void repeatNewException(int a,int b) throws CalculateException{
        try{
            calculate(a,b);
        }catch (ArithmeticException e){
            //throw new CalculateException(e.getMessage());
            CalculateException calculateException =new CalculateException("除法计算异常");
            calculateException.initCause(e);
            throw calculateException;
        }
    }

    /**
     * 异常丢失(return)
     */
    public static void loseException() throws Exception{
        try{
            throw new Exception("Exception A");
        }finally {
            return;
        }
    }

    /**
     * 异常丢失(在finally中抛出新异常)
     */
    public static void lose2Exception() throws Exception{
        try{
            throw new Exception("Exception A");
        }finally {
            throw new Exception("Exception B");
        }
    }
}
