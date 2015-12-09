package jsonNastyPaths;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Lloyd on 12/3/2015.
 */
@SuppressWarnings("serial")
public class NastyObject implements Serializable {
    private String theString;
    private int theInt;
    private Date theDate;

    public NastyObject(String aString, int anInt, Date aDate) {
        theString = aString;
        theInt = anInt;
        theDate = aDate;
    }

    public NastyObject(HashMap aMapRepresentation){
        this.theString = (String)aMapRepresentation.get("theString");
        //dates are stored as timestamp strings.
        String stampString = (String)aMapRepresentation.get("theDate");
        this.theDate = new Date(Timestamp.valueOf(stampString).getTime());
        //numbers are stored as longs or doubles.
        Long asLong = (Long)aMapRepresentation.get("theInt");
        this.theInt = asLong.intValue();

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NastyObject other = (NastyObject) obj;
        if (theDate == null) {
            if (other.theDate != null)
                return false;
        } else if (!theDate.equals(other.theDate)){
            System.out.println("failed: "+theDate+" "+other.theDate);
            return false;
        }
        if (theInt != other.theInt)
            return false;
        if (theString == null) {
            if (other.theString != null)
                return false;
        } else if (!theString.equals(other.theString))
            return false;
        return true;
    }

}