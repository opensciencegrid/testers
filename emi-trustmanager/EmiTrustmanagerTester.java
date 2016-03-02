import java.io.*;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.*;
import javax.net.ssl.*;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import org.glite.security.trustmanager.*;

public class EmiTrustmanagerTester {

    // Do not catch exceptions - let them go to stderr for manual debugging
    public static void main(String [] arguments) throws Exception {

        // Dynamically install the Bouncy Castle provider.  Many of the
        // trustmanager classes assume that the "BC" provider is installed.
        Security.addProvider(new BouncyCastleProvider());

        // Create a list of trust anchors for the trustmanager constructor.  It
        // probably should not be empty, but I do not know what it is supposed
        // to contain.  Appears to be instances of
        // java.security.cert.TrustAnchor, based on runtime errors.
        Vector trustAnchors = new Vector();

        // Make a trustmanager and do stuff with it.
        X509TrustManager trustmanager = new CRLFileTrustManager(trustAnchors);
        for (X509Certificate issuer : trustmanager.getAcceptedIssuers()) {
            System.out.println(issuer.getSubjectX500Principal().getName());
        }
    }

}
