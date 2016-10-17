package com.dataguess;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shiyanghuang on 16/10/12.
 */
public class cmserverTest {
    public static List<URI> getCMServersAsURIList(String cmServersStr) {

        String[] cmServers = cmServersStr.split(",", -1);
        List<URI> listUris = new LinkedList<URI>();
        for (String server : cmServers) {
            server = server.trim();
            if (!server.equals("")) {
                if (server.indexOf(':') != -1) {
                    // listUris.add(new URI("http://" + server));
                    try {
                        System.out.println("http://" + server + "/pools");
                        listUris.add(new URI("http://" + server + "/pools"));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new IllegalArgumentException(
                            "cmservers property must follow the format - <ip/hostname>:<port>,<ip/hostname>:<port>,<ip/hostname>:<port>");
                }
            }
        }
        return listUris;
    }

    public static void main(String[] args) {
        String ip = " 192.168.5.230:8091 ";
        // String ip = null;
        getCMServersAsURIList(ip);

    }
}
