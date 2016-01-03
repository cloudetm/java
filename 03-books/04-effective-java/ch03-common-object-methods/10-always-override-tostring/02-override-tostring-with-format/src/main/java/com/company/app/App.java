package com.company.app;

import java.util.HashMap;
import java.util.Map;

/*
While it isn't as important as obeying the equals and hashCode contracts, providing a good toString implementation makes
your class much more pleasant to use.
 */
final class PhoneNumber{
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }
    private static void rangeCheck(int arg, int max, String name){
        if(arg < 0 || arg > max){
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof PhoneNumber)) return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }
    /*
    Returns the string representation of this phone number. The string consists of fourteen characters whose format is
    "(xxx) YYY-ZZZZ", where XXX is the area code, YYY is the prefix, and ZZZZ is the line number. (Each of the capital
    letters presents a single decimal digit.)
    If any of the three parts of this phone number is too small to fill up its field, the field is padded with leading
    zeros. For example, if the value of the line number is 123, the last four characters of the string representation
    will be "0123".
    Note that there is a single space separating the closing parenthesis after the area code from the first digit of
    the prefix.
     */
    @Override
    public String toString(){
        return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }
}
public class App
{
    public static void main( String[] args )
    {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(m);
    }
}
/*
output:
{(707) 867-5309=Jenny}
 */
