
package Models.utilize;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class SHA
 * @autor tú
 */

public class SHA {

    /**
     * encrypt password using SHA-512 Algorithm
     * @param passwordToHash
     * @return encrypted Password
     */
    public static String encrypt(String passwordToHash) 
    {
        
//        passwordToHash = passwordToHash ;
        
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
           
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
       return generatedPassword;
    }
}
