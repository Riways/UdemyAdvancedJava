package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionEx1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class employeeClass = Class.forName("Reflection.Emloyee");
//        Class emolyeeClass2 = Emloyee.class;
//        Emloyee emloyee = new Emloyee(1, "Vasya", "IT", 3000 );
//        Class emloyeeClass3 = emloyee.getClass();
//        Field someField = employeeClass.getField("id");
//        System.out.println("Type of id field: " + someField.getType());
        Field[] notPrivateFields = employeeClass.getFields();
        for (Field field:
                notPrivateFields) {
            System.out.println("Type of "+field.getName() +" field: "+ field.getType());
        }
        System.out.println("++++++++++++++++++++");
        Field[] AllFields = employeeClass.getDeclaredFields();
        for (Field field:
                AllFields) {
            System.out.println("Type of "+field.getName() +" field: "+ field.getType());
        }
        Method someMethod = employeeClass.getMethod("setSalary");
        System.out.println("Return type metoda " + someMethod.getName() + " : " +
                someMethod.getReturnType() + ", parameter types = " +
                Arrays.toString(someMethod.getParameterTypes()));
//        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
//        System.out.println("Return type metoda " + someMethod2.getName() + " : " +
//                someMethod2.getReturnType() + ", parameter types = " +
//                Arrays.toString(someMethod2.getParameterTypes()));
        Method[] methods = employeeClass.getMethods();
        for (Method method:
             methods) {
            System.out.println(method.getName() + "  " +method.getReturnType()+ "  "+ method.getParameterTypes() );
        }


    }
}
