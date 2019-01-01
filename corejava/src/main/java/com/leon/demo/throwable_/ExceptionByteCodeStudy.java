package com.leon.demo.throwable_;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/12/31
 */
public class ExceptionByteCodeStudy {
    static int remainder(int dividend, int divisor)
            throws DivideByZeroException {
        try {
            return dividend % divisor;
        }
        catch (ArithmeticException e) {
            throw new DivideByZeroException();
        }
    }
}

/*

    The main bytecode sequence for remainder:
        0 iload_0               // Push local variable 0 (arg passed as divisor)
        1 iload_1               // Push local variable 1 (arg passed as dividend)
        2 irem                  // Pop divisor, pop dividend, push remainder
        3 ireturn               // Return int on top of stack (the remainder)
        The bytecode sequence for the catch (ArithmeticException) clause:
        4 pop                   // Pop the reference to the ArithmeticException
        // because it isn't used by this catch clause.
        5 new #5 <Class DivideByZeroException>
// Create and push reference to new object of class
// DivideByZeroException.
DivideByZeroException
        8 dup           // Duplicate the reference to the new
        // object on the top of the stack because it
        // must be both initialized
        // and thrown. The initialization will consume
        // the copy of the reference created by the dup.
        9 invokenonvirtual #9 <Method DivideByZeroException.<init>()V>
        // Call the constructor for the DivideByZeroException
        // to initialize it. This instruction
        // will pop the top reference to the object.
        12 athrow                // Pop the reference to a Throwable object, in this
// case the DivideByZeroException,
// and throw the exception.

*/


class DivideByZeroException extends Exception{

}
