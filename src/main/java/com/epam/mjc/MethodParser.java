package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] arr = signatureString.split("\\(");
        String[] arr1 = arr[0].split("\\s+");

        StringBuilder accessModifier = null;
        StringBuilder returnType = null;
        StringBuilder methodName = null;

        if (arr1.length == 3){
            accessModifier = new StringBuilder(arr1[0]);
            returnType = new StringBuilder(arr1[1]);
            methodName = new StringBuilder(arr1[2]);
        }else{
            returnType = new StringBuilder(arr1[0]);
            methodName = new StringBuilder(arr1[1]);
        }

        List<MethodSignature.Argument> args = new ArrayList<>();
        String[] arr2 = arr[1].substring(0, arr[1].length() - 1).split(", ");
        for (String s: arr2){
            String[] sp = s.split("\\s+");
            if (sp.length != 2) continue;
            args.add(new MethodSignature.Argument(sp[0], sp[1]));
        }

        MethodSignature res = new MethodSignature(methodName.toString(), args);
        if (accessModifier != null)
            res.setAccessModifier(accessModifier.toString());
        res.setReturnType(returnType.toString());

        return res;
    }
}
