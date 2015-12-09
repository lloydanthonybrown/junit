package jsonNastyPaths;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Lloyd on 12/3/2015.
 */
public class NastyExamples {
    public static void main(String[] args){

        try {
        	/*
        	 * JSON file IO example.  Socket IO would be done the same way
        	 * except that the output and input streams would be retrieved
        	 * from a socket rather than created.
        	 */

            // Happy path: write to a current directory that I have rights to.

            // Nasty path: Tried to write to a directory in which I don't have write permissions.
            // Got this error:
            // java.io.FileNotFoundException: C:\ProgramData\Microsoft\SomeTextFile.txt (Access is denied)
            // FileOutputStream fout = new FileOutputStream("C:\\ProgramData\\Microsoft\\SomeTextFile.txt");

            // Nasty path: What happened when I tried to read from a file that didn't exist.
            // The error:
            // java.io.FileNotFoundException: C:\ProgramData\Microsoft\SomeFileName.someExtension (The system cannot find the file specified)
            // FileInputStream fin = new FileInputStream("C:\\ProgramData\\Microsoft\\SomeFileName.someExtension");

            // Nasty path: Trying to read from a directory that I don't have permissions in... ran into problems
            // because it wouldn't restrict me, even though I knew it should.
            // FileInputStream fin = new FileInputStream("C:\\ProgramData\\testingQCJSON\\SomeTextFile.txt");

            // Nasty path: If I put an empty string for the FileOutputStream (so, not telling it where to write),
            // it gives me this error: java.io.FileNotFoundException:
            // FileOutputStream fout = new FileOutputStream("");

            // Nasty path: use the fout twice, same location or different locations, see what happens.
            // It wrote to all the desired locations and specified files.
            // FileOutputStream fout = new FileOutputStream("C:\\ProgramData\\SomeTextFile.txt");
            // fout = new FileOutputStream("C:\\ProgramData\\SomeTextFile.png");

            // Nasty path: find a place that I can't write to, and see what happens.

            // Nasty path: See what happens when I duplicate the fin. Does it throw an error?
            // Ran this: FileInputStream fin = new FileInputStream("C:\\ProgramData\\testingQCJSON\\SomeTextFile.txt");
            // fin = new FileInputStream("C:\\ProgramData\\testingQCJSON\\SomeTextFile.txt");
            // Didn't hit any errors, so it compiled and ran. Returned this:
            // JSON: {"theString":"an example string","theInt":876543,"theDate":"2015-12-06 17:36:56.599"}

            // Nasty path: See what happens when I try to read from a null string.
            // I ran: FileInputStream fin = new FileInputStream("null");
            // java.io.FileNotFoundException: null (The system cannot find the file specified)

            // Nasty path: Try to write to a null..
            // I ran: FileOutputStream fout = new FileOutputStream(null);
            // Error:(67, 37) java: reference to FileOutputStream is ambiguous
            // both constructor FileOutputStream(java.io.File) in java.io.FileOutputStream and constructor
            // FileOutputStream(java.io.FileDescriptor) in java.io.FileOutputStream match

            // Nasty path: Try to write to a null string.
            // I ran: FileOutputStream fout = new FileOutputStream("null");
            // Error: org.quickconnectfamily.json.JSONException: Invalid JSON String

            // If I have this jsonOut.writeObject(anObject) run twice, it will not replace it, but will just duplicate
            // the output in the same file.
            // jsonOut.writeObject(anObject);

            // If I didn't use this statement at all, it doesn't throw an error, but it doesn't write anything to the desired
            // location, either.
            // jsonOut.writeObject(anObject);

            FileOutputStream fout = new FileOutputStream("C:\\ProgramData\\SomeTextFile.txt");
            FileInputStream fin = new FileInputStream("C:\\ProgramData\\SomeTextFile.txt");
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);

			/*
			 * An example serializable to be written out.  This could be
			 * any Java Collection or Map if you want to write out groups
			 * of serializables.
			 */
            Date exampleDate = new Date();
            NastyObject anObject = new NastyObject("an example string", 876543, exampleDate);


            jsonOut.writeObject(anObject);
            //since I wrote out an object I get a HashMap back.
            HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
            NastyObject readObject = new NastyObject(parsedJSONMap);
            System.out.println("stream same? "+readObject.equals(anObject));

			/*
			 * Stringify and parse example.  Use this if you are not using streams
			 * or you need to encrypt the JSON strings.
			 */

            String jsonString = JSONUtilities.stringify(anObject);
            System.out.println("JSON: "+jsonString);

            parsedJSONMap = (HashMap)JSONUtilities.parse(jsonString);
            readObject = new NastyObject(parsedJSONMap);
            System.out.println("stringify same? "+readObject.equals(anObject));

            //this is the quickconnectfamily JSONException not the standard one.
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}

